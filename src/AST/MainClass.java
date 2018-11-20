package AST;

import AST.Visitor.Visitor;
import java_cup.runtime.ComplexSymbolFactory.Location;

import java.util.*;

public class MainClass extends ASTNode{
  public Identifier i1,i2;
  public Statement sl;

  public MainClass(Identifier ai1, Identifier ai2, Statement asl,
                   Location pos) {
    super(pos);
    i1=ai1; i2=ai2; sl=asl;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}

