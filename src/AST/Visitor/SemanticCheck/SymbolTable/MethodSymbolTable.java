package AST.Visitor.SemanticCheck.SymbolTable;

import java.util.HashMap;

public class MethodSymbolTable
{
	private final String methodName;
	private final String returnType;
	private HashMap <String,VariableSymbolTable> parameters;
	private HashMap <String,VariableSymbolTable> variables;

	public MethodSymbolTable(String methodName, String returnType)
	{
		this.methodName = methodName;
		this.returnType = returnType;

		parameters = new HashMap<String,VariableSymbolTable>();
		variables = new HashMap<String,VariableSymbolTable>();
	}

	public boolean addParam(String id, String type)
	{
		VariableSymbolTable ret = parameters.putIfAbsent(id, new VariableSymbolTable(id,type));

		return ret==null;
	}

	public boolean addVar(String id, String type)
	{
		VariableSymbolTable ret = variables.putIfAbsent(id, new VariableSymbolTable(id,type));

		return ret==null;
	}

	public boolean containsParam(String key)
	{
		return parameters.containsKey(key);
	}

	public boolean containsVar(String key)
	{
		return variables.containsKey(key);
	}

	public String getName()
	{
		return methodName;
	}

	public String getType()
	{
		return returnType;
	}

	public VariableSymbolTable getParam(String key)
	{
		return parameters.get(key);
	}

	public VariableSymbolTable getVar(String key)
	{
		return variables.get(key);
	}
}