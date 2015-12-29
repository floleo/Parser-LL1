import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main
{
    public static void main( String[] args) throws Exception 
    {
    	System.out.print("Inserisci nome: ");
    	Scanner s=new Scanner(System.in);
    	String m=s.nextLine();
        //System.out.println("ciao "+m);
        ANTLRInputStream input = new ANTLRInputStream(m);
        //System.out.println("ciao "+input);
        HelloLexer lexer = new HelloLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        HelloParser parser = new HelloParser(tokens);
        ParseTree tree = parser.r(); // begin parsing at rule 'r'
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
