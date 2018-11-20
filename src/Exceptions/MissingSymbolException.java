public class MissingSymbolException extends Exception
{
	private String symbol;

	public MissingSymbolException(String symbol)
	{
		this.symbol = symbol;
	}

	public String toString()
	{
		return String.format("MissingSymbolException: The Symbol '%s' was not declared within the scope", symbol);
	}
}