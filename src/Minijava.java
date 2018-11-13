import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import Parser.sym;
import Scanner.scanner;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import java.io.FileReader;

public class Minijava {
	public static void main(String[] args) {
		try {
            // create a scanner on the input file
            ComplexSymbolFactory sf = new ComplexSymbolFactory();
            Reader in = new BufferedReader(new FileReader("SamplePrograms/Example2.java"));
            scanner s = new scanner(in, sf);
            Symbol t = s.next_token();
            while (t.sym != sym.EOF){ 
                // print each token that we scan
            	String out = s.symbolToString(t);
                System.out.print(out + " ");
                if(out.equals("SEMICOLON") ||
                   out.equals("LBRACE"))
                	System.out.println("");
                t = s.next_token();
            }
            System.out.print("\nLexical analysis completed"); 
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                        e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
	}
}
