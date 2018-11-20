package AST.Visitor;

import AST.*;
import SemanticCheck.SymbolTable.*;

public class SymbolTableCreatorVisitor implements Visitor
{
	private GlobalSymbolTable table;
	private ClassSymbolTable currentClass;
	private MethodSymbolTable currentMethod;

	public SymbolTableCreatorVisitor()
	{
		table = new GlobalSymbolTable();
		currentClass=null;
		currentMethod=null;
	}

	public GlobalSymbolTable getTable()
	{
		return table;
	}

	public String typeInstance(Type t)
	{
		if(t instanceof IntegerType) return "int";
		if(t instanceof IntArrayType) return "int[]";
		if(t instanceof BooleanType) return "boolean";
		
		//t instanceof IdentifierType
		return ((IdentifierType) t).s;
	}

	public void visit(Display n) {}

	public void visit(Program n)
	{
		for(int i=0;i<n.cl.size();i++)
			n.cl.get(i).accept(this);
	}

	public void visit(MainClass n) {}

	public void visit(ClassDeclSimple n)
	{
		table.addClass(n.i.s);
		currentClass = table.getClass(n.i.s);

		for(int i=0;i<n.vl.size();i++)
			n.vl.get(i).accept(this);

		for(int i=0;i<n.ml.size();i++)
			n.ml.get(i).accept(this);
	}

	public void visit(ClassDeclExtends n)
	{
		table.addClass(n.i.s);
		currentClass = table.getClass(n.i.s);

		for(int i=0;i<n.vl.size();i++)
			n.vl.get(i).accept(this);

		for(int i=0;i<n.ml.size();i++)
			n.ml.get(i).accept(this);
	}

	public void visit(VarDecl n)
	{
		if(currentMethod!=null)	
			currentMethod.addVar(n.i.s, typeInstance(n.t));
		else
			currentClass.addAttr(n.i.s,typeInstance(n.t));
	}

	public void visit(MethodDecl n)
	{
		currentClass.addMethod(n.i.s,typeInstance(n.t));

		currentMethod = currentClass.getMethod(n.i.s);

		for(int i=0;i<n.fl.size();i++)
			n.fl.get(i).accept(this);

		for(int i=0;i<n.vl.size();i++)
			n.vl.get(i).accept(this);

		currentMethod=null;
	}

	public void visit(Formal n)
	{
		currentMethod.addParam(n.i.s, typeInstance(n.t));
	}

	public void visit(IntArrayType n) {}
	public void visit(BooleanType n) {}
	public void visit(IntegerType n) {}
	public void visit(IdentifierType n) {}
	public void visit(Block n) {}
	public void visit(If n) {}
	public void visit(While n) {}
	public void visit(Print n) {}
	public void visit(Assign n) {}
	public void visit(ArrayAssign n) {}
	public void visit(And n) {}
	public void visit(LessThan n) {}
	public void visit(Plus n) {}
	public void visit(Minus n) {}
	public void visit(Times n) {}
	public void visit(ArrayLookup n) {}
	public void visit(ArrayLength n) {}
	public void visit(Call n) {}
	public void visit(IntegerLiteral n) {}
	public void visit(True n) {}
	public void visit(False n) {}
	public void visit(IdentifierExp n) {}
	public void visit(This n) {}
	public void visit(NewArray n) {}
	public void visit(NewObject n) {}
	public void visit(Not n) {}
	public void visit(Identifier n) {}
}