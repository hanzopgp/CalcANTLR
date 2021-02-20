// Generated from Calculette.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NEWLINE=7, WS=8, ENTIER=9, 
		UNMATCH=10;
	public static final int
		RULE_start = 0, RULE_expr = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'/'", "'*'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NEWLINE", "WS", "ENTIER", 
			"UNMATCH"
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
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int evalexpr (int x, String op, int y) {
	        if ( op.equals("*") ){
	            return x * y;
	        } else if ( op.equals("/") ){
	            return x / y;
	        }  else if ( op.equals("+") ){
	            return x + y;
	        }  else if ( op.equals("-") ){
	            return x - y;
	        } else {
	           System.err.println("Opérateur arithmétique incorrect : '" + op + "'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '" + op + "'");
	        }
	    }

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExprContext a;
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			((StartContext)_localctx).a = expr(0);
			setState(5);
			match(EOF);
			System.out.println(((StartContext)_localctx).a.val);
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
		public ExprContext b;
		public ExprContext d;
		public ExprContext a;
		public Token op3;
		public ExprContext f;
		public Token g;
		public Token op;
		public ExprContext c;
		public Token op2;
		public ExprContext e;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(9);
				match(T__0);
				setState(10);
				((ExprContext)_localctx).a = expr(0);
				setState(11);
				match(T__1);
				((ExprContext)_localctx).val =  ((ExprContext)_localctx).a.val;
				}
				break;
			case T__4:
			case T__5:
				{
				setState(14);
				((ExprContext)_localctx).op3 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
					((ExprContext)_localctx).op3 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(15);
				((ExprContext)_localctx).f = expr(2);
				((ExprContext)_localctx).val =  evalexpr(0, (((ExprContext)_localctx).op3!=null?((ExprContext)_localctx).op3.getText():null), ((ExprContext)_localctx).f.val);
				}
				break;
			case ENTIER:
				{
				setState(18);
				((ExprContext)_localctx).g = match(ENTIER);
				((ExprContext)_localctx).val =  Integer.parseInt((((ExprContext)_localctx).g!=null?((ExprContext)_localctx).g.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(32);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.b = _prevctx;
						_localctx.b = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(22);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(23);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(24);
						((ExprContext)_localctx).c = expr(5);
						((ExprContext)_localctx).val =  evalexpr(((ExprContext)_localctx).b.val, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).c.val);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(27);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(28);
						((ExprContext)_localctx).op2 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((ExprContext)_localctx).op2 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(29);
						((ExprContext)_localctx).e = expr(4);
						((ExprContext)_localctx).val =  evalexpr(((ExprContext)_localctx).d.val, (((ExprContext)_localctx).op2!=null?((ExprContext)_localctx).op2.getText():null), ((ExprContext)_localctx).e.val);
						}
						break;
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f(\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\27\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3\16\3&\13"+
		"\3\3\3\2\3\4\4\2\4\2\4\3\2\7\b\3\2\5\6\2)\2\6\3\2\2\2\4\26\3\2\2\2\6\7"+
		"\5\4\3\2\7\b\7\2\2\3\b\t\b\2\1\2\t\3\3\2\2\2\n\13\b\3\1\2\13\f\7\3\2\2"+
		"\f\r\5\4\3\2\r\16\7\4\2\2\16\17\b\3\1\2\17\27\3\2\2\2\20\21\t\2\2\2\21"+
		"\22\5\4\3\4\22\23\b\3\1\2\23\27\3\2\2\2\24\25\7\13\2\2\25\27\b\3\1\2\26"+
		"\n\3\2\2\2\26\20\3\2\2\2\26\24\3\2\2\2\27$\3\2\2\2\30\31\f\6\2\2\31\32"+
		"\t\3\2\2\32\33\5\4\3\7\33\34\b\3\1\2\34#\3\2\2\2\35\36\f\5\2\2\36\37\t"+
		"\2\2\2\37 \5\4\3\6 !\b\3\1\2!#\3\2\2\2\"\30\3\2\2\2\"\35\3\2\2\2#&\3\2"+
		"\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\5\26\"$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}