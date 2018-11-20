package SemanticCheck.SymbolTable;

import java.util.Set;

public class SymbolTablePrinterVisitor implements SymbolTableVisitor
{
	private final String TAB ="|   ";
	private int ident;

	public SymbolTablePrinterVisitor()
	{
		ident = 0;
	}

	public String ident()
	{
		String ret = new String();

		for(int i=0;i<ident;i++)
			ret += TAB;

		return ret;
	}

	public void visit(GlobalSymbolTable t)
	{
		System.out.printf("Symbol Table\n");

		ident++;
		for(String ct : t.getClasses())
			t.getClass(ct).accept(this);
		ident--;
	}

	public void visit(ClassSymbolTable t)
	{
		System.out.printf("%sClass %s\n", ident(),t.getName());

		ident++;
		for(String ct : t.getAttrs())
		{
			System.out.printf("%sAttribute: ", ident());
			t.getAttr(ct).accept(this);
			System.out.println("");
		}

		for(String ct : t.getMethods())
			t.getMethod(ct).accept(this);
		ident--;
	}

	public void visit(MethodSymbolTable t)
	{
		System.out.printf("%sMethod %s, returns %s\n", ident(), t.getName(), t.getType());

		ident++;
		for(String ct : t.getParams())
		{
			System.out.printf("%sParameters: ", ident());
			t.getParam(ct).accept(this);
			System.out.println("");
		}

		for(String ct : t.getVars())
		{
			System.out.printf("%sVariables: ", ident());
			t.getVar(ct).accept(this);
			System.out.println("");
		}
		ident--;

	}

	public void visit(VariableSymbolTable t)
	{
		System.out.printf("%s, %s",t.getID(), t.getType());
	}
}