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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TYPE=11, NEWLINE=12, WS=13, ENTIER=14, FLOAT=15, IDENTIFIANT=16, 
		UNMATCH=17;
	public static final int
		RULE_calcul = 0, RULE_instruction = 1, RULE_expression = 2, RULE_finInstruction = 3, 
		RULE_decl = 4, RULE_assignation = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "instruction", "expression", "finInstruction", "decl", "assignation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'write('", "')'", "'read('", "'('", "'*'", "'/'", "'+'", "'-'", 
			"';'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
			"NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
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


	    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
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
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
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
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(12);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(20);
					match(NEWLINE);
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(26);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(33);
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
		public AssignationContext assignation;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				((InstructionContext)_localctx).expression = expression(0);
				setState(37);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ""; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				((InstructionContext)_localctx).assignation = assignation();
				setState(44);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(T__0);
				setState(48);
				match(IDENTIFIANT);
				setState(49);
				match(T__1);
				setState(50);
				finInstruction();
				 ((InstructionContext)_localctx).code =  "WRITE\nPOP\n"; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				match(T__2);
				setState(54);
				match(IDENTIFIANT);
				setState(55);
				match(T__1);
				setState(56);
				finInstruction();
				 ((InstructionContext)_localctx).code =  "READ\n"; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				match(T__0);
				setState(60);
				((InstructionContext)_localctx).expression = expression(0);
				setState(61);
				match(T__1);
				setState(62);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code + "WRITE\nPOP\n"; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				match(T__2);
				setState(66);
				((InstructionContext)_localctx).expression = expression(0);
				setState(67);
				match(T__1);
				setState(68);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code + "READ\n"; 
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
		public ExpressionContext a;
		public ExpressionContext c;
		public ExpressionContext x;
		public Token op3;
		public Token e;
		public Token n;
		public Token id;
		public Token op1;
		public ExpressionContext b;
		public Token op2;
		public ExpressionContext d;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(74);
				match(T__3);
				setState(75);
				((ExpressionContext)_localctx).x = expression(0);
				setState(76);
				match(T__1);
				 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).x.code; 
				}
				break;
			case T__6:
			case T__7:
				{
				setState(79);
				((ExpressionContext)_localctx).op3 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
					((ExpressionContext)_localctx).op3 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(80);
				((ExpressionContext)_localctx).e = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI 0\n" + "PUSHI " + (((ExpressionContext)_localctx).e!=null?((ExpressionContext)_localctx).e.getText():null) + "\n" + ((((ExpressionContext)_localctx).op3!=null?((ExpressionContext)_localctx).op3.getText():null).equals("+") ? "ADD" : "SUB") + "\n"; 
				}
				break;
			case ENTIER:
				{
				setState(82);
				((ExpressionContext)_localctx).n = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).n!=null?((ExpressionContext)_localctx).n.getText():null) + "\n"; 
				}
				break;
			case IDENTIFIANT:
				{
				setState(84);
				((ExpressionContext)_localctx).id = match(IDENTIFIANT);
				 ((ExpressionContext)_localctx).code =  "PUSHG " + tablesSymboles.getAdresseType((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null)).adresse + "\n"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(98);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(89);
						((ExpressionContext)_localctx).op1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((ExpressionContext)_localctx).op1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(90);
						((ExpressionContext)_localctx).b = expression(6);
						 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + ((((ExpressionContext)_localctx).op1!=null?((ExpressionContext)_localctx).op1.getText():null).equals("*") ? "MUL" : "DIV") + "\n"; 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.c = _prevctx;
						_localctx.c = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(94);
						((ExpressionContext)_localctx).op2 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((ExpressionContext)_localctx).op2 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(95);
						((ExpressionContext)_localctx).d = expression(5);
						 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).c.code + ((ExpressionContext)_localctx).d.code + ((((ExpressionContext)_localctx).op2!=null?((ExpressionContext)_localctx).op2.getText():null).equals("+") ? "ADD" : "SUB") + "\n"; 
						}
						break;
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
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
			setState(104); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(103);
					_la = _input.LA(1);
					if ( !(_la==T__8 || _la==NEWLINE) ) {
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
				setState(106); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token type;
		public Token id;
		public ExpressionContext expression;
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((DeclContext)_localctx).type = match(TYPE);
				setState(109);
				((DeclContext)_localctx).id = match(IDENTIFIANT);
				setState(110);
				finInstruction();

				        if((((DeclContext)_localctx).type!=null?((DeclContext)_localctx).type.getText():null).equals("int")){
				          tablesSymboles.putVar((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null), "int");
				          int adresse = tablesSymboles.getAdresseType((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null)).adresse;
				          ((DeclContext)_localctx).code =  "PUSHI 0" + "\nSTOREG " + adresse + "\n"; 
				        }else if((((DeclContext)_localctx).type!=null?((DeclContext)_localctx).type.getText():null).equals("float")){
				          tablesSymboles.putVar((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null), "float");
				          int adresse = tablesSymboles.getAdresseType((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null)).adresse;
				          ((DeclContext)_localctx).code =  "PUSHI 0.0" + "\nSTOREG " + adresse + "\n";
				        }
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				((DeclContext)_localctx).type = match(TYPE);
				setState(114);
				((DeclContext)_localctx).id = match(IDENTIFIANT);
				setState(115);
				match(T__9);
				setState(116);
				((DeclContext)_localctx).expression = expression(0);
				setState(117);
				finInstruction();

				          if((((DeclContext)_localctx).type!=null?((DeclContext)_localctx).type.getText():null).equals("int")){
				            tablesSymboles.putVar((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null), "int");                                                //On ajoute notre id avec son type pour
				            int adresse = tablesSymboles.getAdresseType((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null)).adresse;                         //reserver une adresse
				            ((DeclContext)_localctx).code =  ((DeclContext)_localctx).expression.code + "\nSTOREG " + adresse + "\n";                               //Puis on la recupere pour le mvap
				          }else if((((DeclContext)_localctx).type!=null?((DeclContext)_localctx).type.getText():null).equals("float")){
				            tablesSymboles.putVar((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null), "float");
				            int adresse = tablesSymboles.getAdresseType((((DeclContext)_localctx).id!=null?((DeclContext)_localctx).id.getText():null)).adresse;
				            ((DeclContext)_localctx).code =  ((DeclContext)_localctx).expression.code + "\nSTOREG " + adresse + "\n";
				          }
				        
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token id;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			((AssignationContext)_localctx).id = match(IDENTIFIANT);
			setState(123);
			match(T__9);
			setState(124);
			((AssignationContext)_localctx).expression = expression(0);
			 
			        int adresse = tablesSymboles.getAdresseType((((AssignationContext)_localctx).id!=null?((AssignationContext)_localctx).id.getText():null)).adresse;
			        ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "\nSTOREG " + adresse + "\n"; 
			      
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
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\u0082\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16"+
		"\2\25\13\2\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\2\7\2 \n\2\f\2\16"+
		"\2#\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4Y\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4e\n\4\f\4"+
		"\16\4h\13\4\3\5\6\5k\n\5\r\5\16\5l\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6{\n\6\3\7\3\7\3\7\3\7\3\7\3\7\2\3\6\b\2\4\6\b\n\f\2\5"+
		"\3\2\t\n\3\2\7\b\4\2\13\13\16\16\2\u008b\2\23\3\2\2\2\4I\3\2\2\2\6X\3"+
		"\2\2\2\bj\3\2\2\2\nz\3\2\2\2\f|\3\2\2\2\16\17\5\n\6\2\17\20\b\2\1\2\20"+
		"\22\3\2\2\2\21\16\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24"+
		"\31\3\2\2\2\25\23\3\2\2\2\26\30\7\16\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31"+
		"\27\3\2\2\2\31\32\3\2\2\2\32!\3\2\2\2\33\31\3\2\2\2\34\35\5\4\3\2\35\36"+
		"\b\2\1\2\36 \3\2\2\2\37\34\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\""+
		"$\3\2\2\2#!\3\2\2\2$%\b\2\1\2%\3\3\2\2\2&\'\5\6\4\2\'(\5\b\5\2()\b\3\1"+
		"\2)J\3\2\2\2*+\5\b\5\2+,\b\3\1\2,J\3\2\2\2-.\5\f\7\2./\5\b\5\2/\60\b\3"+
		"\1\2\60J\3\2\2\2\61\62\7\3\2\2\62\63\7\22\2\2\63\64\7\4\2\2\64\65\5\b"+
		"\5\2\65\66\b\3\1\2\66J\3\2\2\2\678\7\5\2\289\7\22\2\29:\7\4\2\2:;\5\b"+
		"\5\2;<\b\3\1\2<J\3\2\2\2=>\7\3\2\2>?\5\6\4\2?@\7\4\2\2@A\5\b\5\2AB\b\3"+
		"\1\2BJ\3\2\2\2CD\7\5\2\2DE\5\6\4\2EF\7\4\2\2FG\5\b\5\2GH\b\3\1\2HJ\3\2"+
		"\2\2I&\3\2\2\2I*\3\2\2\2I-\3\2\2\2I\61\3\2\2\2I\67\3\2\2\2I=\3\2\2\2I"+
		"C\3\2\2\2J\5\3\2\2\2KL\b\4\1\2LM\7\6\2\2MN\5\6\4\2NO\7\4\2\2OP\b\4\1\2"+
		"PY\3\2\2\2QR\t\2\2\2RS\7\20\2\2SY\b\4\1\2TU\7\20\2\2UY\b\4\1\2VW\7\22"+
		"\2\2WY\b\4\1\2XK\3\2\2\2XQ\3\2\2\2XT\3\2\2\2XV\3\2\2\2Yf\3\2\2\2Z[\f\7"+
		"\2\2[\\\t\3\2\2\\]\5\6\4\b]^\b\4\1\2^e\3\2\2\2_`\f\6\2\2`a\t\2\2\2ab\5"+
		"\6\4\7bc\b\4\1\2ce\3\2\2\2dZ\3\2\2\2d_\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3"+
		"\2\2\2g\7\3\2\2\2hf\3\2\2\2ik\t\4\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm"+
		"\3\2\2\2m\t\3\2\2\2no\7\r\2\2op\7\22\2\2pq\5\b\5\2qr\b\6\1\2r{\3\2\2\2"+
		"st\7\r\2\2tu\7\22\2\2uv\7\f\2\2vw\5\6\4\2wx\5\b\5\2xy\b\6\1\2y{\3\2\2"+
		"\2zn\3\2\2\2zs\3\2\2\2{\13\3\2\2\2|}\7\22\2\2}~\7\f\2\2~\177\5\6\4\2\177"+
		"\u0080\b\7\1\2\u0080\r\3\2\2\2\13\23\31!IXdflz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}