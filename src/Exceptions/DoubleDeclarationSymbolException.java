public class DoubleDeclarationSymbolException extends Exception
{
	private String symbol;

	public DoubleDeclarationSymbolException(String symbol)
	{
		this.symbol = symbol;
	}

	public String toString()
	{
		return String.format("DoubleDeclarationSymbolException: The Symbol '%s' has been doubly declared.");
	}
}