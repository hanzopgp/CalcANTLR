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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, KEYWORDS=16, 
		ADD=17, SUB=18, MUL=19, DIV=20, EQUAL=21, COMMA=22, SEMICOLON=23, AND=24, 
		OR=25, NO=26, COND=27, TYPE=28, ENTIER=29, FLOAT=30, BOOLEAN=31, IDENTIFIANT=32, 
		NEWLINE=33, WS=34, MULTILINECOMMENT=35, SINGLELINECOMMENT=36, HASHTAGCOMMENT=37, 
		UNMATCH=38;
	public static final int
		RULE_calcul = 0, RULE_instruction = 1, RULE_block = 2, RULE_declaration = 3, 
		RULE_assignation = 4, RULE_expression = 5, RULE_factor = 6, RULE_cast = 7, 
		RULE_preparenthesis = 8, RULE_atom = 9, RULE_ifElseInstr = 10, RULE_loopInstr = 11, 
		RULE_inputInstr = 12, RULE_outputInstr = 13, RULE_fonction = 14, RULE_params = 15, 
		RULE_args = 16, RULE_returnInstr = 17, RULE_finInstruction = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"calcul", "instruction", "block", "declaration", "assignation", "expression", 
			"factor", "cast", "preparenthesis", "atom", "ifElseInstr", "loopInstr", 
			"inputInstr", "outputInstr", "fonction", "params", "args", "returnInstr", 
			"finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'true'", "'false'", "'('", "')'", "'if'", "'else'", 
			"'while'", "'for'", "'repeat'", "'until'", "'read('", "'write('", "'return'", 
			null, "'+'", "'-'", "'*'", "'/'", "'='", "','", "';'", "'&&'", "'||'", 
			"'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "KEYWORDS", "ADD", "SUB", "MUL", "DIV", "EQUAL", 
			"COMMA", "SEMICOLON", "AND", "OR", "NO", "COND", "TYPE", "ENTIER", "FLOAT", 
			"BOOLEAN", "IDENTIFIANT", "NEWLINE", "WS", "MULTILINECOMMENT", "SINGLELINECOMMENT", 
			"HASHTAGCOMMENT", "UNMATCH"
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


	    private TablesSymboles tablesSymboles = new TablesSymboles(); //On utilise la table de symboles pour garder les
	    private int _cur_label = 1;                                   //liens id/type et les valeurs dans les adresses
	    private String getNewLabel() { return "B" +(_cur_label++); }  //Generateur de nom d'etiquettes pour les boucles 
	    private int nbErrors = 0;                                     //Compteur d'erreurs a la compilation 
	    //private ArrayList<String> errors = new ArrayList();           //Liste des erreurs                              

	    /****************FONCTIONS DEBUG****************/

	    /*private void printErrors(){
	      for(String s : errors){
	        System.out.println(s);
	      }
	    }*/

	    private void testEmptyStringErrors(String ... strings){
	      for(String s : strings){
	        if(s.isEmpty()){
	          nbErrors++;
	          System.err.println("-->ERROR empty string");
	          break;
	        }
	      }
	    }

	    private void testAddressNotFound(AdresseType at){
	      nbErrors++;
	      //boolean noAddressTest = at.adresse == ???;
	      boolean noRightTypeTest = !(at.type.equals("int") || at.type.equals("float") || at.type.equals("bool"));
	      if(noRightTypeTest){
	        System.err.println("-->ERROR address, Address can't be found or is empty : [adress:" + at.adresse + ",type:" + at.type + "]");
	      }
	    }

	    private void triggerOperatorError(String op){
	      nbErrors++;
	      System.err.println("-->ERROR operator, found : " + op + ", expected : '+','-','*','/'");
	    }

	    private void triggerConditionError(String cond){
	      nbErrors++;
	      System.err.println("-->ERROR condition, found : " + cond + ", expected : '==','<=','>=','<','>','!='");
	    }

	    private void triggerCastError(String targetType){
	      nbErrors++;
	      System.err.println("-->ERROR cast, found : " + targetType + ", expected : 'int','float','bool'");
	    }

	    private void triggerAutoCastError(String type, String type2){
	      nbErrors++;
	      System.err.println("-->ERROR auto-cast, found : [" + type + "," + type2 + "], expected : 'int','float','bool'");
	    }

	    /****************FONCTIONS CAST****************/

	    //Renvoie le code pour un cast simple d'un type a un autre
	    private String tradOneElement(String currentType, String targetType){ 
	      String res = "";
	      switch(targetType){
	        case "int":                           
	          if(currentType.equals("float")){    //Passage de float ===> int
	            res += "FTOI\n";   
	          }
	          break;  
	        case "float":                         
	          res += "ITOF\n";                    //Passage de int ===> float
	          break;                             
	        case "bool":                          
	          String trueLabel = getNewLabel();
	          String falseLabel = getNewLabel();                           
	          String pushType;
	          String equalType;
	          if(currentType.equals("float")){    //Passage de float ===> bool
	            pushType = "PUSHF 0.0\n";
	            equalType = "FEQUAL\n";
	          }else{                              //Passage de int ===> bool
	            pushType = "PUSHI 0\n";
	            equalType = "EQUAL\n";
	          }   
	          res += pushType + equalType + "JUMPF " + trueLabel + "\nPUSHI 0\n" 
	              + "JUMP " + falseLabel + "\nLABEL " + trueLabel + "\nPUSHI 1\n" 
	              + "LABEL " + falseLabel + "\n";
	          break;
	        default:
	          triggerCastError(targetType);
	          break;
	      }
	      return res;
	    }

	    //Met au meme type 2 expressions en renvoyant le type et en modifier l'object StringBuilder
	    private String tradTwoElements(String type, String expr, String type2, String expr2, StringBuilder exprRes){
	      String typeRes = "";
	      if(type.equals(type2)){               //Operation sur deux expressions de meme type
	        typeRes = type;
	        exprRes.append(expr + expr2);
	      }else if(type.equals("float")){       //Passage de float + int ===> float
	        typeRes = "float";
	        exprRes.append(expr + expr2 + "ITOF\n");
	      }else if(type2.equals("float")){      //Passage de int + float ===> float
	        typeRes = "float";
	        exprRes.append(expr + "ITOF\n" + expr2);
	      }else{
	        triggerAutoCastError(type, type2);
	      }
	      return typeRes;
	    }

	    /****************FONCTIONS REFACTORING****************/

	    //Renvoie STOREL ou STOREG + l'adresse suivant le type de l'id
	    private String storeGOrL(String id){
	      AdresseType at = tablesSymboles.getAdresseType(id); 
	      String storer = (at.adresse < 0) ? "STOREL " : "STOREG "; //Adresse negatives : float
	      String adress = (at.getSize(at.type) == 1)                //Adresse positives : int ou bool
	                    ? tablesSymboles.getAdresseType(id).adresse + "\n"
	                    : (tablesSymboles.getAdresseType(id).adresse + 1) + "\n"; 
	      return storer + adress;
	    }

	    //Renvoie PUSHI 0 ou PUSHF 0.0 suivant le type en entree
	    private String pushIOrF(String type){
	      return ((type.equals("int") || type.equals("bool")) ? "PUSHI 0\n" : "PUSHF 0.0\n"); 
	    }

	    /****************FONCTIONS OPERATORS****************/

	    //Renvoie le code mvap pour chacune des operations possibles en prenant en compte le type
	    private String evalOp(String type, String op){
	      String res = "";
	      if(type.equals("float")){ //Si type float alors 
	        res += "F";             //FADD FSUB ... pour la stack machine
	      }
	      switch(op){
	        case "+" :
	          res += "ADD\n";
	          break;
	        case "-" :
	          res += "SUB\n";
	          break;
	        case "*" :
	          res += "MUL\n";
	          break;
	        case "/" :
	          res += "DIV\n";
	          break;
	        default :
	          triggerOperatorError(op);
	          break;
	      }   
	      return res;                                   
	    }

	    //Renvoie le code mvap pour chacune des conditions possibles
	    private String evalCond(String type, String exp1, String cond, String exp2){  
	      String res = exp1 + exp2;  
	      if(type.equals("float")){ //Si type float alors
	        res += "F";             //FEQUAL FINFEQ ... pour la stack machine
	      }                                   
	      switch(cond){
	        case "==" :
	          res += "EQUAL\n";
	          break;
	        case "<=" :
	          res += "INFEQ\n";
	          break;
	        case ">=" :
	          res += "SUPEQ\n";
	          break;
	        case "<" :
	          res += "INF\n";
	          break;
	        case ">" :
	          res += "SUP\n";
	          break;
	        case "!=" :
	          res += "NEQ\n";
	          break;
	        default :
	          triggerConditionError(cond);
	          break;
	      }
	      return res;
	    }

	    //Renvoie le code mvap lors d'une negation unitaire
	    private String evalNegPP(String type, String expr){
	      String pusher = (type.equals("int") ? "PUSHI 0\n" : "PUSHF 0.0\n");
	      String content = expr;
	      String operator = evalOp(type, "-");
	      return pusher + content + operator;
	    }

	    /****************FONCTIONS DECLARATION ASSIGNATION****************/

	    //Renvoie le code pour une declaration simple suivant le type de l'id
	    private String evalDeclaration(String type, String id){  
	      tablesSymboles.putVar(id, type);
	      testEmptyStringErrors(type, id);
	      return pushIOrF(type); 
	    }

	    //Renvoie le code pour une declaration + assignation suivant le type de l'id
	    private String evalDeclarationExpr(String type, String id, String exprType, String expr){
	      tablesSymboles.putVar(id, type);  
	      AdresseType at = tablesSymboles.getAdresseType(id); 
	      testAddressNotFound(at);
	      testEmptyStringErrors(type, id, exprType, expr);
	      return pushIOrF(type) + expr + tradOneElement(exprType, at.type) + storeGOrL(id);
	    }

	    //Renvoie le code pour une assignation suivant le type de l'id
	    private String evalAssign(String id, String exprType, String expr){ 
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      testAddressNotFound(at);
	      testEmptyStringErrors(id, exprType, expr);
	      return expr + tradOneElement(exprType, at.type) + storeGOrL(id);
	    }

	    /*******************FONCTIONS BOUCLES*******************/

	    //Fonction renvoyant le code mvap pour creer une boucle while
	    private String evalWhileLoop(String exprType, String expr, String instructions){ 
	      String startLabelW = getNewLabel();                                     
	      String endLabelW = getNewLabel();
	      expr += tradOneElement(exprType, "bool");
	      testEmptyStringErrors(exprType, expr, instructions);
	      return "LABEL " + startLabelW + "\n" + expr + "JUMPF " + endLabelW + "\n"
	             + instructions + "JUMP " + startLabelW + "\n" + "LABEL " + endLabelW + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle for
	    private String evalForLoop(String init, String exprType, String expr, String iteration, String instructions){  
	      String startLabelF = getNewLabel();                                                                    
	      String endLabelF = getNewLabel();
	      expr += tradOneElement(exprType, "bool");
	      testEmptyStringErrors(init, exprType, expr, iteration, instructions);
	      return init + "LABEL " + startLabelF + "\n" + expr + "JUMPF " + endLabelF + "\n"
	             + instructions + iteration + "JUMP " + startLabelF + "\n" + "LABEL " + endLabelF + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle repeat until
	    private String evalRepeatLoop(String exprType, String expr, String instructions){                                                  
	      String startLabelR = getNewLabel();
	      expr += tradOneElement(exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, instructions);
	      return "LABEL " + startLabelR + "\n" + instructions 
	             + expr + "\n" + "JUMPF " + startLabelR + "\n";
	    }

	    /*******************FONCTIONS INPUT OUTPUT*******************/

	    //Fonction renvoyant le code mvap pour utiliser read suivant le type de l'id
	    private String evalInput(String id){
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      String str1 = at.type.equals("int") ? "READ\n" : "READF\n";
	      String str2 = storeGOrL(id);
	      testAddressNotFound(at);
	      testEmptyStringErrors(id, str1, str2);
	      return str1 + str2;
	    }

	    //Fonction renvoyant le code mvap pour utiliser write
	    private String evalOutput(String type){
	      testEmptyStringErrors(type);
	      return (type.equals("int")) || (type.equals("bool")) 
	                   ? "WRITE\nPOP\n"        //Un seul POP normal pour l'output
	                   : "WRITEF\nPOP\nPOP\n"; //Double POP si c'est un float  
	    }                                      //car les float prennent plus de place dans la stack machine

	    /*******************FONCTIONS LOGIQUE*******************/

	    //Fonction renvoyant le code apres avoir tester
	    private String evalAnd(String expr1Type, String expr1, String expr2Type, String expr2){                  
	      String falseLabel1And = getNewLabel();
	      String trueLabel2And = getNewLabel();
	      expr1 += tradOneElement(expr1Type, "bool");
	      expr2 += tradOneElement(expr2Type, "bool"); 
	      testEmptyStringErrors(expr1Type, expr1, expr2Type, expr2);
	      return expr1 + "JUMPF " + falseLabel1And + "\n" + expr2 + "JUMP " + trueLabel2And + "\n"                    
	              + "LABEL " + falseLabel1And + "\n" + "PUSHI 0\n" + "LABEL " + trueLabel2And + "\n";
	    }

	    //Fonction renvoyant le code apres avoir tester
	    private String evalOr(String expr1Type, String expr1, String expr2Type, String expr2){                    
	      String falseLabel1Or = getNewLabel();
	      String trueLabel1Or = getNewLabel();
	      expr1 += tradOneElement(expr1Type, "bool");
	      expr2 += tradOneElement(expr2Type, "bool"); 
	      testEmptyStringErrors(expr1Type, expr1, expr2Type, expr2);
	      return expr1 + "JUMPF " + falseLabel1Or + "\n" + "PUSHI 1\n" + "JUMP " + trueLabel1Or + "\n"
	             + "LABEL " + falseLabel1Or + expr2 + "LABEL " + trueLabel1Or + "\n";
	    }

	    /*******************FONCTIONS BRANCHEMENTS*******************/

	    //Fonction renvoyant le code mvap lors d'un branchement if else
	    private String evalIfElse(String exprType, String expr, String ifInstructions, String elseInstructions){                                                                                 
	      String elseStartLabel = getNewLabel();                                                                   
	      String ifEndLabel = getNewLabel(); 
	      expr += tradOneElement(exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, ifInstructions, elseInstructions);
	      return expr + "\n" + "JUMPF " + elseStartLabel +"\n" 
	             + ifInstructions + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
	             + elseStartLabel + "\n" + elseInstructions + "LABEL " + ifEndLabel + "\n";
	    }

	    //Fonction renvoyant le code mvap pour un branchement compose d'un seul if
	    private String evalIf(String exprType, String expr, String ifInstructions){      
	      String ifEndLabel = getNewLabel();                                           
	      expr += tradOneElement(exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, ifInstructions);                                                     
	      return expr + "\n" + "JUMPF " + ifEndLabel 
	             + "\n" + ifInstructions + "LABEL " + ifEndLabel + "\n";
	    }

	    /*******************FONCTION RETURN*******************/

	    //Fonction renvoyant le code mvap pour les return
	    private String evalReturn(String exprType, String expr){
	      AdresseType at = tablesSymboles.getAdresseType("return");
	      testAddressNotFound(at);
	      testEmptyStringErrors(exprType, expr);
	      return expr + tradOneElement(exprType, at.type) + storeGOrL(expr) + "RETURN\n";
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
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					((CalculContext)_localctx).declaration = declaration();
					 _localctx.code += ((CalculContext)_localctx).declaration.code; 
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 _localctx.code += "JUMP " + "Main\n"; 
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					match(NEWLINE);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(53);
					((CalculContext)_localctx).fonction = fonction();
					 _localctx.code += ((CalculContext)_localctx).fonction.code; 
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					match(NEWLINE);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL " + "Main\n"; 
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ADD) | (1L << SUB) | (1L << SEMICOLON) | (1L << NO) | (1L << TYPE) | (1L << ENTIER) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << IDENTIFIANT) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(68);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT \n"; 
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
		public IfElseInstrContext ifElseInstr;
		public BlockContext block;
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 2, RULE_instruction);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((InstructionContext)_localctx).expression = expression(0);
				setState(79);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((InstructionContext)_localctx).declaration = declaration();
				setState(83);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).declaration.code; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				((InstructionContext)_localctx).assignation = assignation();
				setState(87);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				((InstructionContext)_localctx).outputInstr = outputInstr();
				setState(91);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).outputInstr.code; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				((InstructionContext)_localctx).inputInstr = inputInstr();
				setState(95);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).inputInstr.code; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				((InstructionContext)_localctx).loopInstr = loopInstr();
				setState(99);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).loopInstr.code; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(102);
				((InstructionContext)_localctx).ifElseInstr = ifElseInstr();
				setState(103);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).ifElseInstr.code; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(106);
				((InstructionContext)_localctx).block = block();
				setState(107);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).block.code; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(110);
				((InstructionContext)_localctx).returnInstr = returnInstr();
				setState(111);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).returnInstr.code; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(114);
				finInstruction();
				 ((InstructionContext)_localctx).code =  ""; 
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
		enterRule(_localctx, 4, RULE_block);
		 ((BlockContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__0);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ADD) | (1L << SUB) | (1L << SEMICOLON) | (1L << NO) | (1L << TYPE) | (1L << ENTIER) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << IDENTIFIANT) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(120);
				((BlockContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlockContext)_localctx).instruction.code; 
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					match(NEWLINE);
					}
					} 
				}
				setState(134);
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
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public String code;
		public Token ty;
		public Token id;
		public ExpressionContext expr;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode EQUAL() { return getToken(CalculetteParser.EQUAL, 0); }
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
		enterRule(_localctx, 6, RULE_declaration);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((DeclarationContext)_localctx).ty = match(TYPE);
				setState(136);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);
				 ((DeclarationContext)_localctx).code =  evalDeclaration((((DeclarationContext)_localctx).ty!=null?((DeclarationContext)_localctx).ty.getText():null), (((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				((DeclarationContext)_localctx).ty = match(TYPE);
				setState(139);
				((DeclarationContext)_localctx).id = match(IDENTIFIANT);
				setState(140);
				match(EQUAL);
				setState(141);
				((DeclarationContext)_localctx).expr = expression(0);
				 ((DeclarationContext)_localctx).code =  evalDeclarationExpr((((DeclarationContext)_localctx).ty!=null?((DeclarationContext)_localctx).ty.getText():null), (((DeclarationContext)_localctx).id!=null?((DeclarationContext)_localctx).id.getText():null), ((DeclarationContext)_localctx).expr.type, ((DeclarationContext)_localctx).expr.code); 
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
		public TerminalNode EQUAL() { return getToken(CalculetteParser.EQUAL, 0); }
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
		enterRule(_localctx, 8, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((AssignationContext)_localctx).id = match(IDENTIFIANT);
			setState(147);
			match(EQUAL);
			setState(148);
			((AssignationContext)_localctx).expr = expression(0);
			 ((AssignationContext)_localctx).code =  evalAssign((((AssignationContext)_localctx).id!=null?((AssignationContext)_localctx).id.getText():null), ((AssignationContext)_localctx).expr.type, ((AssignationContext)_localctx).expr.code); 
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
		public ExpressionContext expr;
		public ExpressionContext expr1;
		public FactorContext factor;
		public CastContext cast;
		public Token cond;
		public ExpressionContext expr2;
		public Token op;
		public FactorContext fac;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COND() { return getToken(CalculetteParser.COND, 0); }
		public TerminalNode AND() { return getToken(CalculetteParser.AND, 0); }
		public TerminalNode OR() { return getToken(CalculetteParser.OR, 0); }
		public TerminalNode ADD() { return getToken(CalculetteParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(CalculetteParser.SUB, 0); }
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(152);
				((ExpressionContext)_localctx).factor = factor(0);
				 ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).factor.type; ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).factor.code; 
				}
				break;
			case 2:
				{
				setState(155);
				((ExpressionContext)_localctx).cast = cast();
				 ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).cast.type; ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).cast.code; 
				}
				break;
			case 3:
				{
				setState(158);
				match(T__2);
				 ((ExpressionContext)_localctx).type =  "bool"; ((ExpressionContext)_localctx).code =  "PUSHI 1\n"; 
				}
				break;
			case 4:
				{
				setState(160);
				match(T__3);
				 ((ExpressionContext)_localctx).type =  "bool"; ((ExpressionContext)_localctx).code =  "PUSHI 0\n"; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(165);
						((ExpressionContext)_localctx).cond = match(COND);
						setState(166);
						((ExpressionContext)_localctx).expr2 = expression(4);
						 ((ExpressionContext)_localctx).type =  "bool"; ((ExpressionContext)_localctx).code =  evalCond(_localctx.type, ((ExpressionContext)_localctx).expr1.code, (((ExpressionContext)_localctx).cond!=null?((ExpressionContext)_localctx).cond.getText():null), ((ExpressionContext)_localctx).expr2.code); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(170);
						match(AND);
						setState(171);
						((ExpressionContext)_localctx).expr2 = expression(3);
						 ((ExpressionContext)_localctx).type =  "bool"; ((ExpressionContext)_localctx).code =  evalAnd(((ExpressionContext)_localctx).expr1.type, ((ExpressionContext)_localctx).expr1.code, ((ExpressionContext)_localctx).expr2.type, ((ExpressionContext)_localctx).expr2.code); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr1 = _prevctx;
						_localctx.expr1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(175);
						match(OR);
						setState(176);
						((ExpressionContext)_localctx).expr2 = expression(2);
						 ((ExpressionContext)_localctx).type =  "bool"; ((ExpressionContext)_localctx).code =  evalOr(((ExpressionContext)_localctx).expr1.type, ((ExpressionContext)_localctx).expr1.code, ((ExpressionContext)_localctx).expr2.type, ((ExpressionContext)_localctx).expr2.code); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.expr = _prevctx;
						_localctx.expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(179);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(180);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						((ExpressionContext)_localctx).fac = ((ExpressionContext)_localctx).factor = factor(0);
						 
						                  StringBuilder codeRes = new StringBuilder(); 
						                  ((ExpressionContext)_localctx).type =  tradTwoElements(((ExpressionContext)_localctx).expr.type, ((ExpressionContext)_localctx).expr.code, ((ExpressionContext)_localctx).fac.type, ((ExpressionContext)_localctx).fac.code, codeRes);
						                  ((ExpressionContext)_localctx).code =  codeRes.toString() + evalOp(_localctx.type, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public String type;
		public String code;
		public FactorContext fac;
		public PreparenthesisContext pp;
		public Token op;
		public PreparenthesisContext preparenthesis() {
			return getRuleContext(PreparenthesisContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MUL() { return getToken(CalculetteParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CalculetteParser.DIV, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		return factor(0);
	}

	private FactorContext factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FactorContext _localctx = new FactorContext(_ctx, _parentState);
		FactorContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_factor, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(190);
			((FactorContext)_localctx).pp = preparenthesis();
			 ((FactorContext)_localctx).type =  ((FactorContext)_localctx).pp.type; ((FactorContext)_localctx).code =  ((FactorContext)_localctx).pp.code; 
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FactorContext(_parentctx, _parentState);
					_localctx.fac = _prevctx;
					_localctx.fac = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_factor);
					setState(193);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(194);
					((FactorContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==MUL || _la==DIV) ) {
						((FactorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(195);
					((FactorContext)_localctx).pp = preparenthesis();

					                  StringBuilder codeRes = new StringBuilder();      
					                  ((FactorContext)_localctx).type =  tradTwoElements(((FactorContext)_localctx).fac.type, ((FactorContext)_localctx).fac.code, ((FactorContext)_localctx).pp.type, ((FactorContext)_localctx).pp.code, codeRes); 
					                  ((FactorContext)_localctx).code =  codeRes.toString() + evalOp(_localctx.type, (((FactorContext)_localctx).op!=null?((FactorContext)_localctx).op.getText():null));
					                
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class CastContext extends ParserRuleContext {
		public String type;
		public String code;
		public Token ty;
		public ExpressionContext expr;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCast(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__4);
			setState(204);
			((CastContext)_localctx).ty = match(TYPE);
			setState(205);
			match(T__5);
			setState(206);
			((CastContext)_localctx).expr = expression(0);
			 ((CastContext)_localctx).type =  (((CastContext)_localctx).ty!=null?((CastContext)_localctx).ty.getText():null); ((CastContext)_localctx).code =  ((CastContext)_localctx).expr.code + tradOneElement(((CastContext)_localctx).expr.type, (((CastContext)_localctx).ty!=null?((CastContext)_localctx).ty.getText():null)); 
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

	public static class PreparenthesisContext extends ParserRuleContext {
		public String type;
		public String code;
		public ExpressionContext expr;
		public PreparenthesisContext pp;
		public AtomContext atom;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SUB() { return getToken(CalculetteParser.SUB, 0); }
		public PreparenthesisContext preparenthesis() {
			return getRuleContext(PreparenthesisContext.class,0);
		}
		public TerminalNode ADD() { return getToken(CalculetteParser.ADD, 0); }
		public TerminalNode NO() { return getToken(CalculetteParser.NO, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PreparenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preparenthesis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterPreparenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitPreparenthesis(this);
		}
	}

	public final PreparenthesisContext preparenthesis() throws RecognitionException {
		PreparenthesisContext _localctx = new PreparenthesisContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_preparenthesis);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(T__4);
				setState(210);
				((PreparenthesisContext)_localctx).expr = expression(0);
				setState(211);
				match(T__5);
				 ((PreparenthesisContext)_localctx).type =  ((PreparenthesisContext)_localctx).expr.type; ((PreparenthesisContext)_localctx).code =  ((PreparenthesisContext)_localctx).expr.code; 
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(SUB);
				setState(215);
				((PreparenthesisContext)_localctx).pp = preparenthesis();
				 ((PreparenthesisContext)_localctx).type =  ((PreparenthesisContext)_localctx).pp.type; ((PreparenthesisContext)_localctx).code =  evalNegPP(_localctx.type, ((PreparenthesisContext)_localctx).pp.code); 
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(ADD);
				setState(219);
				((PreparenthesisContext)_localctx).pp = preparenthesis();
				 ((PreparenthesisContext)_localctx).type =  ((PreparenthesisContext)_localctx).pp.type; ((PreparenthesisContext)_localctx).code =  ((PreparenthesisContext)_localctx).pp.code; 
				}
				break;
			case NO:
				enterOuterAlt(_localctx, 4);
				{
				setState(222);
				match(NO);
				setState(223);
				((PreparenthesisContext)_localctx).expr = expression(0);
				 ((PreparenthesisContext)_localctx).type =  "bool"; ((PreparenthesisContext)_localctx).code =  "PUSHI 1\n" + ((PreparenthesisContext)_localctx).expr.code + tradOneElement(((PreparenthesisContext)_localctx).expr.type, _localctx.type) + "SUB\n"; 
				}
				break;
			case ENTIER:
			case FLOAT:
			case BOOLEAN:
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				((PreparenthesisContext)_localctx).atom = atom();
				 ((PreparenthesisContext)_localctx).type =  ((PreparenthesisContext)_localctx).atom.type; ((PreparenthesisContext)_localctx).code =  ((PreparenthesisContext)_localctx).atom.code; 
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

	public static class AtomContext extends ParserRuleContext {
		public String type;
		public String code;
		public Token ent;
		public Token flo;
		public Token boo;
		public Token id;
		public ArgsContext args;
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode FLOAT() { return getToken(CalculetteParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(CalculetteParser.BOOLEAN, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atom);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				((AtomContext)_localctx).ent = match(ENTIER);
				 ((AtomContext)_localctx).type =  "int"; ((AtomContext)_localctx).code =  "PUSHI " + (((AtomContext)_localctx).ent!=null?((AtomContext)_localctx).ent.getText():null) + "\n"; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				((AtomContext)_localctx).flo = match(FLOAT);
				 ((AtomContext)_localctx).type =  "float"; ((AtomContext)_localctx).code =  "PUSHF " + (((AtomContext)_localctx).flo!=null?((AtomContext)_localctx).flo.getText():null) + "\n"; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				((AtomContext)_localctx).boo = match(BOOLEAN);
				 ((AtomContext)_localctx).type =  "bool"; ((AtomContext)_localctx).code =  ((((AtomContext)_localctx).boo!=null?((AtomContext)_localctx).boo.getText():null).equals("true") ? "PUSHI 1\n" : "PUSHI 0\n"); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				((AtomContext)_localctx).id = match(IDENTIFIANT);
				 
				        AdresseType at = tablesSymboles.getAdresseType((((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null)); 
				        ((AtomContext)_localctx).type =  at.type;
				        ((AtomContext)_localctx).code =  "PUSHG " + at.adresse + "\n";
				      
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				((AtomContext)_localctx).id = match(IDENTIFIANT);
				setState(240);
				match(T__4);
				setState(241);
				((AtomContext)_localctx).args = args();
				setState(242);
				match(T__5);
				 
				        ((AtomContext)_localctx).type =  tablesSymboles.getFunction((((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null)); 
				        String pusher = (_localctx.type.equals("int") ? "PUSHI 666\n" : "PUSHF 0.666\n"); //Push un nombre random pour memoire float ou int
				        ((AtomContext)_localctx).code =  pusher + ((AtomContext)_localctx).args.code + "CALL " + (((AtomContext)_localctx).id!=null?((AtomContext)_localctx).id.getText():null) + "\n";                 //Ajout du code des arguments et du CALL mvap
				        for (int i = 0; i < ((AtomContext)_localctx).args.nbArgs; i++){                                  //On pop tous les arguments lors du call
				          _localctx.code += "POP\n";                                                      //pour les utiliser pendant l'appel de la fonction       
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

	public static class IfElseInstrContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public InstructionContext ifinstr;
		public InstructionContext elseinstr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
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
		enterRule(_localctx, 20, RULE_ifElseInstr);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(T__6);
				setState(248);
				match(T__4);
				setState(249);
				((IfElseInstrContext)_localctx).expression = expression(0);
				setState(250);
				match(T__5);
				setState(251);
				((IfElseInstrContext)_localctx).ifinstr = instruction();
				 ((IfElseInstrContext)_localctx).code =  evalIf(((IfElseInstrContext)_localctx).expression.type, ((IfElseInstrContext)_localctx).expression.code, ((IfElseInstrContext)_localctx).ifinstr.code); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(T__6);
				setState(255);
				match(T__4);
				setState(256);
				((IfElseInstrContext)_localctx).expression = expression(0);
				setState(257);
				match(T__5);
				setState(258);
				((IfElseInstrContext)_localctx).ifinstr = instruction();
				setState(259);
				match(T__7);
				setState(260);
				((IfElseInstrContext)_localctx).elseinstr = instruction();
				 ((IfElseInstrContext)_localctx).code =  evalIfElse(((IfElseInstrContext)_localctx).expression.type, ((IfElseInstrContext)_localctx).expression.code, ((IfElseInstrContext)_localctx).ifinstr.code, ((IfElseInstrContext)_localctx).elseinstr.code); 
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

	public static class LoopInstrContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public InstructionContext instruction;
		public AssignationContext init;
		public AssignationContext iteration;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CalculetteParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CalculetteParser.SEMICOLON, i);
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
		enterRule(_localctx, 22, RULE_loopInstr);
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				match(T__8);
				setState(266);
				match(T__4);
				setState(267);
				((LoopInstrContext)_localctx).expression = expression(0);
				setState(268);
				match(T__5);
				setState(269);
				((LoopInstrContext)_localctx).instruction = instruction();
				 ((LoopInstrContext)_localctx).code =  evalWhileLoop(((LoopInstrContext)_localctx).expression.type, ((LoopInstrContext)_localctx).expression.code, ((LoopInstrContext)_localctx).instruction.code); 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(T__9);
				setState(273);
				match(T__4);
				setState(274);
				((LoopInstrContext)_localctx).init = assignation();
				setState(275);
				match(SEMICOLON);
				setState(276);
				((LoopInstrContext)_localctx).expression = expression(0);
				setState(277);
				match(SEMICOLON);
				setState(278);
				((LoopInstrContext)_localctx).iteration = assignation();
				setState(279);
				match(T__5);
				setState(280);
				((LoopInstrContext)_localctx).instruction = instruction();
				 ((LoopInstrContext)_localctx).code =  evalForLoop(((LoopInstrContext)_localctx).init.code, ((LoopInstrContext)_localctx).expression.type, ((LoopInstrContext)_localctx).expression.code, ((LoopInstrContext)_localctx).iteration.code, ((LoopInstrContext)_localctx).instruction.code); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				match(T__10);
				setState(284);
				((LoopInstrContext)_localctx).instruction = instruction();
				setState(285);
				match(T__11);
				setState(286);
				match(T__4);
				setState(287);
				((LoopInstrContext)_localctx).expression = expression(0);
				setState(288);
				match(T__5);
				 ((LoopInstrContext)_localctx).code =  evalRepeatLoop(((LoopInstrContext)_localctx).expression.type, ((LoopInstrContext)_localctx).expression.code, ((LoopInstrContext)_localctx).instruction.code); 
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
		enterRule(_localctx, 24, RULE_inputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__12);
			setState(294);
			((InputInstrContext)_localctx).id = match(IDENTIFIANT);
			setState(295);
			match(T__5);
			 ((InputInstrContext)_localctx).code =  evalInput((((InputInstrContext)_localctx).id!=null?((InputInstrContext)_localctx).id.getText():null)); 
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
		public ExpressionContext expr;
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
		enterRule(_localctx, 26, RULE_outputInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(T__13);
			setState(299);
			((OutputInstrContext)_localctx).expr = expression(0);
			setState(300);
			match(T__5);
			 ((OutputInstrContext)_localctx).code =  ((OutputInstrContext)_localctx).expr.code + evalOutput(((OutputInstrContext)_localctx).expr.type); 
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
		public Token ty;
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
		enterRule(_localctx, 28, RULE_fonction);
		 tablesSymboles.newTableLocale(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			((FonctionContext)_localctx).ty = match(TYPE);
			 tablesSymboles.putVar("return", (((FonctionContext)_localctx).ty!=null?((FonctionContext)_localctx).ty.getText():null)); 
			setState(305);
			((FonctionContext)_localctx).id = match(IDENTIFIANT);
			setState(306);
			match(T__4);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(307);
				params();
				}
			}

			setState(310);
			match(T__5);
			 tablesSymboles.newFunction((((FonctionContext)_localctx).id!=null?((FonctionContext)_localctx).id.getText():null), (((FonctionContext)_localctx).ty!=null?((FonctionContext)_localctx).ty.getText():null)); 
			setState(312);
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
		public Token ty;
		public Token id;
		public Token ty2;
		public Token id2;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CalculetteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculetteParser.COMMA, i);
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
		enterRule(_localctx, 30, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			((ParamsContext)_localctx).ty = match(TYPE);
			setState(316);
			((ParamsContext)_localctx).id = match(IDENTIFIANT);
			 tablesSymboles.putVar((((ParamsContext)_localctx).id!=null?((ParamsContext)_localctx).id.getText():null), (((ParamsContext)_localctx).ty!=null?((ParamsContext)_localctx).ty.getText():null)); 
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(318);
				match(COMMA);
				setState(319);
				((ParamsContext)_localctx).ty2 = match(TYPE);
				setState(320);
				((ParamsContext)_localctx).id2 = match(IDENTIFIANT);
				 tablesSymboles.putVar((((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null), (((ParamsContext)_localctx).ty2!=null?((ParamsContext)_localctx).ty2.getText():null)); 
				}
				}
				setState(326);
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
		public int nbArgs;
		public String code;
		public ExpressionContext expr;
		public ExpressionContext expr2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CalculetteParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalculetteParser.COMMA, i);
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
		enterRule(_localctx, 32, RULE_args);
		 ((ArgsContext)_localctx).nbArgs =  0; ((ArgsContext)_localctx).code =  new String(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << ADD) | (1L << SUB) | (1L << NO) | (1L << ENTIER) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << IDENTIFIANT))) != 0)) {
				{
				setState(327);
				((ArgsContext)_localctx).expr = expression(0);

				          _localctx.nbArgs++;           //Incrementation du nombre d'arguments
				          _localctx.code += ((ArgsContext)_localctx).expr.code; //On empile les arguments
				          if(((ArgsContext)_localctx).expr.type.equals("float")){
				            _localctx.nbArgs++;
				          }
				        
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(329);
					match(COMMA);
					setState(330);
					((ArgsContext)_localctx).expr2 = expression(0);

					            _localctx.nbArgs++;
					            if(((ArgsContext)_localctx).expr.type.equals("float")){
					              _localctx.nbArgs++;
					            }
					            _localctx.code += ((ArgsContext)_localctx).expr2.code;    
					          
					}
					}
					setState(337);
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
		enterRule(_localctx, 34, RULE_returnInstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__14);
			setState(341);
			((ReturnInstrContext)_localctx).expr = expression(0);
			 ((ReturnInstrContext)_localctx).code =  evalReturn(((ReturnInstrContext)_localctx).expr.type, ((ReturnInstrContext)_localctx).expr.code); 
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
		public List<TerminalNode> SEMICOLON() { return getTokens(CalculetteParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CalculetteParser.SEMICOLON, i);
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
		enterRule(_localctx, 36, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(344);
					_la = _input.LA(1);
					if ( !(_la==SEMICOLON || _la==NEWLINE) ) {
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
				setState(347); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 6:
			return factor_sempred((FactorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean factor_sempred(FactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0160\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\7\2\63"+
		"\n\2\f\2\16\2\66\13\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\7\2A\n\2"+
		"\f\2\16\2D\13\2\3\2\3\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3x\n\3\3\4\3\4\3\4\3\4\7\4~\n\4\f\4\16\4\u0081\13\4\3\4\3"+
		"\4\7\4\u0085\n\4\f\4\16\4\u0088\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\u0093\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u00a5\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00bb\n\7\f\7\16\7\u00be\13\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c9\n\b\f\b\16\b\u00cc\13\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00e8\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00f8\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u010a\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0126\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u0137\n\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0145"+
		"\n\21\f\21\16\21\u0148\13\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0150"+
		"\n\22\f\22\16\22\u0153\13\22\5\22\u0155\n\22\3\23\3\23\3\23\3\23\3\24"+
		"\6\24\u015c\n\24\r\24\16\24\u015d\3\24\2\4\f\16\25\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&\2\5\3\2\23\24\3\2\25\26\4\2\31\31##\2\u0175\2"+
		"-\3\2\2\2\4w\3\2\2\2\6y\3\2\2\2\b\u0092\3\2\2\2\n\u0094\3\2\2\2\f\u00a4"+
		"\3\2\2\2\16\u00bf\3\2\2\2\20\u00cd\3\2\2\2\22\u00e7\3\2\2\2\24\u00f7\3"+
		"\2\2\2\26\u0109\3\2\2\2\30\u0125\3\2\2\2\32\u0127\3\2\2\2\34\u012c\3\2"+
		"\2\2\36\u0131\3\2\2\2 \u013d\3\2\2\2\"\u0154\3\2\2\2$\u0156\3\2\2\2&\u015b"+
		"\3\2\2\2()\5\b\5\2)*\b\2\1\2*,\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-"+
		".\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\64\b\2\1\2\61\63\7#\2\2\62\61\3\2\2"+
		"\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65<\3\2\2\2\66\64\3\2\2\2"+
		"\678\5\36\20\289\b\2\1\29;\3\2\2\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3"+
		"\2\2\2=B\3\2\2\2><\3\2\2\2?A\7#\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3"+
		"\2\2\2CE\3\2\2\2DB\3\2\2\2EK\b\2\1\2FG\5\4\3\2GH\b\2\1\2HJ\3\2\2\2IF\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2\2NO\b\2\1\2O\3"+
		"\3\2\2\2PQ\5\f\7\2QR\5&\24\2RS\b\3\1\2Sx\3\2\2\2TU\5\b\5\2UV\5&\24\2V"+
		"W\b\3\1\2Wx\3\2\2\2XY\5\n\6\2YZ\5&\24\2Z[\b\3\1\2[x\3\2\2\2\\]\5\34\17"+
		"\2]^\5&\24\2^_\b\3\1\2_x\3\2\2\2`a\5\32\16\2ab\5&\24\2bc\b\3\1\2cx\3\2"+
		"\2\2de\5\30\r\2ef\5&\24\2fg\b\3\1\2gx\3\2\2\2hi\5\26\f\2ij\5&\24\2jk\b"+
		"\3\1\2kx\3\2\2\2lm\5\6\4\2mn\5&\24\2no\b\3\1\2ox\3\2\2\2pq\5$\23\2qr\5"+
		"&\24\2rs\b\3\1\2sx\3\2\2\2tu\5&\24\2uv\b\3\1\2vx\3\2\2\2wP\3\2\2\2wT\3"+
		"\2\2\2wX\3\2\2\2w\\\3\2\2\2w`\3\2\2\2wd\3\2\2\2wh\3\2\2\2wl\3\2\2\2wp"+
		"\3\2\2\2wt\3\2\2\2x\5\3\2\2\2y\177\7\3\2\2z{\5\4\3\2{|\b\4\1\2|~\3\2\2"+
		"\2}z\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0082\u0086\7\4\2\2\u0083\u0085\7#\2\2\u0084"+
		"\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\7\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\36\2\2\u008a\u008b"+
		"\7\"\2\2\u008b\u0093\b\5\1\2\u008c\u008d\7\36\2\2\u008d\u008e\7\"\2\2"+
		"\u008e\u008f\7\27\2\2\u008f\u0090\5\f\7\2\u0090\u0091\b\5\1\2\u0091\u0093"+
		"\3\2\2\2\u0092\u0089\3\2\2\2\u0092\u008c\3\2\2\2\u0093\t\3\2\2\2\u0094"+
		"\u0095\7\"\2\2\u0095\u0096\7\27\2\2\u0096\u0097\5\f\7\2\u0097\u0098\b"+
		"\6\1\2\u0098\13\3\2\2\2\u0099\u009a\b\7\1\2\u009a\u009b\5\16\b\2\u009b"+
		"\u009c\b\7\1\2\u009c\u00a5\3\2\2\2\u009d\u009e\5\20\t\2\u009e\u009f\b"+
		"\7\1\2\u009f\u00a5\3\2\2\2\u00a0\u00a1\7\5\2\2\u00a1\u00a5\b\7\1\2\u00a2"+
		"\u00a3\7\6\2\2\u00a3\u00a5\b\7\1\2\u00a4\u0099\3\2\2\2\u00a4\u009d\3\2"+
		"\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00bc\3\2\2\2\u00a6"+
		"\u00a7\f\5\2\2\u00a7\u00a8\7\35\2\2\u00a8\u00a9\5\f\7\6\u00a9\u00aa\b"+
		"\7\1\2\u00aa\u00bb\3\2\2\2\u00ab\u00ac\f\4\2\2\u00ac\u00ad\7\32\2\2\u00ad"+
		"\u00ae\5\f\7\5\u00ae\u00af\b\7\1\2\u00af\u00bb\3\2\2\2\u00b0\u00b1\f\3"+
		"\2\2\u00b1\u00b2\7\33\2\2\u00b2\u00b3\5\f\7\4\u00b3\u00b4\b\7\1\2\u00b4"+
		"\u00bb\3\2\2\2\u00b5\u00b6\f\n\2\2\u00b6\u00b7\t\2\2\2\u00b7\u00b8\5\16"+
		"\b\2\u00b8\u00b9\b\7\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00a6\3\2\2\2\u00ba"+
		"\u00ab\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb\u00be\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\r\3\2\2\2\u00be\u00bc"+
		"\3\2\2\2\u00bf\u00c0\b\b\1\2\u00c0\u00c1\5\22\n\2\u00c1\u00c2\b\b\1\2"+
		"\u00c2\u00ca\3\2\2\2\u00c3\u00c4\f\4\2\2\u00c4\u00c5\t\3\2\2\u00c5\u00c6"+
		"\5\22\n\2\u00c6\u00c7\b\b\1\2\u00c7\u00c9\3\2\2\2\u00c8\u00c3\3\2\2\2"+
		"\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\17"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\7\2\2\u00ce\u00cf\7\36\2\2"+
		"\u00cf\u00d0\7\b\2\2\u00d0\u00d1\5\f\7\2\u00d1\u00d2\b\t\1\2\u00d2\21"+
		"\3\2\2\2\u00d3\u00d4\7\7\2\2\u00d4\u00d5\5\f\7\2\u00d5\u00d6\7\b\2\2\u00d6"+
		"\u00d7\b\n\1\2\u00d7\u00e8\3\2\2\2\u00d8\u00d9\7\24\2\2\u00d9\u00da\5"+
		"\22\n\2\u00da\u00db\b\n\1\2\u00db\u00e8\3\2\2\2\u00dc\u00dd\7\23\2\2\u00dd"+
		"\u00de\5\22\n\2\u00de\u00df\b\n\1\2\u00df\u00e8\3\2\2\2\u00e0\u00e1\7"+
		"\34\2\2\u00e1\u00e2\5\f\7\2\u00e2\u00e3\b\n\1\2\u00e3\u00e8\3\2\2\2\u00e4"+
		"\u00e5\5\24\13\2\u00e5\u00e6\b\n\1\2\u00e6\u00e8\3\2\2\2\u00e7\u00d3\3"+
		"\2\2\2\u00e7\u00d8\3\2\2\2\u00e7\u00dc\3\2\2\2\u00e7\u00e0\3\2\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e8\23\3\2\2\2\u00e9\u00ea\7\37\2\2\u00ea\u00f8\b\13"+
		"\1\2\u00eb\u00ec\7 \2\2\u00ec\u00f8\b\13\1\2\u00ed\u00ee\7!\2\2\u00ee"+
		"\u00f8\b\13\1\2\u00ef\u00f0\7\"\2\2\u00f0\u00f8\b\13\1\2\u00f1\u00f2\7"+
		"\"\2\2\u00f2\u00f3\7\7\2\2\u00f3\u00f4\5\"\22\2\u00f4\u00f5\7\b\2\2\u00f5"+
		"\u00f6\b\13\1\2\u00f6\u00f8\3\2\2\2\u00f7\u00e9\3\2\2\2\u00f7\u00eb\3"+
		"\2\2\2\u00f7\u00ed\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f1\3\2\2\2\u00f8"+
		"\25\3\2\2\2\u00f9\u00fa\7\t\2\2\u00fa\u00fb\7\7\2\2\u00fb\u00fc\5\f\7"+
		"\2\u00fc\u00fd\7\b\2\2\u00fd\u00fe\5\4\3\2\u00fe\u00ff\b\f\1\2\u00ff\u010a"+
		"\3\2\2\2\u0100\u0101\7\t\2\2\u0101\u0102\7\7\2\2\u0102\u0103\5\f\7\2\u0103"+
		"\u0104\7\b\2\2\u0104\u0105\5\4\3\2\u0105\u0106\7\n\2\2\u0106\u0107\5\4"+
		"\3\2\u0107\u0108\b\f\1\2\u0108\u010a\3\2\2\2\u0109\u00f9\3\2\2\2\u0109"+
		"\u0100\3\2\2\2\u010a\27\3\2\2\2\u010b\u010c\7\13\2\2\u010c\u010d\7\7\2"+
		"\2\u010d\u010e\5\f\7\2\u010e\u010f\7\b\2\2\u010f\u0110\5\4\3\2\u0110\u0111"+
		"\b\r\1\2\u0111\u0126\3\2\2\2\u0112\u0113\7\f\2\2\u0113\u0114\7\7\2\2\u0114"+
		"\u0115\5\n\6\2\u0115\u0116\7\31\2\2\u0116\u0117\5\f\7\2\u0117\u0118\7"+
		"\31\2\2\u0118\u0119\5\n\6\2\u0119\u011a\7\b\2\2\u011a\u011b\5\4\3\2\u011b"+
		"\u011c\b\r\1\2\u011c\u0126\3\2\2\2\u011d\u011e\7\r\2\2\u011e\u011f\5\4"+
		"\3\2\u011f\u0120\7\16\2\2\u0120\u0121\7\7\2\2\u0121\u0122\5\f\7\2\u0122"+
		"\u0123\7\b\2\2\u0123\u0124\b\r\1\2\u0124\u0126\3\2\2\2\u0125\u010b\3\2"+
		"\2\2\u0125\u0112\3\2\2\2\u0125\u011d\3\2\2\2\u0126\31\3\2\2\2\u0127\u0128"+
		"\7\17\2\2\u0128\u0129\7\"\2\2\u0129\u012a\7\b\2\2\u012a\u012b\b\16\1\2"+
		"\u012b\33\3\2\2\2\u012c\u012d\7\20\2\2\u012d\u012e\5\f\7\2\u012e\u012f"+
		"\7\b\2\2\u012f\u0130\b\17\1\2\u0130\35\3\2\2\2\u0131\u0132\7\36\2\2\u0132"+
		"\u0133\b\20\1\2\u0133\u0134\7\"\2\2\u0134\u0136\7\7\2\2\u0135\u0137\5"+
		" \21\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0139\7\b\2\2\u0139\u013a\b\20\1\2\u013a\u013b\5\6\4\2\u013b\u013c\b"+
		"\20\1\2\u013c\37\3\2\2\2\u013d\u013e\7\36\2\2\u013e\u013f\7\"\2\2\u013f"+
		"\u0146\b\21\1\2\u0140\u0141\7\30\2\2\u0141\u0142\7\36\2\2\u0142\u0143"+
		"\7\"\2\2\u0143\u0145\b\21\1\2\u0144\u0140\3\2\2\2\u0145\u0148\3\2\2\2"+
		"\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147!\3\2\2\2\u0148\u0146\3"+
		"\2\2\2\u0149\u014a\5\f\7\2\u014a\u0151\b\22\1\2\u014b\u014c\7\30\2\2\u014c"+
		"\u014d\5\f\7\2\u014d\u014e\b\22\1\2\u014e\u0150\3\2\2\2\u014f\u014b\3"+
		"\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0149\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155#\3\2\2\2\u0156\u0157\7\21\2\2\u0157\u0158\5\f\7\2\u0158\u0159"+
		"\b\23\1\2\u0159%\3\2\2\2\u015a\u015c\t\4\2\2\u015b\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\'\3\2\2\2"+
		"\30-\64<BKw\177\u0086\u0092\u00a4\u00ba\u00bc\u00ca\u00e7\u00f7\u0109"+
		"\u0125\u0136\u0146\u0151\u0154\u015d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}