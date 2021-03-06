package AST;

import AST.Visitor.Visitor;
import java_cup.runtime.ComplexSymbolFactory.Location;

abstract public class ASTNode {
  // Line number in source file.
  public final int line_number;

  // Constructor
  public ASTNode(Location pos) {
    this.line_number = pos.getLine();
  }

  public ASTNode() {
  	this.line_number = -1;
  }
}
