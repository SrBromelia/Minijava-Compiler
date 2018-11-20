import Scanner.*;
import Parser.*;
import AST.*;
import AST.Visitor.*;
import SemanticCheck.SymbolTable.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java.util.*;
import java.io.*;

class Minijava
{
	public static void main(String[] args)
	{
		switch(args[0])
		{
			case "-S":
				callScanner(args[1]);
				break;

			case "-A":
				callAST(args[1]);
				break;

			case "-P":
				callPrettyPrint(args[1]);
				break;

			case "-T":
				callSemanticCheck(args[1]);
				break;

			default:
				callCompiler(args[0]);
		}
	}

	public static void callScanner(String stream)
	{
		try {
            // create a scanner on the input file
            ComplexSymbolFactory sf = new ComplexSymbolFactory();
            Reader in = new BufferedReader(new FileReader(stream));
            scanner s = new scanner(in, sf);
            Symbol t = s.next_token();
            while (t.sym != sym.EOF){ 
                // print each token that we scan
                String token = s.symbolToString(t);
                System.out.print(s.symbolToString(t) + " ");
                if(token.equals("SEMICOLON") ||
                   token.equals("LBRACE") ||
                   token.equals("RBRACE"))
                	System.out.println("");
                t = s.next_token();
            }
            System.out.print("\nLexical analysis completed");
        } catch (FileNotFoundException e) {
        	System.err.println("File not found!");
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                        e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
	}

	public static void callAST(String stream)
	{
        try {
            // create a scanner on the input file
            ComplexSymbolFactory sf = new ComplexSymbolFactory();
            Reader in = new BufferedReader(new FileReader(stream));
            scanner s = new scanner(in, sf);
            parser p = new parser(s, sf);
            Symbol root;
        // replace p.parse() with p.debug_parse() in next line to see trace of
        // parser shift/reduce actions during parse
            root = p.parse();
            Program program = (Program)root.value;
            program.accept(new ParserVisitor());
            System.out.println("\n");
            System.out.print("\nParsing completed"); 
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                               e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
	}

	public static void callPrettyPrint(String stream)
	{
		try {
            // create a scanner on the input file
            ComplexSymbolFactory sf = new ComplexSymbolFactory();
            Reader in = new BufferedReader(new FileReader(stream));
            scanner s = new scanner(in, sf);
            parser p = new parser(s, sf);
            Symbol root;
        // replace p.parse() with p.debug_parse() in next line to see trace of
        // parser shift/reduce actions during parse
            root = p.parse();
            Program program = (Program)root.value;
            program.accept(new PrettyPrintVisitor());
            System.out.println("\n");
            System.out.print("\nParsing completed"); 
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                               e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
	}

	public static void callSemanticCheck(String stream)
	{
		System.out.println("Semantic Check");
        try {
            // create a scanner on the input file
            ComplexSymbolFactory sf = new ComplexSymbolFactory();
            Reader in = new BufferedReader(new FileReader(stream));
            scanner s = new scanner(in, sf);
            parser p = new parser(s, sf);
            Symbol root;
        // replace p.parse() with p.debug_parse() in next line to see trace of
        // parser shift/reduce actions during parse
            root = p.parse();
            Program program = (Program)root.value;
            SymbolTableCreatorVisitor visitor = new SymbolTableCreatorVisitor();
            program.accept(visitor);
            GlobalSymbolTable table = visitor.getTable();
            table.accept(new SymbolTablePrinterVisitor());
            System.out.println("\n");
            System.out.print("\nParsing completed"); 
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                               e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
	}

	public static void callCompiler(String stream)
	{
		System.out.println("Compiler");
	}
}