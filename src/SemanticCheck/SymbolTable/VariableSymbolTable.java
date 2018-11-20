package SemanticCheck.SymbolTable;

import SemanticCheck.SymbolTable.SymbolTableVisitor;

public class VariableSymbolTable
{
	private final String identifier;
	private final String type;

	public VariableSymbolTable(String identifier, String type)
	{
		this.identifier = identifier;
		this.type = type;
	}

	public String getID()
	{
		return identifier;
	}

	public String getType()
	{
		return type;
	}

	public void accept(SymbolTableVisitor v)
	{
		v.visit(this);
	}
}