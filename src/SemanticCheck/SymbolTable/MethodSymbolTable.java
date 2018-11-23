package SemanticCheck.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import SemanticCheck.SymbolTable.SymbolTableVisitor;

public class MethodSymbolTable
{
	private final String methodName;
	private final String returnType;
	private ArrayList <VariableSymbolTable> parameters;
	private HashMap <String,VariableSymbolTable> variables;

	public MethodSymbolTable(String methodName, String returnType)
	{
		this.methodName = methodName;
		this.returnType = returnType;

		parameters = new ArrayList<VariableSymbolTable>();
		variables = new HashMap<String,VariableSymbolTable>();
	}

	public boolean addParam(String id, String type)
	{
		return parameters.add(new VariableSymbolTable(id,type));
	}

	public boolean addVar(String id, String type)
	{
		VariableSymbolTable ret = variables.putIfAbsent(id, new VariableSymbolTable(id,type));

		return ret==null;
	}

	public boolean containsParam(String key)
	{
		for(int i=0;i<parameters.size();i++)
			if(parameters.get(i).getID().equals(key))
				return true;

		return false;
	}

	public boolean containsVar(String key)
	{
		return variables.containsKey(key);
	}

	public String getName()
	{
		return methodName;
	}

	public ArrayList<String> getParams()
	{
		ArrayList<String> params = new ArrayList<String>();

		for(VariableSymbolTable param : parameters)
			params.add(param.getID());

		return params;
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
		int ret = getParams().indexOf(key);

		return parameters.get(ret);
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