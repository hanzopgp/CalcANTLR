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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, EXPRLOG=16, 
		COND=17, TYPE=18, NEWLINE=19, WS=20, ENTIER=21, FLOAT=22, IDENTIFIANT=23, 
		UNMATCH=24;
	public static final int
		RULE_calcul = 0, RULE_block = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_inputInstr = 4, RULE_outputInstr = 5, RULE_loopInstr = 6, RULE_conditionAvecLogique = 7, 
		RULE_condition = 8, RULE_declaration = 9, RULE_assignation = 10, RULE_finInstruction = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "block", "instruction", "expression", "inputInstr", "outputInstr", 
			"loopInstr", "conditionAvecLogique", "condition", "declaration", "assignation", 
			"finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'read('", 
			"'write('", "'while('", "'true'", "'false'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "EXPRLOG", "COND", "TYPE", "NEWLINE", "WS", "ENTIER", 
			"FLOAT", "IDENTIFIANT", "UNMATCH"
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
	    private int _cur_label = 1;                                                                   //liens var/type et les valeurs dans les adresses
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

	    public String evalLoop(String condition, String block){                                       //Fonction renvoyant le code mvap pour creer
	      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
	      String endLabel = getNewLabel();
	      String res = "";
	      res += "LABEL " + startLabel + "\n";
	      res += condition;
	      res += "JUMPF " + endLabel + "\n";
	      res += block;
	      res += "JUMP " + startLabel + "\n";
	      res += "LABEL " + endLabel + "\n";
	      return res;
	    }

	    public String evalCondAvecLog(String cond1, String exprlog, String cond2){
	      String res = "";
	      switch(exprlog){
	        case "!" :
	        case "||" :
	        case "&&" :
	        default :
	          System.err.println("ERROR evalCondAvecLog");
	          return "";
	      }
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
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					((CalculContext)_localctx).declaration = declaration();
					 _localctx.code += ((CalculContext)_localctx).declaration.code; 
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(32);
					match(NEWLINE);
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << TYPE) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(38);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(45);
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

	public static class BlockContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((BlockContext)_localctx).code =  ""; 
			setState(49);
			match(T__0);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << TYPE) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(50);
				((BlockContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlockContext)_localctx).instruction.code; 
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(T__1);
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
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				((InstructionContext)_localctx).expression = expression(0);
				setState(61);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ""; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				((InstructionContext)_localctx).declaration = declaration();
				setState(68);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).declaration.code; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				((InstructionContext)_localctx).assignation = assignation();
				setState(72);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				((InstructionContext)_localctx).outputInstr = outputInstr();
				setState(76);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).outputInstr.code; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				((InstructionContext)_localctx).inputInstr = inputInstr();
				setState(80);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).inputInstr.code; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				((InstructionContext)_localctx).loopInstr = loopInstr();
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(89);
				match(T__2);
				setState(90);
				((ExpressionContext)_localctx).x = expression(0);
				setState(91);
				match(T__3);
				 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).x.code; 
				}
				break;
			case T__6:
			case T__7:
				{
				setState(94);
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
				setState(95);
				((ExpressionContext)_localctx).e = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI 0\n" + "PUSHI " + (((ExpressionContext)_localctx).e!=null?((ExpressionContext)_localctx).e.getText():null) + "\n" + ((((ExpressionContext)_localctx).op3!=null?((ExpressionContext)_localctx).op3.getText():null).equals("+") ? "ADD" : "SUB") + "\n"; 
				}
				break;
			case ENTIER:
				{
				setState(97);
				((ExpressionContext)_localctx).n = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).n!=null?((ExpressionContext)_localctx).n.getText():null) + "\n"; 
				}
				break;
			case IDENTIFIANT:
				{
				setState(99);
				((ExpressionContext)_localctx).id = match(IDENTIFIANT);
				 ((ExpressionContext)_localctx).code =  "PUSHG " + tablesSymboles.getAdresseType((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null)).adresse + "\n"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(104);
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
						setState(105);
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
						setState(108);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(109);
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
						setState(110);
						((ExpressionContext)_localctx).d = expression(5);
						 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).c.code + ((ExpressionContext)_localctx).d.code + ((((ExpressionContext)_localctx).op2!=null?((ExpressionContext)_localctx).op2.getText():null).equals("+") ? "ADD" : "SUB") + "\n"; 
						}
						break;
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 8, RULE_inputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__8);
			setState(119);
			((InputInstrContext)_localctx).id = match(IDENTIFIANT);
			setState(120);
			match(T__3);
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
		enterRule(_localctx, 10, RULE_outputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__9);
			setState(124);
			((OutputInstrContext)_localctx).expression = expression(0);
			setState(125);
			match(T__3);
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
		public ConditionContext condition;
		public BlockContext block;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 12, RULE_loopInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__10);
			setState(129);
			((LoopInstrContext)_localctx).condition = condition();
			setState(130);
			match(T__3);
			setState(131);
			((LoopInstrContext)_localctx).block = block();
			 ((LoopInstrContext)_localctx).code =  evalLoop(((LoopInstrContext)_localctx).condition.code, ((LoopInstrContext)_localctx).block.code); 
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

	public static class ConditionAvecLogiqueContext extends ParserRuleContext {
		public String code;
		public ConditionContext cond1;
		public Token exprlog;
		public ConditionContext cond2;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode EXPRLOG() { return getToken(CalculetteParser.EXPRLOG, 0); }
		public ConditionAvecLogiqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAvecLogique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterConditionAvecLogique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitConditionAvecLogique(this);
		}
	}

	public final ConditionAvecLogiqueContext conditionAvecLogique() throws RecognitionException {
		ConditionAvecLogiqueContext _localctx = new ConditionAvecLogiqueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionAvecLogique);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			((ConditionAvecLogiqueContext)_localctx).cond1 = condition();
			setState(135);
			((ConditionAvecLogiqueContext)_localctx).exprlog = match(EXPRLOG);
			setState(136);
			((ConditionAvecLogiqueContext)_localctx).cond2 = condition();
			 ((ConditionAvecLogiqueContext)_localctx).code =  evalCondAvecLog(((ConditionAvecLogiqueContext)_localctx).cond1.code, (((ConditionAvecLogiqueContext)_localctx).exprlog!=null?((ConditionAvecLogiqueContext)_localctx).exprlog.getText():null), ((ConditionAvecLogiqueContext)_localctx).cond2.code); 
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
		enterRule(_localctx, 16, RULE_condition);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(T__11);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n"; 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(T__12);
				 ((ConditionContext)_localctx).code =  "PUSHI 0\n"; 
				}
				break;
			case T__2:
			case T__6:
			case T__7:
			case ENTIER:
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				((ConditionContext)_localctx).exp1 = expression(0);
				setState(144);
				((ConditionContext)_localctx).cond = match(COND);
				setState(145);
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
		enterRule(_localctx, 18, RULE_declaration);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				((DeclarationContext)_localctx).type = match(TYPE);
				setState(151);
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
				setState(153);
				((DeclarationContext)_localctx).type = match(TYPE);
				setState(154);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);
				setState(155);
				match(T__13);
				setState(156);
				((DeclarationContext)_localctx).expression = expression(0);

				          if((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null).equals("int")){
				            tablesSymboles.putVar((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), "int");                                                //On ajoute notre id avec son type pour
				            int adresse = tablesSymboles.getAdresseType((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)).adresse;                         //reserver une adresse
				            ((DeclarationContext)_localctx).code =  "PUSHI 0\n" + ((DeclarationContext)_localctx).expression.code + "STOREG " + adresse + "\n";                   //Puis on la recupere pour le mvap
				          }else if((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null).equals("float")){
				            tablesSymboles.putVar((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), "float");
				            int adresse = tablesSymboles.getAdresseType((((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)).adresse;
				            ((DeclarationContext)_localctx).code =  "PUSHI 0.0\n" + ((DeclarationContext)_localctx).expression.code + "STOREG " + adresse + "\n";
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
		enterRule(_localctx, 20, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((AssignationContext)_localctx).id = match(IDENTIFIANT);
			setState(162);
			match(T__13);
			setState(163);
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
		enterRule(_localctx, 22, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(166);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==NEWLINE) ) {
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
				setState(169); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		case 3:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u00ae\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5h\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5t\n\5\f\5\16\5w\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0097\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a2\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\6\r\u00aa\n\r\r\r\16\r\u00ab\3\r\2\3\b\16\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\2\5\3\2\t\n\3\2\7\b\4\2\21\21\25\25\2\u00b4\2\37\3\2\2\2"+
		"\4\62\3\2\2\2\6X\3\2\2\2\bg\3\2\2\2\nx\3\2\2\2\f}\3\2\2\2\16\u0082\3\2"+
		"\2\2\20\u0088\3\2\2\2\22\u0096\3\2\2\2\24\u00a1\3\2\2\2\26\u00a3\3\2\2"+
		"\2\30\u00a9\3\2\2\2\32\33\5\24\13\2\33\34\b\2\1\2\34\36\3\2\2\2\35\32"+
		"\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 %\3\2\2\2!\37\3\2\2\2\""+
		"$\7\25\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&-\3\2\2\2\'%\3\2"+
		"\2\2()\5\6\4\2)*\b\2\1\2*,\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2"+
		"\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\b\2\1\2\61\3\3\2\2\2\62\63\b\3\1\2\63"+
		"9\7\3\2\2\64\65\5\6\4\2\65\66\b\3\1\2\668\3\2\2\2\67\64\3\2\2\28;\3\2"+
		"\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\4\2\2=\5\3\2\2\2>?"+
		"\5\b\5\2?@\5\30\r\2@A\b\4\1\2AY\3\2\2\2BC\5\30\r\2CD\b\4\1\2DY\3\2\2\2"+
		"EF\5\24\13\2FG\5\30\r\2GH\b\4\1\2HY\3\2\2\2IJ\5\26\f\2JK\5\30\r\2KL\b"+
		"\4\1\2LY\3\2\2\2MN\5\f\7\2NO\5\30\r\2OP\b\4\1\2PY\3\2\2\2QR\5\n\6\2RS"+
		"\5\30\r\2ST\b\4\1\2TY\3\2\2\2UV\5\16\b\2VW\b\4\1\2WY\3\2\2\2X>\3\2\2\2"+
		"XB\3\2\2\2XE\3\2\2\2XI\3\2\2\2XM\3\2\2\2XQ\3\2\2\2XU\3\2\2\2Y\7\3\2\2"+
		"\2Z[\b\5\1\2[\\\7\5\2\2\\]\5\b\5\2]^\7\6\2\2^_\b\5\1\2_h\3\2\2\2`a\t\2"+
		"\2\2ab\7\27\2\2bh\b\5\1\2cd\7\27\2\2dh\b\5\1\2ef\7\31\2\2fh\b\5\1\2gZ"+
		"\3\2\2\2g`\3\2\2\2gc\3\2\2\2ge\3\2\2\2hu\3\2\2\2ij\f\7\2\2jk\t\3\2\2k"+
		"l\5\b\5\blm\b\5\1\2mt\3\2\2\2no\f\6\2\2op\t\2\2\2pq\5\b\5\7qr\b\5\1\2"+
		"rt\3\2\2\2si\3\2\2\2sn\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\t\3\2\2"+
		"\2wu\3\2\2\2xy\7\13\2\2yz\7\31\2\2z{\7\6\2\2{|\b\6\1\2|\13\3\2\2\2}~\7"+
		"\f\2\2~\177\5\b\5\2\177\u0080\7\6\2\2\u0080\u0081\b\7\1\2\u0081\r\3\2"+
		"\2\2\u0082\u0083\7\r\2\2\u0083\u0084\5\22\n\2\u0084\u0085\7\6\2\2\u0085"+
		"\u0086\5\4\3\2\u0086\u0087\b\b\1\2\u0087\17\3\2\2\2\u0088\u0089\5\22\n"+
		"\2\u0089\u008a\7\22\2\2\u008a\u008b\5\22\n\2\u008b\u008c\b\t\1\2\u008c"+
		"\21\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u0097\b\n\1\2\u008f\u0090\7\17"+
		"\2\2\u0090\u0097\b\n\1\2\u0091\u0092\5\b\5\2\u0092\u0093\7\23\2\2\u0093"+
		"\u0094\5\b\5\2\u0094\u0095\b\n\1\2\u0095\u0097\3\2\2\2\u0096\u008d\3\2"+
		"\2\2\u0096\u008f\3\2\2\2\u0096\u0091\3\2\2\2\u0097\23\3\2\2\2\u0098\u0099"+
		"\7\24\2\2\u0099\u009a\7\31\2\2\u009a\u00a2\b\13\1\2\u009b\u009c\7\24\2"+
		"\2\u009c\u009d\7\31\2\2\u009d\u009e\7\20\2\2\u009e\u009f\5\b\5\2\u009f"+
		"\u00a0\b\13\1\2\u00a0\u00a2\3\2\2\2\u00a1\u0098\3\2\2\2\u00a1\u009b\3"+
		"\2\2\2\u00a2\25\3\2\2\2\u00a3\u00a4\7\31\2\2\u00a4\u00a5\7\20\2\2\u00a5"+
		"\u00a6\5\b\5\2\u00a6\u00a7\b\f\1\2\u00a7\27\3\2\2\2\u00a8\u00aa\t\4\2"+
		"\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\31\3\2\2\2\r\37%-9Xgsu\u0096\u00a1\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}