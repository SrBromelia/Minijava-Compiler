package AST.Visitor;

import AST.*;
import Exceptions.*;
import SemanticCheck.SymbolTable.*;

import java.util.List;
import java.util.ArrayList;

public class TypeCheckVisitor implements Visitor
{
	private GlobalSymbolTable table;
	private String currentClass;
	private String refClass;
	private String currentMethod;
	private List<String> errors;

	public TypeCheckVisitor()
	{
		table = null;
		refClass = null;
		currentClass = null;
		currentMethod = null;
	}

	private String curClass()
	{
		if(refClass==null)
			return currentClass;

		String s = refClass;
		refClass= null;

		return s;
	}

	private String getType(Exp e)
	{
		switch(e.getClass().getSimpleName())
		{
			case "True":
			case "False":
				return "boolean";

			case "Not":
				Not no = (Not) e;

				System.out.println(no.e.getClass().getSimpleName());
				if(getType(no.e).equals("boolean"))
					return "boolean";
				break;

			case "IntegerLiteral":
			case "ArrayLength":
			case "ArrayLookup":
				return "int";

			case "NewObject":
				return ((NewObject) e).i.s;

			case "This":
				return currentClass;

			case "NewArray":
				return "int[]";

			case "Call":
				Call c = (Call) e;
				String s = getType(c.e);

				System.out.println(e.line_number);
				if(s.equals("int")||s.equals("boolean")||s.equals("int[]"))
					return null;

				return table.getClass(s).getMethod(c.i.s).getType();

			case "IdentifierExp":
				IdentifierExp i = (IdentifierExp) e;
				return table.getType(i.s,currentMethod,currentClass);

			case "And":
				And a = (And) e;
				if(getType(a.e1).equals(getType(a.e2)))
					return getType(a.e1);
				break;

			case "Plus":
				Plus p = (Plus) e;
				if(getType(p.e1).equals(getType(p.e2)))
					return getType(p.e1);
				break;

			case "Minus":
				Minus m = (Minus) e;
				if(getType(m.e1).equals(getType(m.e2)))
					return getType(m.e1);
				break;
			case "Times":
				Times t = (Times) e;
				if(getType(t.e1).equals(getType(t.e2)))
					return getType(t.e1);
				break;
		}

		return null;
	}

	private String getType(Identifier i)
	{
		String s = curClass();
		if(table.isDeclared(i.s,currentMethod,s))
			return table.getType(i.s,currentMethod,s);
		return null;
	}

	public List<String> getErrors()
	{
		return errors;
	}

	public void visit(Display n) {}

	public void visit(Program n)
	{
		errors = new ArrayList<String>();
		SymbolTableCreatorVisitor visitor = new SymbolTableCreatorVisitor();
		n.accept(visitor);

		table = visitor.getTable();

		n.m.accept(this);

		for(int i=0; i<n.cl.size(); i++)
			n.cl.get(i).accept(this);
	}

	public void visit(MainClass n)
	{
		currentClass = n.i1.s;

		n.sl.accept(this);

		currentClass = null;
	}

	public void visit(ClassDeclSimple n)
	{
		currentClass = n.i.s;

		for(int i=0; i<n.ml.size();i++)
			n.ml.get(i).accept(this);

		currentClass = null;
	}

	public void visit(ClassDeclExtends n)
	{
		currentClass = n.i.s;

		if(n.i.s.equals(n.j.s))
			errors.add(String.format("Sem. Error in line %d, class %s: A class cannot inherit itself.", n.line_number, n.i.s));

		for(int i=0; i<n.ml.size();i++)
			n.ml.get(i).accept(this);

		currentClass = null;
	}

	public void visit(VarDecl n) {}

	public void visit(MethodDecl n)
	{
		currentMethod = n.i.s;

		for(int i=0;i<n.sl.size();i++)
			n.sl.get(i).accept(this);

		currentMethod = null;
	}

	public void visit(Formal n) {}
	public void visit(IntArrayType n) {}
	public void visit(BooleanType n) {}
	public void visit(IntegerType n) {}
	public void visit(IdentifierType n) {}

	public void visit(Block n)
	{
		for(int i=0;i<n.sl.size();i++)
			n.sl.get(i).accept(this);
	}

	public void visit(If n)
	{
		n.e.accept(this);
		n.s1.accept(this);
		n.s2.accept(this);
	}

	public void visit(While n)
	{
		n.e.accept(this);
		n.s.accept(this);
	}

	public void visit(Print n)
	{
		n.e.accept(this);
	}

	public void visit(Assign n)
	{
		n.i.accept(this);
		n.e.accept(this);

		if(!getType(n.i).equals(getType(n.e)))
			errors.add(String.format("Sem. Error in line %d: incompatible types assign.", n.line_number));
	}

