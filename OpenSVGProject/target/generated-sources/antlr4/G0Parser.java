import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class G0Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUM=1, ID=2, PLUS=3, MINUS=4, LPAR=5, RPAR=6, LBRACKET=7, RBRACKET=8, 
		POINT=9;
	public static final int
		RULE_e = 0, RULE_f = 1, RULE_g = 2, RULE_a = 3;
	public static final String[] ruleNames = {
		"e", "f", "g", "a"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'+'", "'-'", "'('", "')'", "'['", "']'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUM", "ID", "PLUS", "MINUS", "LPAR", "RPAR", "LBRACKET", "RBRACKET", 
		"POINT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "G0.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public G0Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(G0Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(G0Parser.MINUS, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).exitE(this);
		}
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(9); 
			f();
			}
			_ctx.stop = _input.LT(-1);
			setState(16);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_e);
					setState(11);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(12);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(13); 
					f();
					}
					} 
				}
				setState(18);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(G0Parser.LPAR, 0); }
		public TerminalNode ID() { return getToken(G0Parser.ID, 0); }
		public TerminalNode RPAR() { return getToken(G0Parser.RPAR, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).exitF(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_f);
		try {
			setState(24);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(19); 
				match(LPAR);
				setState(20); 
				match(ID);
				setState(21); 
				match(RPAR);
				setState(22); 
				f();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); 
				g(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GContext extends ParserRuleContext {
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public GContext g() {
			return getRuleContext(GContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(G0Parser.LBRACKET, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(G0Parser.RBRACKET, 0); }
		public TerminalNode POINT() { return getToken(G0Parser.POINT, 0); }
		public TerminalNode ID() { return getToken(G0Parser.ID, 0); }
		public GContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).enterG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).exitG(this);
		}
	}

	public final GContext g() throws RecognitionException {
		return g(0);
	}

	private GContext g(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GContext _localctx = new GContext(_ctx, _parentState);
		GContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_g, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(27); 
			a();
			}
			_ctx.stop = _input.LT(-1);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_g);
					setState(29);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(36);
					switch (_input.LA(1)) {
					case LBRACKET:
						{
						setState(30); 
						match(LBRACKET);
						setState(31); 
						e(0);
						setState(32); 
						match(RBRACKET);
						}
						break;
					case POINT:
						{
						setState(34); 
						match(POINT);
						setState(35); 
						match(ID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(G0Parser.LPAR, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(G0Parser.RPAR, 0); }
		public TerminalNode NUM() { return getToken(G0Parser.NUM, 0); }
		public TerminalNode ID() { return getToken(G0Parser.ID, 0); }
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof G0Listener ) ((G0Listener)listener).exitA(this);
		}
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_a);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); 
				match(LPAR);
				setState(44); 
				e(0);
				setState(45); 
				match(RPAR);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); 
				match(NUM);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(48); 
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: 
			return e_sempred((EContext)_localctx, predIndex);
		case 2: 
			return g_sempred((GContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean g_sempred(GContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\7\2\21\n\2\f\2\16\2\24\13"+
		"\2\3\3\3\3\3\3\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4\'\n\4\7\4)\n\4\f\4\16\4,\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\64"+
		"\n\5\3\5\2\4\2\6\6\2\4\6\b\2\3\3\2\5\6\67\2\n\3\2\2\2\4\32\3\2\2\2\6\34"+
		"\3\2\2\2\b\63\3\2\2\2\n\13\b\2\1\2\13\f\5\4\3\2\f\22\3\2\2\2\r\16\f\4"+
		"\2\2\16\17\t\2\2\2\17\21\5\4\3\2\20\r\3\2\2\2\21\24\3\2\2\2\22\20\3\2"+
		"\2\2\22\23\3\2\2\2\23\3\3\2\2\2\24\22\3\2\2\2\25\26\7\7\2\2\26\27\7\4"+
		"\2\2\27\30\7\b\2\2\30\33\5\4\3\2\31\33\5\6\4\2\32\25\3\2\2\2\32\31\3\2"+
		"\2\2\33\5\3\2\2\2\34\35\b\4\1\2\35\36\5\b\5\2\36*\3\2\2\2\37&\f\4\2\2"+
		" !\7\t\2\2!\"\5\2\2\2\"#\7\n\2\2#\'\3\2\2\2$%\7\13\2\2%\'\7\4\2\2& \3"+
		"\2\2\2&$\3\2\2\2\')\3\2\2\2(\37\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2"+
		"+\7\3\2\2\2,*\3\2\2\2-.\7\7\2\2./\5\2\2\2/\60\7\b\2\2\60\64\3\2\2\2\61"+
		"\64\7\3\2\2\62\64\7\4\2\2\63-\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\t"+
		"\3\2\2\2\7\22\32&*\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}