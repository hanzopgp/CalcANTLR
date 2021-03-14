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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, KEYWORDS=23, EXPRLOG=24, 
		COND=25, TYPE=26, ENTIER=27, FLOAT=28, BOOL=29, IDENTIFIANT=30, NEWLINE=31, 
		WS=32, UNMATCH=33;
	public static final int
		RULE_calcul = 0, RULE_block = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_ifElseInstr = 4, RULE_inputInstr = 5, RULE_outputInstr = 6, RULE_loopInstr = 7, 
		RULE_conditionAvecLogique = 8, RULE_condition = 9, RULE_declaration = 10, 
		RULE_assignation = 11, RULE_fonction = 12, RULE_params = 13, RULE_args = 14, 
		RULE_returnInstr = 15, RULE_finInstruction = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "block", "instruction", "expression", "ifElseInstr", "inputInstr", 
			"outputInstr", "loopInstr", "conditionAvecLogique", "condition", "declaration", 
			"assignation", "fonction", "params", "args", "returnInstr", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'if('", 
			"'else'", "'read('", "'write('", "'while('", "'for('", "';'", "'repeat'", 
			"'until('", "'true'", "'false'", "'='", "','", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "KEYWORDS", 
			"EXPRLOG", "COND", "TYPE", "ENTIER", "FLOAT", "BOOL", "IDENTIFIANT", 
			"NEWLINE", "WS", "UNMATCH"
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

	    public String trad(String currentType, String expr, String targetType){
	      String res = expr;
	      switch(targetType){
	        case "int":
	          if(currentType.equals("float")){
	            res += "FTOI\n";   
	          }
	          break;  
	        case "float":   
	          res += "ITOF\n";
	          break;                             
	        case "bool":    
	          String trueLabel = getNewLabel();
	          String falseLabel = getNewLabel();                           
	          String pushType;
	          String equalType;
	          if(currentType.equals("float")){
	            pushType = "PUSHF 0\n";
	            equalType = "FEQUAL\n";
	          }else{
	            pushType = "PUSHI 0.0\n";
	            equalType = "EQUAL\n";
	          }   
	          res += pushType + equalType + "JUMPF " + trueLabel + "\nPUSHI 0\n" 
	              + "JUMP " + falseLabel + "\nLABEL " + trueLabel + "\nPUSHI 1\n" 
	              + "LABEL " + falseLabel + "\n";
	          break;
	        }
	        return res;
	    }

	    public String evalDeclaration(String type, String id){                                                     //Renvoie le code pour une declaration simple
	      tablesSymboles.putVar(id, type);
	      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n";
	    }

	    public String evalDeclarationExpr(String type, String id, String expr, String exprType){                              //Renvoie le code pour une declaration assignation
	      tablesSymboles.putVar(id, type);  
	      AdresseType at = tablesSymboles.getAdresseType(id); 
	      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n"
	             + trad(exprType, expr, at.type) + "STOREG "  + at.adresse + "\n";
	    }

	    public String evalAssign(String id, String expr, String exprType){
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      return trad(exprType, expr, at.type) + "STOREG " + at.adresse + "\n";
	    }

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

	    public String evalWhileLoop(String expr, String exprType, String block){                                  //Fonction renvoyant le code mvap pour creer
	      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
	      String endLabel = getNewLabel();
	      String tradExpr = trad(exprType, expr, "bool");
	      return "LABEL " + startLabel + "\n" + tradExpr + "JUMPF " + endLabel + "\n"
	             + block + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
	    }

	    public String evalForLoop(String init, String expr, String exprType, String iteration, String block){     //Fonction renvoyant le code mvap pour creer une
	      String startLabel = getNewLabel();                                                          //boucle for
	      String endLabel = getNewLabel();
	      String tradExpr = trad(exprType, expr, "bool");
	      return init + "LABEL " + startLabel + "\n" + tradExpr + "JUMPF " + endLabel + "\n"
	             + block + iteration + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
	    }

	    public String evalRepeatLoop(String expr, String exprType, String block){                                 //Fonction renvoyant le code mvap pour creer une                  
	      String startLabel = getNewLabel();
	      String tradExpr = trad(exprType, expr, "bool"); 
	      return "LABEL " + startLabel + "\n" + block 
	             + tradExpr + "\n" + "JUMPF " + startLabel + "\n";
	    }

	    public String evalCondAvecLog(String cond1, String exprlog, String cond2){                    //Fonction renvoyant le code apres avoir tester
	      String res = "";                                                                            //en prenant en compte la logique booleene
	      switch(exprlog){
	        case "!" :
	        case "||" :
	        case "&&" :
	        default :
	          System.err.println("ERROR evalCondAvecLog");
	          return "";
	      }
	    }

	    public String evalIfElse(String expr, String exprType, String ifBlock, String elseBlock){                 //Fonction renvoyant le code pour gerer les                                                                
	      String elseStartLabel = getNewLabel();                                                      //branchement if else
	      String ifEndLabel = getNewLabel(); 
	      String tradExpr = trad(exprType, expr, "bool"); 
	      String res = tradExpr + "\n" + "JUMPF " + elseStartLabel +"\n" 
	                 + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
	                 + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
	      return res;
	    }

	    public String evalIf(String expr, String exprType, String ifBlock){                                       //Fonction renvoyant le code pour gerer les
	      String ifEndLabel = getNewLabel();   
	      String tradExpr = trad(exprType, expr, "bool");                                                       //branchement if
	      String res = tradExpr + "\n" + "JUMPF " + ifEndLabel 
	                 + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
	      return res;
	    }

	    public String evalReturn(String expr, String exprType){
	      AdresseType at = tablesSymboles.getAdresseType("return");
	      String res = trad(expr, exprType, at.type)
	                 + "STOREG " + at.adresse + "\n" + "RETURN\n";
	    }

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclarationContext declaration;
		public FonctionContext fonction;
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
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
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
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					((CalculContext)_localctx).declaration = declaration();
					 _localctx.code += ((CalculContext)_localctx).declaration.code; 
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 _localctx.code += "JUMP " + "Main\n"; 
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					match(NEWLINE);
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					((CalculContext)_localctx).fonction = fonction();
					 _localctx.code += ((CalculContext)_localctx).fonction.code; 
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(57);
					match(NEWLINE);
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL " + "Main\n"; 
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__21) | (1L << TYPE) | (1L << ENTIER) | (1L << IDENTIFIANT) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(64);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(71);
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
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
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
		 ((BlockContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__0);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__21) | (1L << TYPE) | (1L << ENTIER) | (1L << IDENTIFIANT) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(75);
				((BlockContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlockContext)_localctx).instruction.code; 
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(T__1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(84);
					match(NEWLINE);
					}
					} 
				}
				setState(89);
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
		public IfElseInstrContext ifElseInstr;
		public ReturnInstrContext returnInstr;
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
		public IfElseInstrContext ifElseInstr() {
			return getRuleContext(IfElseInstrContext.class,0);
		}
		public ReturnInstrContext returnInstr() {
			return getRuleContext(ReturnInstrContext.class,0);
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
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((InstructionContext)_localctx).expression = expression(0);
				setState(91);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ""; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				((InstructionContext)_localctx).declaration = declaration();
				setState(98);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).declaration.code; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				((InstructionContext)_localctx).assignation = assignation();
				setState(102);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				((InstructionContext)_localctx).outputInstr = outputInstr();
				setState(106);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).outputInstr.code; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				((InstructionContext)_localctx).inputInstr = inputInstr();
				setState(110);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).inputInstr.code; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(113);
				((InstructionContext)_localctx).loopInstr = loopInstr();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loopInstr.code; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(116);
				((InstructionContext)_localctx).ifElseInstr = ifElseInstr();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).ifElseInstr.code; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(119);
				((InstructionContext)_localctx).returnInstr = returnInstr();
				setState(120);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).returnInstr.code; 
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
		public String type;
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
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(126);
				match(T__2);
				setState(127);
				((ExpressionContext)_localctx).x = expression(0);
				setState(128);
				match(T__3);
				 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).x.code; 
				}
				break;
			case T__6:
			case T__7:
				{
				setState(131);
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
				setState(132);
				((ExpressionContext)_localctx).e = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI 0\n" + "PUSHI " + (((ExpressionContext)_localctx).e!=null?((ExpressionContext)_localctx).e.getText():null) + "\n" + ((((ExpressionContext)_localctx).op3!=null?((ExpressionContext)_localctx).op3.getText():null).equals("+") ? "ADD" : "SUB") + "\n"; 
				}
				break;
			case ENTIER:
				{
				setState(134);
				((ExpressionContext)_localctx).n = match(ENTIER);
				 ((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).n!=null?((ExpressionContext)_localctx).n.getText():null) + "\n"; 
				}
				break;
			case IDENTIFIANT:
				{
				setState(136);
				((ExpressionContext)_localctx).id = match(IDENTIFIANT);
				 ((ExpressionContext)_localctx).code =  "PUSHG " + tablesSymboles.getAdresseType((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null)).adresse + "\n"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(141);
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
						setState(142);
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
						setState(145);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(146);
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
						setState(147);
						((ExpressionContext)_localctx).d = expression(5);
						 ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).c.code + ((ExpressionContext)_localctx).d.code + ((((ExpressionContext)_localctx).op2!=null?((ExpressionContext)_localctx).op2.getText():null).equals("+") ? "ADD" : "SUB") + "\n"; 
						}
						break;
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class IfElseInstrContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public BlockContext ifblock;
		public BlockContext elseblock;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterIfElseInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitIfElseInstr(this);
		}
	}

	public final IfElseInstrContext ifElseInstr() throws RecognitionException {
		IfElseInstrContext _localctx = new IfElseInstrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifElseInstr);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(T__8);
				setState(156);
				((IfElseInstrContext)_localctx).expression = expression(0);
				setState(157);
				match(T__3);
				setState(158);
				((IfElseInstrContext)_localctx).ifblock = block();
				 ((IfElseInstrContext)_localctx).code =  evalIf(((IfElseInstrContext)_localctx).expression.code, ((IfElseInstrContext)_localctx).expression.type, ((IfElseInstrContext)_localctx).ifblock.code); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(T__8);
				setState(162);
				((IfElseInstrContext)_localctx).expression = expression(0);
				setState(163);
				match(T__3);
				setState(164);
				((IfElseInstrContext)_localctx).ifblock = block();
				setState(165);
				match(T__9);
				setState(166);
				((IfElseInstrContext)_localctx).elseblock = block();
				 ((IfElseInstrContext)_localctx).code =  evalIfElse(((IfElseInstrContext)_localctx).expression.code, ((IfElseInstrContext)_localctx).expression.type, ((IfElseInstrContext)_localctx).ifblock.code, ((IfElseInstrContext)_localctx).elseblock.code); 
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
		enterRule(_localctx, 10, RULE_inputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__10);
			setState(172);
			((InputInstrContext)_localctx).id = match(IDENTIFIANT);
			setState(173);
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
		enterRule(_localctx, 12, RULE_outputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__11);
			setState(177);
			((OutputInstrContext)_localctx).expression = expression(0);
			setState(178);
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
		public ExpressionContext expression;
		public BlockContext block;
		public AssignationContext init;
		public AssignationContext iteration;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
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
		enterRule(_localctx, 14, RULE_loopInstr);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__12);
				setState(182);
				((LoopInstrContext)_localctx).expression = expression(0);
				setState(183);
				match(T__3);
				setState(184);
				((LoopInstrContext)_localctx).block = block();
				 ((LoopInstrContext)_localctx).code =  evalWhileLoop(((LoopInstrContext)_localctx).expression.code, ((LoopInstrContext)_localctx).expression.type, ((LoopInstrContext)_localctx).block.code); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__13);
				setState(188);
				((LoopInstrContext)_localctx).init = assignation();
				setState(189);
				match(T__14);
				setState(190);
				((LoopInstrContext)_localctx).expression = expression(0);
				setState(191);
				match(T__14);
				setState(192);
				((LoopInstrContext)_localctx).iteration = assignation();
				setState(193);
				match(T__3);
				setState(194);
				((LoopInstrContext)_localctx).block = block();
				 ((LoopInstrContext)_localctx).code =  evalForLoop(((LoopInstrContext)_localctx).init.code, ((LoopInstrContext)_localctx).expression.code, ((LoopInstrContext)_localctx).expression.type, ((LoopInstrContext)_localctx).iteration.code, ((LoopInstrContext)_localctx).block.code); 
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(T__15);
				setState(198);
				((LoopInstrContext)_localctx).block = block();
				setState(199);
				match(T__16);
				setState(200);
				((LoopInstrContext)_localctx).expression = expression(0);
				setState(201);
				match(T__3);
				 ((LoopInstrContext)_localctx).code =  evalRepeatLoop(((LoopInstrContext)_localctx).expression.code, ((LoopInstrContext)_localctx).expression.type, ((LoopInstrContext)_localctx).block.code); 
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
		enterRule(_localctx, 16, RULE_conditionAvecLogique);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((ConditionAvecLogiqueContext)_localctx).cond1 = condition();
			setState(207);
			((ConditionAvecLogiqueContext)_localctx).exprlog = match(EXPRLOG);
			setState(208);
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
		enterRule(_localctx, 18, RULE_condition);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(T__17);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n"; 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(T__18);
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
				setState(215);
				((ConditionContext)_localctx).exp1 = expression(0);
				setState(216);
				((ConditionContext)_localctx).cond = match(COND);
				setState(217);
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
		public ExpressionContext expr;
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
		enterRule(_localctx, 20, RULE_declaration);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				((DeclarationContext)_localctx).type = match(TYPE);
				setState(223);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);
				 ((DeclarationContext)_localctx).code =  evalDeclaration((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null), (((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				((DeclarationContext)_localctx).type = match(TYPE);
				setState(226);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);
				setState(227);
				match(T__19);
				setState(228);
				((DeclarationContext)_localctx).expr = expression(0);
				 ((DeclarationContext)_localctx).code =  evalDeclarationExpr((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null), (((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), ((DeclarationContext)_localctx).expr.code, ((DeclarationContext)_localctx).expr.type); 
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
		public ExpressionContext expr;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			((AssignationContext)_localctx).id = match(IDENTIFIANT);
			setState(234);
			match(T__19);
			setState(235);
			((AssignationContext)_localctx).expr = expression(0);
			 ((AssignationContext)_localctx).code =  evalAssign((((AssignationContext)_localctx).id!=null?((AssignationContext)_localctx).id.getText():null), ((AssignationContext)_localctx).expr.code, ((AssignationContext)_localctx).expr.type); 
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token type;
		public Token id;
		public BlockContext block;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fonction);
		 tablesSymboles.newTableLocale(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			((FonctionContext)_localctx).type = match(TYPE);
			 tablesSymboles.putVar("return", (((FonctionContext)_localctx).type!=null?((FonctionContext)_localctx).type.getText():null)); 
			setState(240);
			((FonctionContext)_localctx).id = match(IDENTIFIANT);
			setState(241);
			match(T__2);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(242);
				params();
				}
			}

			setState(245);
			match(T__3);
			 tablesSymboles.newFunction((((FonctionContext)_localctx).id!=null?((FonctionContext)_localctx).id.getText():null), (((FonctionContext)_localctx).type!=null?((FonctionContext)_localctx).type.getText():null)); 
			setState(247);
			((FonctionContext)_localctx).block = block();

			        ((FonctionContext)_localctx).code =  "LABEL " + (((FonctionContext)_localctx).id!=null?((FonctionContext)_localctx).id.getText():null);
			        _localctx.code += ((FonctionContext)_localctx).block.code;
			      
			}
			_ctx.stop = _input.LT(-1);
			 tablesSymboles.dropTableLocale(); 
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

	public static class ParamsContext extends ParserRuleContext {
		public Token type;
		public Token id;
		public Token type2;
		public Token id2;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			((ParamsContext)_localctx).type = match(TYPE);
			setState(251);
			((ParamsContext)_localctx).id = match(IDENTIFIANT);
			 tablesSymboles.putVar((((ParamsContext)_localctx).id!=null?((ParamsContext)_localctx).id.getText():null), (((ParamsContext)_localctx).type!=null?((ParamsContext)_localctx).type.getText():null)); 
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(253);
				match(T__20);
				setState(254);
				((ParamsContext)_localctx).type2 = match(TYPE);
				setState(255);
				((ParamsContext)_localctx).id2 = match(IDENTIFIANT);
				 tablesSymboles.putVar((((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null), (((ParamsContext)_localctx).type2!=null?((ParamsContext)_localctx).type2.getText():null)); 
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext expr;
		public ExpressionContext expr2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				setState(262);
				((ArgsContext)_localctx).expr = expression(0);

				          _localctx.code += ((ArgsContext)_localctx).expr.code;
				          _localctx.size++;
				          if(((ArgsContext)_localctx).expr.type.equals("float")){
				            _localctx.size++;
				          }
				        
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(264);
					match(T__20);
					setState(265);
					((ArgsContext)_localctx).expr2 = expression(0);

					            _localctx.code += ((ArgsContext)_localctx).expr2.code; 
					            _localctx.size++;
					            if(((ArgsContext)_localctx).expr.type.equals("float")){
					              _localctx.size++;;
					            }
					          
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

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

	public static class ReturnInstrContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnInstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterReturnInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitReturnInstr(this);
		}
	}

	public final ReturnInstrContext returnInstr() throws RecognitionException {
		ReturnInstrContext _localctx = new ReturnInstrContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__21);
			setState(276);
			((ReturnInstrContext)_localctx).expr = expression(0);
			 ((ReturnInstrContext)_localctx).code =  evalReturn(((ReturnInstrContext)_localctx).expr.code, ((ReturnInstrContext)_localctx).expr.type); 
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
		enterRule(_localctx, 32, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(279);
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
				setState(282); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u011f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\7\2/\n\2\f\2\16\2\62\13\2"+
		"\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\7\2=\n\2\f\2\16\2@\13\2\3\2"+
		"\3\2\3\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3Q\n\3"+
		"\f\3\16\3T\13\3\3\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4~\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008d\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5\u0099\n\5\f\5\16\5\u009c\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ac\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00cf\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00df\n\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ea\n\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u00f6\n\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0104\n\17\f\17\16\17\u0107\13\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u010f\n\20\f\20\16\20\u0112\13\20"+
		"\5\20\u0114\n\20\3\21\3\21\3\21\3\21\3\22\6\22\u011b\n\22\r\22\16\22\u011c"+
		"\3\22\2\3\b\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\3\2\t\n\3"+
		"\2\7\b\4\2\21\21!!\2\u012c\2)\3\2\2\2\4L\3\2\2\2\6}\3\2\2\2\b\u008c\3"+
		"\2\2\2\n\u00ab\3\2\2\2\f\u00ad\3\2\2\2\16\u00b2\3\2\2\2\20\u00ce\3\2\2"+
		"\2\22\u00d0\3\2\2\2\24\u00de\3\2\2\2\26\u00e9\3\2\2\2\30\u00eb\3\2\2\2"+
		"\32\u00f0\3\2\2\2\34\u00fc\3\2\2\2\36\u0113\3\2\2\2 \u0115\3\2\2\2\"\u011a"+
		"\3\2\2\2$%\5\26\f\2%&\b\2\1\2&(\3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2"+
		"\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,\60\b\2\1\2-/\7!\2\2.-\3\2\2\2/\62\3"+
		"\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\618\3\2\2\2\62\60\3\2\2\2\63\64\5\32"+
		"\16\2\64\65\b\2\1\2\65\67\3\2\2\2\66\63\3\2\2\2\67:\3\2\2\28\66\3\2\2"+
		"\289\3\2\2\29>\3\2\2\2:8\3\2\2\2;=\7!\2\2<;\3\2\2\2=@\3\2\2\2><\3\2\2"+
		"\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AG\b\2\1\2BC\5\6\4\2CD\b\2\1\2DF\3\2\2"+
		"\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\b\2\1"+
		"\2K\3\3\2\2\2LR\7\3\2\2MN\5\6\4\2NO\b\3\1\2OQ\3\2\2\2PM\3\2\2\2QT\3\2"+
		"\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UY\7\4\2\2VX\7!\2\2WV\3\2"+
		"\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\5\3\2\2\2[Y\3\2\2\2\\]\5\b\5\2]^\5"+
		"\"\22\2^_\b\4\1\2_~\3\2\2\2`a\5\"\22\2ab\b\4\1\2b~\3\2\2\2cd\5\26\f\2"+
		"de\5\"\22\2ef\b\4\1\2f~\3\2\2\2gh\5\30\r\2hi\5\"\22\2ij\b\4\1\2j~\3\2"+
		"\2\2kl\5\16\b\2lm\5\"\22\2mn\b\4\1\2n~\3\2\2\2op\5\f\7\2pq\5\"\22\2qr"+
		"\b\4\1\2r~\3\2\2\2st\5\20\t\2tu\b\4\1\2u~\3\2\2\2vw\5\n\6\2wx\b\4\1\2"+
		"x~\3\2\2\2yz\5 \21\2z{\5\"\22\2{|\b\4\1\2|~\3\2\2\2}\\\3\2\2\2}`\3\2\2"+
		"\2}c\3\2\2\2}g\3\2\2\2}k\3\2\2\2}o\3\2\2\2}s\3\2\2\2}v\3\2\2\2}y\3\2\2"+
		"\2~\7\3\2\2\2\177\u0080\b\5\1\2\u0080\u0081\7\5\2\2\u0081\u0082\5\b\5"+
		"\2\u0082\u0083\7\6\2\2\u0083\u0084\b\5\1\2\u0084\u008d\3\2\2\2\u0085\u0086"+
		"\t\2\2\2\u0086\u0087\7\35\2\2\u0087\u008d\b\5\1\2\u0088\u0089\7\35\2\2"+
		"\u0089\u008d\b\5\1\2\u008a\u008b\7 \2\2\u008b\u008d\b\5\1\2\u008c\177"+
		"\3\2\2\2\u008c\u0085\3\2\2\2\u008c\u0088\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u009a\3\2\2\2\u008e\u008f\f\7\2\2\u008f\u0090\t\3\2\2\u0090\u0091\5\b"+
		"\5\b\u0091\u0092\b\5\1\2\u0092\u0099\3\2\2\2\u0093\u0094\f\6\2\2\u0094"+
		"\u0095\t\2\2\2\u0095\u0096\5\b\5\7\u0096\u0097\b\5\1\2\u0097\u0099\3\2"+
		"\2\2\u0098\u008e\3\2\2\2\u0098\u0093\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\t\3\2\2\2\u009c\u009a\3\2\2\2"+
		"\u009d\u009e\7\13\2\2\u009e\u009f\5\b\5\2\u009f\u00a0\7\6\2\2\u00a0\u00a1"+
		"\5\4\3\2\u00a1\u00a2\b\6\1\2\u00a2\u00ac\3\2\2\2\u00a3\u00a4\7\13\2\2"+
		"\u00a4\u00a5\5\b\5\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\5\4\3\2\u00a7\u00a8"+
		"\7\f\2\2\u00a8\u00a9\5\4\3\2\u00a9\u00aa\b\6\1\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u009d\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ac\13\3\2\2\2\u00ad\u00ae\7\r\2"+
		"\2\u00ae\u00af\7 \2\2\u00af\u00b0\7\6\2\2\u00b0\u00b1\b\7\1\2\u00b1\r"+
		"\3\2\2\2\u00b2\u00b3\7\16\2\2\u00b3\u00b4\5\b\5\2\u00b4\u00b5\7\6\2\2"+
		"\u00b5\u00b6\b\b\1\2\u00b6\17\3\2\2\2\u00b7\u00b8\7\17\2\2\u00b8\u00b9"+
		"\5\b\5\2\u00b9\u00ba\7\6\2\2\u00ba\u00bb\5\4\3\2\u00bb\u00bc\b\t\1\2\u00bc"+
		"\u00cf\3\2\2\2\u00bd\u00be\7\20\2\2\u00be\u00bf\5\30\r\2\u00bf\u00c0\7"+
		"\21\2\2\u00c0\u00c1\5\b\5\2\u00c1\u00c2\7\21\2\2\u00c2\u00c3\5\30\r\2"+
		"\u00c3\u00c4\7\6\2\2\u00c4\u00c5\5\4\3\2\u00c5\u00c6\b\t\1\2\u00c6\u00cf"+
		"\3\2\2\2\u00c7\u00c8\7\22\2\2\u00c8\u00c9\5\4\3\2\u00c9\u00ca\7\23\2\2"+
		"\u00ca\u00cb\5\b\5\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\b\t\1\2\u00cd\u00cf"+
		"\3\2\2\2\u00ce\u00b7\3\2\2\2\u00ce\u00bd\3\2\2\2\u00ce\u00c7\3\2\2\2\u00cf"+
		"\21\3\2\2\2\u00d0\u00d1\5\24\13\2\u00d1\u00d2\7\32\2\2\u00d2\u00d3\5\24"+
		"\13\2\u00d3\u00d4\b\n\1\2\u00d4\23\3\2\2\2\u00d5\u00d6\7\24\2\2\u00d6"+
		"\u00df\b\13\1\2\u00d7\u00d8\7\25\2\2\u00d8\u00df\b\13\1\2\u00d9\u00da"+
		"\5\b\5\2\u00da\u00db\7\33\2\2\u00db\u00dc\5\b\5\2\u00dc\u00dd\b\13\1\2"+
		"\u00dd\u00df\3\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d7\3\2\2\2\u00de\u00d9"+
		"\3\2\2\2\u00df\25\3\2\2\2\u00e0\u00e1\7\34\2\2\u00e1\u00e2\7 \2\2\u00e2"+
		"\u00ea\b\f\1\2\u00e3\u00e4\7\34\2\2\u00e4\u00e5\7 \2\2\u00e5\u00e6\7\26"+
		"\2\2\u00e6\u00e7\5\b\5\2\u00e7\u00e8\b\f\1\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e0\3\2\2\2\u00e9\u00e3\3\2\2\2\u00ea\27\3\2\2\2\u00eb\u00ec\7 \2\2"+
		"\u00ec\u00ed\7\26\2\2\u00ed\u00ee\5\b\5\2\u00ee\u00ef\b\r\1\2\u00ef\31"+
		"\3\2\2\2\u00f0\u00f1\7\34\2\2\u00f1\u00f2\b\16\1\2\u00f2\u00f3\7 \2\2"+
		"\u00f3\u00f5\7\5\2\2\u00f4\u00f6\5\34\17\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\7\6\2\2\u00f8\u00f9\b\16\1\2"+
		"\u00f9\u00fa\5\4\3\2\u00fa\u00fb\b\16\1\2\u00fb\33\3\2\2\2\u00fc\u00fd"+
		"\7\34\2\2\u00fd\u00fe\7 \2\2\u00fe\u0105\b\17\1\2\u00ff\u0100\7\27\2\2"+
		"\u0100\u0101\7\34\2\2\u0101\u0102\7 \2\2\u0102\u0104\b\17\1\2\u0103\u00ff"+
		"\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\35\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\5\b\5\2\u0109\u0110\b\20\1"+
		"\2\u010a\u010b\7\27\2\2\u010b\u010c\5\b\5\2\u010c\u010d\b\20\1\2\u010d"+
		"\u010f\3\2\2\2\u010e\u010a\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0113"+
		"\u0108\3\2\2\2\u0113\u0114\3\2\2\2\u0114\37\3\2\2\2\u0115\u0116\7\30\2"+
		"\2\u0116\u0117\5\b\5\2\u0117\u0118\b\21\1\2\u0118!\3\2\2\2\u0119\u011b"+
		"\t\4\2\2\u011a\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d#\3\2\2\2\26)\608>GRY}\u008c\u0098\u009a\u00ab\u00ce"+
		"\u00de\u00e9\u00f5\u0105\u0110\u0113\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}