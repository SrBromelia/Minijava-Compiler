
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Parser;

import AST.*;
import java.util.*;
import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\013\000\002\002\003\000\002\002\004\000\002\002" +
    "\004\000\002\003\003\000\002\003\003\000\002\004\006" +
    "\000\002\007\003\000\002\005\005\000\002\006\003\000" +
    "\002\006\005\000\002\006\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\006\004\010\024\011\001\002\000\010\002" +
    "\027\004\010\024\011\001\002\000\010\002\ufffe\004\ufffe" +
    "\024\ufffe\001\002\000\010\002\001\004\001\024\001\001" +
    "\002\000\010\002\ufffd\004\ufffd\024\ufffd\001\002\000\006" +
    "\015\016\024\015\001\002\000\004\014\ufffb\001\002\000" +
    "\004\014\013\001\002\000\006\015\016\024\015\001\002" +
    "\000\006\010\021\023\023\001\002\000\010\010\ufff9\016" +
    "\ufff9\023\ufff9\001\002\000\006\015\016\024\015\001\002" +
    "\000\006\010\021\016\020\001\002\000\010\010\ufff7\016" +
    "\ufff7\023\ufff7\001\002\000\006\015\016\024\015\001\002" +
    "\000\010\010\ufff8\016\ufff8\023\ufff8\001\002\000\010\002" +
    "\ufffc\004\ufffc\024\ufffc\001\002\000\006\010\021\023\025" +
    "\001\002\000\010\002\ufffa\004\ufffa\024\ufffa\001\002\000" +
    "\010\002\uffff\004\uffff\024\uffff\001\002\000\004\002\000" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\025\000\014\002\003\003\005\004\004\005\006\007" +
    "\011\001\001\000\012\003\025\004\004\005\006\007\011" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\023\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\006\013\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\016\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\006\021\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Program ::= Statement 
            {
              List<Statement> RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 List<Statement> p = new LinkedList<Statement>();
               p.add(s);
               RESULT = p; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Program",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Program EOF 
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		List<Statement> start_val = (List<Statement>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Program ::= Program Statement 
            {
              List<Statement> RESULT =null;
		Location pxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location pxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		List<Statement> p = (List<Statement>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Statement s = (Statement)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 p.add(s); RESULT = p; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Program",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Statement ::= AssignStatement 
            {
              Statement RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Assign s = (Assign)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = s; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Statement",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Statement ::= DisplayStatement 
            {
              Statement RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Display s = (Display)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = s; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Statement",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // AssignStatement ::= Identifier BECOMES Expression SEMICOLON 
            {
              Assign RESULT =null;
		Location idxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).xleft;
		Location idxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).xright;
		Identifier id = (Identifier)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		Location exprxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location exprxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Exp expr = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new Assign(id, expr, idxleft); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("AssignStatement",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Identifier ::= IDENTIFIER 
            {
              Identifier RESULT =null;
		Location idxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location idxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Identifier(id, idxleft); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Identifier",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // DisplayStatement ::= DISPLAY Expression SEMICOLON 
            {
              Display RESULT =null;
		Location dxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location dxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location exprxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location exprxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Exp expr = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new Display(expr, dxleft); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DisplayStatement",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Expression ::= IDENTIFIER 
            {
              Exp RESULT =null;
		Location namexleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location namexright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		String name = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new IdentifierExp(name, namexleft); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expression",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Expression ::= Expression PLUS Expression 
            {
              Exp RESULT =null;
		Location arg1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xleft;
		Location arg1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).xright;
		Exp arg1 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Location arg2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xleft;
		Location arg2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.peek()).xright;
		Exp arg2 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Plus(arg1, arg2, arg1xleft); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expression",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Expression ::= LPAREN Expression RPAREN 
            {
              Exp RESULT =null;
		Location exprxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xleft;
		Location exprxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).xright;
		Exp expr = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = expr; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("Expression",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
