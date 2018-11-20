package AST.Visitor;

import AST.*;

public class ParserVisitor implements Visitor
{
	private int ident;
	private final String TAB = "    ";

	public ParserVisitor()
	{
		ident = 0;
	}

	private String ident()
	{
		String ret = new String();

		for(int i=0;i<ident;i++)
			ret += TAB;
		return ret;
	}

	public void visit(Display d)
	{

	}

	public void visit(Program n)
	{
		System.out.println("Program");

		ident++;
		n.m.accept(this);

		for(int i=0;i<n.cl.size();i++)
			n.cl.get(i).accept(this);
		ident--;
	}

	public void visit(MainClass n)
	{
		System.out.printf("%sMainClass %s (Line %d)\n",ident(),n.i1,n.line_number);

		ident++;
		n.sl.accept(this);
		ident--;
	}

	public void visit(ClassDeclSimple n)
	{
		System.out.printf("%sClass ",ident());
		n.i.accept(this);
		System.out.printf("(Line %d)\n",n.line_number);

		ident++;
		if(n.vl.size() > 0)
			System.out.println(ident()+"Attributes");

		ident++;
		for(int i=0; i<n.vl.size(); i++)
			n.vl.get(i).accept(this);
		ident--;

		for(int i=0; i<n.ml.size(); i++)

			n.ml.get(i).accept(this);
		ident--;

	}

	public void visit(ClassDeclExtends n)
	{
		System.out.printf("%sClass ",ident());
		n.i.accept(this);
		System.out.printf(" extends ");
		n.j.accept(this);
		System.out.printf("(Line %d)\n",n.line_number);

		ident++;
		if(n.vl.size() > 0)
			System.out.println(ident()+"Attributes");

		ident++;
		for(int i=0; i<n.vl.size(); i++)
			n.vl.get(i).accept(this);
		ident--;

		for(int i=0; i<n.ml.size(); i++)

			n.ml.get(i).accept(this);
		ident--;
	}

	public void visit(VarDecl n)
	{
		System.out.print(ident());
		n.t.accept(this);
		n.i.accept(this);
		System.out.println("");
	}

	public void visit(MethodDecl n)
	{
		System.out.printf("%sMethodDecl ", ident());
		n.i.accept(this);
		System.out.printf(" (line %d)\n",n.line_number);

		ident++;
		System.out.printf("%sreturns ", ident());
		n.t.accept(this);
		System.out.println("");

		System.out.print(ident()+"Parameters:\n");
		
		for(int i=0;i<n.fl.size();i++)
		{
			System.out.printf("%sVar Declaration (line %d)\n",ident(),n.fl.get(i).line_number);
			
			ident++;
			n.fl.get(i).accept(this);
			ident--;
		}

		for(int i=0;i<n.sl.size();i++)
			n.sl.get(i).accept(this);

		System.out.printf("%sReturn ",ident());
		n.e.accept(this);
		System.out.printf(" (line %d)\n", n.e.line_number);
		ident--;
	}

	public void visit(Formal n)
	{
		System.out.print(ident());
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
		System.out.println("");
	}

	public void visit(IntArrayType n)
	{
		final String str = "int[] ";
		System.out.print(str);
	}

	public void visit(BooleanType n)
	{
		final String str = "boolean ";
		System.out.print(str);
	}

	public void visit(IntegerType n)
	{
		final String str = "int ";
		System.out.print(str);
	}

	public void visit(IdentifierType n)
	{
		String str = n.s + " ";
		System.out.print(str);
	}

	public void visit(Block n)
	{
		for(int i=0;i<n.sl.size();i++)
			n.sl.get(i).accept(this);
	}

	public void visit(If n)
	{
		System.out.printf("%sIf Statement (line %d)\n", ident(), n.line_number);

		ident++;
		System.out.printf("%sCondition: ",ident());
		n.e.accept(this);
		System.out.println("");

		System.out.printf("%sThen:\n",ident());
		ident++;
		n.s1.accept(this);
		ident--;

		System.out.printf("%sElse:\n",ident());
		ident++;
		n.s2.accept(this);
		ident--;

		ident--;
	}

	public void visit(While n)
	{
		System.out.printf("%sWhile Statement (line %d)\n", ident(), n.line_number);

		ident++;
		System.out.printf("%s Perpertuation Condition: ", ident());
		ident++;
		n.e.accept(this);
		ident--;
		System.out.println("");

		System.out.printf("%sdo:\n",ident());
		ident++;
		n.s.accept(this);
		ident--;

		ident--;
	}

	public void visit(Print n)
	{
		System.out.printf("%sPrint (line %d)\n",ident(),n.line_number);

		ident++;
		System.out.print(ident());
		n.e.accept(this);
		System.out.println("");
		ident--;
	}

	public void visit(Assign n)
	{
		System.out.printf("%sSimple Assignment (Line %d)\n", ident(), n.line_number);

		ident++;
		System.out.print(ident());
		n.i.accept(this);
		System.out.print(" becomes ");
		n.e.accept(this);
		ident--;

		System.out.println("");
	}

	public void visit(ArrayAssign n)
	{
		System.out.printf("%sArray Assignment (Line %d)\n", ident(), n.line_number);
		
		ident++;
		System.out.print(ident());
		n.i.accept(this);
		System.out.print("[");
		n.e1.accept(this);
		System.out.print("] becomes ");
		n.e2.accept(this);
		ident--;

		System.out.println("");
	}

	public void visit(And n)
	{
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" && ");
		n.e2.accept(this);
		System.out.print(")");
	}

	public void visit(LessThan n)
	{
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" < ");
		n.e2.accept(this);
		System.out.print(")");
	}

	public void visit(Plus n)
	{
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" + ");
		n.e2.accept(this);
		System.out.print(")");
	}

	public void visit(Minus n)
	{
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" - ");
		n.e2.accept(this);
		System.out.print(")");
	}

	public void visit(Times n)
	{
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" * ");
		n.e2.accept(this);
		System.out.print(")");
	}

	public void visit(ArrayLookup n)
	{
		n.e1.accept(this);
		System.out.print("[");
		n.e2.accept(this);
		System.out.print("]");
	}

	public void visit(ArrayLength n)
	{
		System.out.print("the length of ");
		n.e.accept(this);
	}

	public void visit(Call n)
	{
		System.out.print("");
		n.e.accept(this);
		System.out.print(".");
		n.i.accept(this);
		System.out.print("(");

		n.el.get(0).accept(this);
		for(int i=1;i<n.el.size();i++)
		{
			System.out.print(", ");
			n.el.get(i).accept(this);
		}
		System.out.print(")");
	}

	public void visit(IntegerLiteral n)
	{
		System.out.print(n.i);
	}

	public void visit(True n)
	{
		System.out.print("true");
	}

	public void visit(False n)
	{
		System.out.print("false");
	}

	public void visit(IdentifierExp n)
	{
		System.out.print(n.s);
	}

	public void visit(This n)
	{
		System.out.print("this");
	}

	public void visit(NewArray n)
	{
		System.out.print("new int[");
		n.e.accept(this);
		System.out.print("]");
	}

	public void visit(NewObject n)
	{
		System.out.print("new ");
		n.i.accept(this);
		System.out.print("()");
	}

	public void visit(Not n)
	{
		System.out.print("!(");
		n.e.accept(this);
		System.out.print(")");
	}

	public void visit(Identifier n)
	{
		System.out.print(n.s);
	}

}