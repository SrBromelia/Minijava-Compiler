package SemanticCheck.SymbolTable;

import java.util.HashMap;
import java.util.Set;
import SemanticCheck.SymbolTable.SymbolTableVisitor;

public class GlobalSymbolTable
{
	private String main;
	private HashMap<String,ClassSymbolTable> classes;

	public GlobalSymbolTable()
	{
		classes = new HashMap<String,ClassSymbolTable>();
	}

	public GlobalSymbolTable(String mainClass)
	{
		classes = new HashMap<String,ClassSymbolTable>();

		classes.put(mainClass, new ClassSymbolTable(mainClass));
		main = mainClass;
	}

	public boolean addClass(String key)
	{
		ClassSymbolTable ret = classes.putIfAbsent(key,new ClassSymbolTable(key));

		return ret==null;
	}

	public boolean addClass(String name, String inherit)
	{
		ClassSymbolTable parent = classes.get(inherit);
		ClassSymbolTable ret = classes.putIfAbsent(name,new ClassSymbolTable(name, parent));

		if(classes.size() == 0)
			main = name;

		return ret==null;
	}

	public boolean containClass(String key)
	{
		return classes.containsKey(key);
	}

	public String getMain()
	{
		return main;
	}

	public ClassSymbolTable getClass(String key)
	{
		return classes.get(key);
	}

	public Set<String> getClasses()
	{
		return classes.keySet();
	}

	public int getSize()
	{
		return classes.size();
	}

	public String getType(String varName, String methodName, String className)
	{
		ClassSymbolTable c = classes.get(className);
		MethodSymbolTable m = c.getMethod(methodName);

		if (m.containsParam(varName))
			return m.getParam(varName).getType();

		if (m.containsVar(varName))
			return m.getVar(varName).getType();

		// c.containsAttr(varName)
		return c.getAttr(varName).getType();
	}

	public boolean isDeclared(String idName, String methodName, String className)
	{
		if(isVar(idName,methodName,className))
			return true;

		ClassSymbolTable c = classes.get(className);

		if(c!=null && c.containsMethod(idName))
				return true;

		return false;

	}

	public boolean isVar(String varName, String methodName, String className)
	{
		ClassSymbolTable c = classes.get(className);
		MethodSymbolTable m;

		if(c!= null)
		{
			m = c.getMethod(methodName);

			if(m!= null)
			{
				if (m.containsParam(varName))
					return true;
				if (m.containsVar(varName))
					return true;
			}

			if(c.containsAttr(varName))
					return true;
		}

		return false;
	}

	public boolean isMethod(String methodName, String className)
	{
		ClassSymbolTable c = classes.get(className);

		if(c!=null)
			if(c.containsMethod(methodName))
				return true;

		return false;
	}

	public void accept(SymbolTableVisitor v)
	{
		v.visit(this);
	}
}