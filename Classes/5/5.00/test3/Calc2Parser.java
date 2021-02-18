// Generated from Calc2.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Calc2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, ST=2, ID=3, PLUS=4, MOINS=5, COMMENT=6, UNMATCH=7;
	public static final int
		RULE_calcul = 0, RULE_expr = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'STORE'", null, "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "ST", "ID", "PLUS", "MOINS", "COMMENT", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calc2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		int store = 0;

	public Calc2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public ExprContext expr;
		public Token NUMBER;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode ST() { return getToken(Calc2Parser.ST, 0); }
		public TerminalNode ID() { return getToken(Calc2Parser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(Calc2Parser.NUMBER, 0); }
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calc2Listener ) ((Calc2Listener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calc2Listener ) ((Calc2Listener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calcul);
		try {
			setState(14);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case ID:
			case PLUS:
			case MOINS:
				enterOuterAlt(_localctx, 1);
				{
				setState(4);
				((CalculContext)_localctx).expr = expr();
				setState(5);
				calcul();
				 System.out.println(((CalculContext)_localctx).expr.val); 
				}
				break;
			case ST:
				enterOuterAlt(_localctx, 2);
				{
				setState(8);
				match(ST);
				setState(9);
				match(ID);
				setState(10);
				((CalculContext)_localctx).NUMBER = match(NUMBER);
				setState(11);
				calcul();
				 store = (((CalculContext)_localctx).NUMBER!=null?Integer.valueOf(((CalculContext)_localctx).NUMBER.getText()):0);
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

	public static class ExprContext extends ParserRuleContext {
		public int val;
		public Token NUMBER;
		public ExprContext a;
		public ExprContext b;
		public TerminalNode NUMBER() { return getToken(Calc2Parser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(Calc2Parser.ID, 0); }
		public TerminalNode PLUS() { return getToken(Calc2Parser.PLUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOINS() { return getToken(Calc2Parser.MOINS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Calc2Listener ) ((Calc2Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Calc2Listener ) ((Calc2Listener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				((ExprContext)_localctx).NUMBER = match(NUMBER);
				 ((ExprContext)_localctx).val =  (((ExprContext)_localctx).NUMBER!=null?Integer.valueOf(((ExprContext)_localctx).NUMBER.getText()):0) ;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				match(ID);
				 ((ExprContext)_localctx).val =  store;
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
				match(PLUS);
				setState(21);
				((ExprContext)_localctx).a = expr();
				setState(22);
				((ExprContext)_localctx).b = expr();
				 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).a.val + ((ExprContext)_localctx).b.val ;
				}
				break;
			case MOINS:
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				match(MOINS);
				setState(26);
				((ExprContext)_localctx).a = expr();
				setState(27);
				((ExprContext)_localctx).b = expr();
				 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).a.val - ((ExprContext)_localctx).b.val;
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t#\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\2\2\4\2\4\2\2\2"+
		"$\2\20\3\2\2\2\4 \3\2\2\2\6\7\5\4\3\2\7\b\5\2\2\2\b\t\b\2\1\2\t\21\3\2"+
		"\2\2\n\13\7\4\2\2\13\f\7\5\2\2\f\r\7\3\2\2\r\16\5\2\2\2\16\17\b\2\1\2"+
		"\17\21\3\2\2\2\20\6\3\2\2\2\20\n\3\2\2\2\21\3\3\2\2\2\22\23\7\3\2\2\23"+
		"!\b\3\1\2\24\25\7\5\2\2\25!\b\3\1\2\26\27\7\6\2\2\27\30\5\4\3\2\30\31"+
		"\5\4\3\2\31\32\b\3\1\2\32!\3\2\2\2\33\34\7\7\2\2\34\35\5\4\3\2\35\36\5"+
		"\4\3\2\36\37\b\3\1\2\37!\3\2\2\2 \22\3\2\2\2 \24\3\2\2\2 \26\3\2\2\2 "+
		"\33\3\2\2\2!\5\3\2\2\2\4\20 ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}