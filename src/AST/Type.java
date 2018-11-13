package AST;

import AST.Visitor.Visitor;
import java_cup.runtime.ComplexSymbolFactory.Location;

public abstract class Type extends ASTNode {
    public String s;
	public Type(Location pos) {
        super(pos);
    }
    
    public Type(String as, Location pos)
    {
    	super(pos);
    	s = as;

    }
    public abstract void accept(Visitor v);
}
