package AST.Visitor.SemanticCheck.SymbolTable;

import java.util.HashMap;

class GlobalSymbolTable
{
	private HashMap<String,ClassSymbolTable> classes;

	public GlobalSymbolTable()
	{
		classes = new HashMap<String,ClassSymbolTable>();
	}

	public boolean addClass(String key, ClassSymbolTable value)
	{
		ClassSymbolTable ret = classes.putIfAbsent(key,value);

		return ret==null;
	}

	public boolean containClass(String key)
	{
		return classes.containsKey(key);
	}

	public ClassSymbolTable getClass(String key)
	{
		return classes.get(key);
	}

	public boolean checkVarScope(String varName, String methodName, String className)
	{
		ClassSymbolTable c = classes.get(className);
		MethodSymbolTable m = c.getMethod(methodName);

		if (m.containsParam(varName))
			return true;
		if (m.containsVar(varName))
			return true;
		if(c.containsAttr(varName))
			return true;

		return false;
	}
}