	public void visit(ArrayAssign n)
	{
		n.i.accept(this);
		n.e1.accept(this);
		n.e2.accept(this);

		if(!getType(n.e1).equals("int"))
			System.out.println(String.format("Sem. error in line %d: value inside [] must be 'int'.", n.line_number));
		if(!getType(n.e2).equals("int"))
			System.out.println(String.format("Sem. error in line %d: assigned value must be 'int'.", n.line_number));
	}

	public void visit(And n)
	{
		n.e1.accept(this);
		n.e2.accept(this);

		if(!getType(n.e1).equals("boolean") ||
		   !getType(n.e2).equals("boolean"))
			errors.add(String.format("Sem. error in line %d: Both sides of '&&' must be type 'boolean'.", n.line_number));
	}

	public void visit(LessThan n)
	{
		n.e1.accept(this);
		n.e2.accept(this);

		if(!getType(n.e1).equals("int") ||
		   !getType(n.e2).equals("int"))
			errors.add(String.format("Sem. error in line %d: Both sides of '<' must be type 'int'.", n.line_number));
	}

	public void visit(Plus n)
	{
		n.e1.accept(this);
		n.e2.accept(this);

		if(!getType(n.e1).equals("int") ||
		   !getType(n.e2).equals("int"))
			errors.add(String.format("Sem. error in line %d: Both sides of '+' must be type 'int'.", n.line_number));
	}

	public void visit(Minus n)
	{
		n.e1.accept(this);
		n.e2.accept(this);
		
		if(!getType(n.e1).equals("int") ||
		   !getType(n.e2).equals("int"))
			errors.add(String.format("Sem. error in line %d: Both sides of '-' must be type 'int'.", n.line_number));
	}

	public void visit(Times n)
	{
		n.e1.accept(this);
		n.e2.accept(this);
		
		if(!getType(n.e1).equals("int") ||
		   !getType(n.e2).equals("int"))
			errors.add(String.format("Sem. error in line %d: Both sides of '*' must be type 'int'.", n.line_number));
	}

	public void visit(ArrayLookup n)
	{
		n.e1.accept(this);

		if(n.e1 instanceof IdentifierExp)
		{
			IdentifierExp e = (IdentifierExp) n.e1;

			if(!table.getType(e.s,currentMethod,currentClass).equals("int[]"))
				errors.add(String.format("Sem. error in line %d: %s is not an array", n.line_number, e.s));
		}
		else
			errors.add(String.format("Sem. error in line %d: only a identifier variable of the type 'int[]' can use Exp[Exp]", n.line_number));
	}

	public void visit(ArrayLength n)
	{
		n.e.accept(this);

		if(n.e instanceof IdentifierExp)
		{
			IdentifierExp e = (IdentifierExp) n.e;

			if(!table.getType(e.s,currentMethod,currentClass).equals("int[]"))
				errors.add(String.format("Sem. error in line %d: The Variable %s cannot use 'length' feature because its type is not 'int[]'", n.line_number, e.s));
		}
		else
			errors.add(String.format("Sem. error in line %d: only a identifier variable of the type 'int[]' possesses 'length' feature", n.line_number));
	}

	public void visit(Call n)
	{
		n.e.accept(this);

		if(n.e instanceof IdentifierExp)
		{
			IdentifierExp e = (IdentifierExp) n.e;

			if(!table.getType(e.s,currentMethod,currentClass).equals(getType(e)))
				errors.add(String.format("Sem. error in line %d: only objects posses methods.", n.line_number));
		}
		else if(n.e instanceof NewObject)
		{
			NewObject e = (NewObject) n.e;
			refClass = e.i.s;
			n.i.accept(this);
		}
		else if(n.e instanceof This)
		{
			n.i.accept(this);
		}
		else
			errors.add(String.format("Sem. error in line %d: only objects posses methods.", n.line_number));
	}

	public void visit(IntegerLiteral n) {}

	public void visit(True n) {}

	public void visit(False n) {}

	//Checa se o identificador é uma classe ou uma variável do tipo int[]
	public void visit(IdentifierExp n)
	{
		if(!(table.isDeclared(n.s,currentMethod,currentClass)))
			errors.add(String.format("Sem. Error in line %d. Identifier %s was not previously declared.", n.line_number, n.s));
	}

	//Checa se quem chamou não foi a main
	public void visit(This n)
	{
		if(table.getMain().equals(currentClass))
			errors.add(String.format("Sem. Error in line %d. 'This' is not allowed in Main Class.", n.line_number));
	}

	//Checa se a expressão é inteira
	public void visit(NewArray n)
	{

	}

	//Checa se há uma classe com o nome dado
	public void visit(NewObject n)
	{
		if(! table.containClass(n.i.s))
			errors.add(String.format("Sem. Error in line %d. There's no class called %s.", n.line_number, n.i.s));
	}

	public void visit(Not n)
	{

	}

	//Checa se o identificador foi delcarado
	public void visit(Identifier n)
	{
		String cl = curClass();

		if(!table.isDeclared(n.s,currentMethod,cl))
			errors.add(String.format("Sem. Error in line %d. Identifier %s was not declared in class %s.", n.line_number, n.s, cl));
	}

}