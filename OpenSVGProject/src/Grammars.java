public class Grammars {
    public static Grammar makeG2(){
        NonTerm e = new NonTerm("E");
        NonTerm e_ = new NonTerm("E_");
        NonTerm f = new NonTerm("F");
        NonTerm g_ =new NonTerm("G_");
        NonTerm f_ = new NonTerm("F_");
        NonTerm f__ = new NonTerm("F__");
        NonTerm f___ = new NonTerm("F___");

        SymbolFactory fact = new SymbolFactory(G0Lexer.class);
        Term lpar = fact.getTerminal(G0Lexer.LPAR);
        Term rpar = fact.getTerminal(G0Lexer.RPAR);
        Term lbracket = fact.getTerminal(G0Lexer.LBRACKET);
        Term rbracket = fact.getTerminal(G0Lexer.RBRACKET);
        Term empty = Symbol.EMPTY;
        Term num = fact.getTerminal(G0Lexer.NUM);
        Term id = fact.getTerminal(G0Lexer.ID);
        Term plus = fact.getTerminal(G0Lexer.PLUS);
        Term minus = fact.getTerminal(G0Lexer.MINUS);
        Term point = fact.getTerminal(G0Lexer.POINT);

        Grammar grammar = new Grammar(e);
        grammar.addRule(e, f, e_);
        grammar.addRule(e_, plus, f, e_);
        grammar.addRule(e_, minus, f, e_);
        grammar.addRule(e_, empty);
        grammar.addRule(f, lpar, f_);
        grammar.addRule(f, num, g_);
        grammar.addRule(f, id, g_);
        grammar.addRule(g_, lbracket, e, rbracket, g_);
        grammar.addRule(g_, point, id, g_);
        grammar.addRule(g_, empty);
        grammar.addRule(f_, id, f__);
        grammar.addRule(f_, lpar, f_, e_, rpar, g_);
        grammar.addRule(f_, num, g_, e_, rpar, g_);
        grammar.addRule(f__, rpar, f___);
        grammar.addRule(f__, lbracket, e, rbracket, g_, e_, rpar, g_);
        grammar.addRule(f__, point, id, g_, e_, rpar, g_);
        grammar.addRule(f__, plus, f, e_, rpar, g_);
        grammar.addRule(f__, minus, f, e_, rpar, g_);
        grammar.addRule(f___, f);
        grammar.addRule(f___, g_);
        return grammar;
    }
}