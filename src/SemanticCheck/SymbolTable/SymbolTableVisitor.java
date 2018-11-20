package SemanticCheck.SymbolTable;

public interface SymbolTableVisitor
{
	public void visit(GlobalSymbolTable t);
	public void visit(ClassSymbolTable t);
	public void visit(MethodSymbolTable t);
	public void visit(VariableSymbolTable t);
}