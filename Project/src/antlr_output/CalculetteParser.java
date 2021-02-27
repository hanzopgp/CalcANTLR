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
		T__9=10, T__10=11, T__11=12, T__12=13, COND=14, TYPE=15, NEWLINE=16, WS=17, 
		ENTIER=18, FLOAT=19, IDENTIFIANT=20, UNMATCH=21;
	public static final int
		RULE_calcul = 0, RULE_instruction = 1, RULE_expression = 2, RULE_inputInstr = 3, 
		RULE_outputInstr = 4, RULE_loopInstr = 5, RULE_condition = 6, RULE_declaration = 7, 
		RULE_assignation = 8, RULE_finInstruction = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "instruction", "expression", "inputInstr", "outputInstr", "loopInstr", 
			"condition", "declaration", "assignation", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'read('", "'write('", 
			"'while('", "'true'", "'false'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "COND", "TYPE", "NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", 
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


	    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les
	                                                                                                  //liens var/type et les valeurs dans les adresses
	    private int _cur_label = 1;                                                                   
	    private String getNewLabel() { return "B" +(_cur_label++); }                                  //Generateur de nom d'etiquettes pour les boucles                                

	    public String evalCond(String exp1, String cond, String exp2){                                //Fonction renvoyant le code mvap pour chacune 
	      String res = exp1 + exp2;                                                                   //des conditions possibles
	      switch(cond){
	        case "==" :
	          return res + "EQUAL\n";
	        case "<=" :
	          return res + "INFEQ\n";
	        case ">=" :
	          return res + "SUPEQ\n";
	        case "<" :
	          return res + "INF\n";
	        case ">" :
	          return res + "SUP\n";
	        case "!=" :
	          return res + "NEQ\n";
	        default :
	          System.err.println("ERROR evalCond");
	          return "";
	      }
	    }

	    public String evalLoop(String condition, String instruction){                                 //Fonction renvoyant le code mvap pour creer
	      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
	      String endLabel = getNewLabel();
	      String res = "";
	      res += "LABEL " + startLabel + "\n";
	      res += condition;
	      res += "JUMPF " + endLabel + "\n";
	      res += instruction;
	      res += "JUMP " + startLabel + "\n";
	      res += "LABEL " + endLabel + "\n";
	      return res;
	    }


	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclarationContext declaration;
		public InstructionContext instruction;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
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
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(20);
					((CalculContext)_localctx).declaration = declaration();
					 _localctx.code += ((CalculContext)_localctx).declaration.code; 
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					match(NEWLINE);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__12) | (1L << TYPE) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(34);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(41);
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
		public DeclarationContext declaration;
		public AssignationContext assignation;
		public OutputInstrContext outputInstr;
		public InputInstrContext inputInstr;
		public LoopInstrContext loopInstr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public OutputInstrContext outputInstr() {
			return getRuleContext(OutputInstrContext.class,0);
		}
		public InputInstrContext inputInstr() {
			return getRuleContext(InputInstrContext.class,0);
		}
		public LoopInstrContext loopInstr() {
			return getRuleContext(LoopInstrContext.class,0);
		}
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
				setState(44);
				((InstructionContext)_localctx).expression = expression(0);
				setState(45);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ""; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				((InstructionContext)_localctx).declaration = declaration();
				setState(52);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).declaration.code; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				((InstructionContext)_localctx).assignation = assignation();
				setState(56);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
				((InstructionContext)_localctx).outputInstr = outputInstr();
				setState(60);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).outputInstr.code; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				((InstructionContext)_localctx).inputInstr = inputInstr();
				setState(64);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).inputInstr.code; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
				((InstructionContext)_localctx).loopInstr = loopInstr();
				setState(68);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loopInstr.code; 
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
			case T__0:
				{
				setState(74);
				match(T__0);
				setState(75);
				((ExpressionContext)_localctx).x = expression(0);
				setState(76);
				match(T__1);
				 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).x.code; 
				}
				break;
			case T__4:
			case T__5:
				{
				setState(79);
				((ExpressionContext)_localctx).op3 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
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
						if ( !(_la==T__2 || _la==T__3) ) {
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
						if ( !(_la==T__4 || _la==T__5) ) {
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

	public static class InputInstrContext extends ParserRuleContext {
		public String code;
		public Token id;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public InputInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInputInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInputInstr(this);
		}
	}

	public final InputInstrContext inputInstr() throws RecognitionException {
		InputInstrContext _localctx = new InputInstrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__6);
			setState(104);
			((InputInstrContext)_localctx).id = match(IDENTIFIANT);
			setState(105);
			match(T__1);
			 ((InputInstrContext)_localctx).code =  "PUSHI 0\nREAD\nSTOREG "+ tablesSymboles.getAdresseType((((InputInstrContext)_localctx).id!=null?((InputInstrContext)_localctx).id.getText():null)).adresse + "\n"; 
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

	public static class OutputInstrContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OutputInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterOutputInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitOutputInstr(this);
		}
	}

	public final OutputInstrContext outputInstr() throws RecognitionException {
		OutputInstrContext _localctx = new OutputInstrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_outputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__7);
			setState(109);
			((OutputInstrContext)_localctx).expression = expression(0);
			setState(110);
			match(T__1);
			 ((OutputInstrContext)_localctx).code =  ((OutputInstrContext)_localctx).expression.code + "WRITE\n"; 
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

	public static class LoopInstrContext extends ParserRuleContext {
		public String code;
		public ConditionContext condi;
		public InstructionContext instru;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public LoopInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterLoopInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitLoopInstr(this);
		}
	}

	public final LoopInstrContext loopInstr() throws RecognitionException {
		LoopInstrContext _localctx = new LoopInstrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loopInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__8);
			setState(114);
			((LoopInstrContext)_localctx).condi = condition();
			setState(115);
			match(T__1);
			setState(116);
			((LoopInstrContext)_localctx).instru = instruction();
			 ((LoopInstrContext)_localctx).code =  evalLoop(((LoopInstrContext)_localctx).condi.code, ((LoopInstrContext)_localctx).instru.code); 
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

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext exp1;
		public Token cond;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COND() { return getToken(CalculetteParser.COND, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__9);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n"; 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(T__10);
				 ((ConditionContext)_localctx).code =  "PUSHI 0\n"; 
				}
				break;
			case T__0:
			case T__4:
			case T__5:
			case ENTIER:
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				((ConditionContext)_localctx).exp1 = expression(0);
				setState(124);
				((ConditionContext)_localctx).cond = match(COND);
				setState(125);
				((ConditionContext)_localctx).exp2 = expression(0);
				 ((ConditionContext)_localctx).code =  evalCond(((ConditionContext)_localctx).exp1.code, (((ConditionContext)_localctx).cond!=null?((ConditionContext)_localctx).cond.getText():null), ((ConditionContext)_localctx).exp2.code); 
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

	public static class DeclarationContext extends ParserRuleContext {
		public String code;
		public Token type;
		public Token id;
		public ExpressionContext expression;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				((DeclarationContext)_localctx).type = match(TYPE);
				setState(131);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);

				        if((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null).equals("int")){
				          tablesSymboles.putVar((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), "int");
				          int adresse = tablesSymboles.getAdresseType((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)).adresse;
				          ((DeclarationContext)_localctx).code =  "PUSHI 0" + "\nSTOREG " + adresse + "\n"; 
				        }else if((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null).equals("float")){
				          tablesSymboles.putVar((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), "float");
				          int adresse = tablesSymboles.getAdresseType((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)).adresse;
				          ((DeclarationContext)_localctx).code =  "PUSHI 0.0" + "\nSTOREG " + adresse + "\n";
				        }
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((DeclarationContext)_localctx).type = match(TYPE);
				setState(134);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);
				setState(135);
				match(T__11);
				setState(136);
				((DeclarationContext)_localctx).expression = expression(0);

				          if((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null).equals("int")){
				            tablesSymboles.putVar((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), "int");                                                //On ajoute notre id avec son type pour
				            int adresse = tablesSymboles.getAdresseType((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)).adresse;                         //reserver une adresse
				            ((DeclarationContext)_localctx).code =  "PUSHI 0\n" + ((DeclarationContext)_localctx).expression.code + "\nSTOREG " + adresse + "\n";                 //Puis on la recupere pour le mvap
				          }else if((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null).equals("float")){
				            tablesSymboles.putVar((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), "float");
				            int adresse = tablesSymboles.getAdresseType((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)).adresse;
				            ((DeclarationContext)_localctx).code =  "PUSHI 0\n" + ((DeclarationContext)_localctx).expression.code + "\nSTOREG " + adresse + "\n";
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
		enterRule(_localctx, 16, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			((AssignationContext)_localctx).id = match(IDENTIFIANT);
			setState(142);
			match(T__11);
			setState(143);
			((AssignationContext)_localctx).expression = expression(0);
			 
			        int adresse = tablesSymboles.getAdresseType((((AssignationContext)_localctx).id!=null?((AssignationContext)_localctx).id.getText():null)).adresse;
			        ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "STOREG " + adresse + "\n"; 
			      
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
		enterRule(_localctx, 18, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(146);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==NEWLINE) ) {
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
				setState(149); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u009a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\7\2 \n\2\f\2\16\2#\13"+
		"\2\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4Y\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4e\n\4\f\4\16"+
		"\4h\13\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0083\n\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u008e\n\t\3\n\3\n\3\n\3\n\3\n\3\13\6\13\u0096\n"+
		"\13\r\13\16\13\u0097\3\13\2\3\6\f\2\4\6\b\n\f\16\20\22\24\2\5\3\2\7\b"+
		"\3\2\5\6\4\2\17\17\22\22\2\u00a1\2\33\3\2\2\2\4I\3\2\2\2\6X\3\2\2\2\b"+
		"i\3\2\2\2\nn\3\2\2\2\fs\3\2\2\2\16\u0082\3\2\2\2\20\u008d\3\2\2\2\22\u008f"+
		"\3\2\2\2\24\u0095\3\2\2\2\26\27\5\20\t\2\27\30\b\2\1\2\30\32\3\2\2\2\31"+
		"\26\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35\33"+
		"\3\2\2\2\36 \7\22\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\""+
		")\3\2\2\2#!\3\2\2\2$%\5\4\3\2%&\b\2\1\2&(\3\2\2\2\'$\3\2\2\2(+\3\2\2\2"+
		")\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\b\2\1\2-\3\3\2\2\2./\5\6\4"+
		"\2/\60\5\24\13\2\60\61\b\3\1\2\61J\3\2\2\2\62\63\5\24\13\2\63\64\b\3\1"+
		"\2\64J\3\2\2\2\65\66\5\20\t\2\66\67\5\24\13\2\678\b\3\1\28J\3\2\2\29:"+
		"\5\22\n\2:;\5\24\13\2;<\b\3\1\2<J\3\2\2\2=>\5\n\6\2>?\5\24\13\2?@\b\3"+
		"\1\2@J\3\2\2\2AB\5\b\5\2BC\5\24\13\2CD\b\3\1\2DJ\3\2\2\2EF\5\f\7\2FG\5"+
		"\24\13\2GH\b\3\1\2HJ\3\2\2\2I.\3\2\2\2I\62\3\2\2\2I\65\3\2\2\2I9\3\2\2"+
		"\2I=\3\2\2\2IA\3\2\2\2IE\3\2\2\2J\5\3\2\2\2KL\b\4\1\2LM\7\3\2\2MN\5\6"+
		"\4\2NO\7\4\2\2OP\b\4\1\2PY\3\2\2\2QR\t\2\2\2RS\7\24\2\2SY\b\4\1\2TU\7"+
		"\24\2\2UY\b\4\1\2VW\7\26\2\2WY\b\4\1\2XK\3\2\2\2XQ\3\2\2\2XT\3\2\2\2X"+
		"V\3\2\2\2Yf\3\2\2\2Z[\f\7\2\2[\\\t\3\2\2\\]\5\6\4\b]^\b\4\1\2^e\3\2\2"+
		"\2_`\f\6\2\2`a\t\2\2\2ab\5\6\4\7bc\b\4\1\2ce\3\2\2\2dZ\3\2\2\2d_\3\2\2"+
		"\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\7\3\2\2\2hf\3\2\2\2ij\7\t\2\2jk\7\26"+
		"\2\2kl\7\4\2\2lm\b\5\1\2m\t\3\2\2\2no\7\n\2\2op\5\6\4\2pq\7\4\2\2qr\b"+
		"\6\1\2r\13\3\2\2\2st\7\13\2\2tu\5\16\b\2uv\7\4\2\2vw\5\4\3\2wx\b\7\1\2"+
		"x\r\3\2\2\2yz\7\f\2\2z\u0083\b\b\1\2{|\7\r\2\2|\u0083\b\b\1\2}~\5\6\4"+
		"\2~\177\7\20\2\2\177\u0080\5\6\4\2\u0080\u0081\b\b\1\2\u0081\u0083\3\2"+
		"\2\2\u0082y\3\2\2\2\u0082{\3\2\2\2\u0082}\3\2\2\2\u0083\17\3\2\2\2\u0084"+
		"\u0085\7\21\2\2\u0085\u0086\7\26\2\2\u0086\u008e\b\t\1\2\u0087\u0088\7"+
		"\21\2\2\u0088\u0089\7\26\2\2\u0089\u008a\7\16\2\2\u008a\u008b\5\6\4\2"+
		"\u008b\u008c\b\t\1\2\u008c\u008e\3\2\2\2\u008d\u0084\3\2\2\2\u008d\u0087"+
		"\3\2\2\2\u008e\21\3\2\2\2\u008f\u0090\7\26\2\2\u0090\u0091\7\16\2\2\u0091"+
		"\u0092\5\6\4\2\u0092\u0093\b\n\1\2\u0093\23\3\2\2\2\u0094\u0096\t\4\2"+
		"\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\25\3\2\2\2\f\33!)IXdf\u0082\u008d\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}