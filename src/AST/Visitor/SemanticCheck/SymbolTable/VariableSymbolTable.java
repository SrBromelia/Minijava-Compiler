package AST.Visitor.SemanticCheck.SymbolTable;

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
}