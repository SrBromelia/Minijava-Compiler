package AST.Visitor.SemanticCheck.SymbolTable;

import java.util.HashMap;

public class ClassSymbolTable
{
	private final String className;
	private HashMap<String,VariableSymbolTable> attributes;
	private HashMap<String,MethodSymbolTable> methods;

	public ClassSymbolTable(String className)
	{
		this.className = className;
		attributes = new HashMap<String,VariableSymbolTable>();
		methods = new HashMap<String,MethodSymbolTable>();
	}

	public boolean addAttr(String attrName, String attrType)
	{
		VariableSymbolTable ret = attributes.putIfAbsent(attrName, new VariableSymbolTable(attrName, attrType));

		return ret==null;
	}

	public boolean addMethod(String methodName, String returnType)
	{
		MethodSymbolTable ret = methods.putIfAbsent(methodName, new MethodSymbolTable(methodName, returnType));

		return ret==null;
	}
	
	public boolean addMethodParam(String methodName, String paramName, String paramType)
	{
		MethodSymbolTable m = methods.get(methodName);
		boolean ret = m.addParam(paramName,paramType);

		return ret;
	}

	public boolean addMethodVar(String methodName, String varName, String varType)
	{
		MethodSymbolTable m = methods.get(methodName);
		boolean ret = m.addVar(varName, varType);

		return ret;
	}

	public boolean containsAttr(String key)
	{
		return attributes.containsKey(key);
	}

	public boolean constainsMethod(String key)
	{
		return methods.containsKey(key);
	}

	public String getName()
	{
		return className;
	}

	public MethodSymbolTable getMethod(String key)
	{
		return methods.get(key);
	}

	public VariableSymbolTable getAttr(String key)
	{
		return attributes.get(key);
	}

	public String getMethodType(String key)
	{
		MethodSymbolTable m = methods.get(key);

		return m.getType();
	}
}