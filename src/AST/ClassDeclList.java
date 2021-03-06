package AST;

import java.util.List;
import java.util.ArrayList;
import java_cup.runtime.ComplexSymbolFactory.Location;

public class ClassDeclList extends ASTNode{
   private List<ClassDecl> list;

   public ClassDeclList(Location pos) {
      super(pos);
      list = new ArrayList<ClassDecl>();
   }

   public ClassDeclList() {
      super();
      list = new ArrayList<ClassDecl>();
   }

   public void add(ClassDecl n) {
      list.add(n);
   }

   public ClassDecl get(int i)  { 
      return list.get(i); 
   }

   public int size() { 
      return list.size(); 
   }
}
