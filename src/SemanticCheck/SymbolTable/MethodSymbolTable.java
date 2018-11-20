package SemanticCheck.SymbolTable;

import java.util.HashMap;
import java.util.Set;
import SemanticCheck.SymbolTable.SymbolTableVisitor;

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

	public Set<String> getParams()
	{
		return parameters.keySet();
	}

	public Set<String> getVars()
	{
		return variables.keySet();
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

	public void accept(SymbolTableVisitor v)
	{
		v.visit(this);
	}
}