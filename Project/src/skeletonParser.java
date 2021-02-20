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
		T__0=1, NEWLINE=2, WS=3, OP=4, ENTIER=5, UNMATCH=6;
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
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NEWLINE", "WS", "OP", "ENTIER", "UNMATCH"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NEWLINE) | (1L << OP))) != 0)) {
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
			 _localctx.code += "  HALT\n"; 
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
			switch (_input.LA(1)) {
			case OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				((InstructionContext)_localctx).expression = expression();
				setState(25);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case T__0:
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				finInstruction();
				 ((InstructionContext)_localctx).code = ""; 
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public Token OP;
		public Token ENTIER;
		public TerminalNode OP() { return getToken(skeletonParser.OP, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			((ExpressionContext)_localctx).OP = match(OP);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ENTIER) {
				{
				{
				setState(34);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 ((ExpressionContext)_localctx).code =  (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null) + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null); 
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
			setState(43); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(42);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==NEWLINE) ) {
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
				setState(45); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\3\2\3\2\7\2\24"+
		"\n\2\f\2\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3"+
		"\4\3\4\7\4&\n\4\f\4\16\4)\13\4\3\4\3\4\3\5\6\5.\n\5\r\5\16\5/\3\5\2\2"+
		"\6\2\4\6\b\2\3\3\2\3\4\2\62\2\r\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2\b-\3\2\2"+
		"\2\n\f\7\4\2\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16"+
		"\25\3\2\2\2\17\r\3\2\2\2\20\21\5\4\3\2\21\22\b\2\1\2\22\24\3\2\2\2\23"+
		"\20\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27"+
		"\25\3\2\2\2\30\31\b\2\1\2\31\3\3\2\2\2\32\33\5\6\4\2\33\34\5\b\5\2\34"+
		"\35\b\3\1\2\35\"\3\2\2\2\36\37\5\b\5\2\37 \b\3\1\2 \"\3\2\2\2!\32\3\2"+
		"\2\2!\36\3\2\2\2\"\5\3\2\2\2#\'\7\6\2\2$&\7\7\2\2%$\3\2\2\2&)\3\2\2\2"+
		"\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\b\4\1\2+\7\3\2\2\2,.\t\2"+
		"\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\t\3\2\2\2\7\r\25!\'"+
		"/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}