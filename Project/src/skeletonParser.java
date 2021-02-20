// Generated from skeleton.g4 by ANTLR 4.9
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class skeletonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, NEWLINE=5, WS=6, ENTIER=7, UNMATCH=8;
	public static final int
		RULE_calcul = 0, RULE_instruction = 1, RULE_expression = 2, RULE_finInstruction = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "instruction", "expression", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'*'", "'/'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "NEWLINE", "WS", "ENTIER", "UNMATCH"
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
	public String getGrammarFileName() { return "skeleton.g4"; }

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

	public skeletonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<TerminalNode> NEWLINE() { return getTokens(skeletonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(skeletonParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(8);
					match(NEWLINE);
					}
					} 
				}
				setState(13);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(14);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "\nHALT \n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				((InstructionContext)_localctx).expression = expression();
				setState(25);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				finInstruction();
				 ((InstructionContext)_localctx).code = ""; 
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public Token a;
		public Token b;
		public Token c;
		public Token d;
		public Token e;
		public Token f;
		public Token g;
		public Token h;
		public List<TerminalNode> ENTIER() { return getTokens(skeletonParser.ENTIER); }
		public TerminalNode ENTIER(int i) {
			return getToken(skeletonParser.ENTIER, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			int _alt;
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(34);
						((ExpressionContext)_localctx).a = match(ENTIER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(37); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(39);
				((ExpressionContext)_localctx).b = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI (((ExpressionContext)_localctx).a!=null?((ExpressionContext)_localctx).a.getText():null) \nPUSHI (((ExpressionContext)_localctx).b!=null?((ExpressionContext)_localctx).b.getText():null) \nADD \n"; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				((ExpressionContext)_localctx).c = match(ENTIER);
				setState(42);
				match(T__0);
				setState(43);
				((ExpressionContext)_localctx).d = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI (((ExpressionContext)_localctx).c!=null?((ExpressionContext)_localctx).c.getText():null) \nPUSHI (((ExpressionContext)_localctx).d!=null?((ExpressionContext)_localctx).d.getText():null) \nSUB \n"; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				((ExpressionContext)_localctx).e = match(ENTIER);
				setState(46);
				match(T__1);
				setState(47);
				((ExpressionContext)_localctx).f = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI (((ExpressionContext)_localctx).e!=null?((ExpressionContext)_localctx).e.getText():null) \nPUSHI (((ExpressionContext)_localctx).f!=null?((ExpressionContext)_localctx).f.getText():null) \nMUL \n"; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				((ExpressionContext)_localctx).g = match(ENTIER);
				setState(50);
				match(T__2);
				setState(51);
				((ExpressionContext)_localctx).h = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI (((ExpressionContext)_localctx).g!=null?((ExpressionContext)_localctx).g.getText():null) \nPUSHI (((ExpressionContext)_localctx).h!=null?((ExpressionContext)_localctx).h.getText():null) \nDIV \n"; 
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(skeletonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(skeletonParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof skeletonListener ) ((skeletonListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(55);
					_la = _input.LA(1);
					if ( !(_la==T__3 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(58); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n?\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\3\2\3\2\7\2\24\n"+
		"\2\f\2\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4"+
		"\3\4\6\4&\n\4\r\4\16\4\'\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\48\n\4\3\5\6\5;\n\5\r\5\16\5<\3\5\2\2\6\2\4\6\b\2\3\3\2\6"+
		"\7\2C\2\r\3\2\2\2\4!\3\2\2\2\6\67\3\2\2\2\b:\3\2\2\2\n\f\7\7\2\2\13\n"+
		"\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\25\3\2\2\2\17\r\3\2"+
		"\2\2\20\21\5\4\3\2\21\22\b\2\1\2\22\24\3\2\2\2\23\20\3\2\2\2\24\27\3\2"+
		"\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\b\2"+
		"\1\2\31\3\3\2\2\2\32\33\5\6\4\2\33\34\5\b\5\2\34\35\b\3\1\2\35\"\3\2\2"+
		"\2\36\37\5\b\5\2\37 \b\3\1\2 \"\3\2\2\2!\32\3\2\2\2!\36\3\2\2\2\"\5\3"+
		"\2\2\2#8\3\2\2\2$&\7\t\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2"+
		"()\3\2\2\2)*\7\t\2\2*8\b\4\1\2+,\7\t\2\2,-\7\3\2\2-.\7\t\2\2.8\b\4\1\2"+
		"/\60\7\t\2\2\60\61\7\4\2\2\61\62\7\t\2\2\628\b\4\1\2\63\64\7\t\2\2\64"+
		"\65\7\5\2\2\65\66\7\t\2\2\668\b\4\1\2\67#\3\2\2\2\67%\3\2\2\2\67+\3\2"+
		"\2\2\67/\3\2\2\2\67\63\3\2\2\28\7\3\2\2\29;\t\2\2\2:9\3\2\2\2;<\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=\t\3\2\2\2\b\r\25!\'\67<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}