import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GrammarsTest {
    @Test
    public void testParseTree() {
        assertEquals("(e (e (f (g (g (a a)) [ (e (e (f (g (a i)))) + (f (g (a 1)))) ]))) + (f (g (g (a b)) . field)))",
                parseStringToTree("a[i+1]+b.field"));
        assertEquals("(e (e (e (f (g (g (a ( (e (f ( Type ) (f (g (a x))))) ))) . i))) - (f (g (a 10)))) + (f (g (a y))))",
                parseStringToTree("((Type)x).i-10+y"));
    }

    @Test
    public void testLL1() {
        assertTrue(new AwesomeLLCalc(Grammars.makeG2()).isLL1());
    }

    public String parseStringToTree(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new G0Lexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        G0Parser parser = new G0Parser(tokens);
        ParseTree tree = parser.e();
        return tree.toStringTree(parser);
    }
}