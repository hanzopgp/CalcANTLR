// Generated from Calculette.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "KEYWORDS", "ADD", 
			"SUB", "MUL", "DIV", "EQUAL", "COMMA", "SEMICOLON", "AND", "OR", "NO", 
			"COND", "TYPE", "ENTIER", "FLOAT", "BOOLEAN", "IDENTIFIANT", "NEWLINE", 
			"WS", "MULTILINECOMMENT", "SINGLELINECOMMENT", "HASHTAGCOMMENT", "UNMATCH"
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


	public CalculetteLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0158\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00cd"+
		"\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u00ee\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u00fc\n\35\3\36\6\36\u00ff\n\36\r\36\16"+
		"\36\u0100\3\37\6\37\u0104\n\37\r\37\16\37\u0105\3\37\3\37\7\37\u010a\n"+
		"\37\f\37\16\37\u010d\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0118\n \3!\6"+
		"!\u011b\n!\r!\16!\u011c\3!\7!\u0120\n!\f!\16!\u0123\13!\3\"\5\"\u0126"+
		"\n\"\3\"\3\"\3\"\3\"\3#\6#\u012d\n#\r#\16#\u012e\3#\3#\3$\3$\3$\3$\7$"+
		"\u0137\n$\f$\16$\u013a\13$\3$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u0145\n%\f%\16"+
		"%\u0148\13%\3%\3%\3&\3&\7&\u014e\n&\f&\16&\u0151\13&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\u0138\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\6\4\2>>@@\4\2C\\c|\4\2\13\13"+
		"\"\"\4\2\f\f\17\17\2\u0173\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2"+
		"\5Q\3\2\2\2\7S\3\2\2\2\tX\3\2\2\2\13^\3\2\2\2\r`\3\2\2\2\17b\3\2\2\2\21"+
		"e\3\2\2\2\23j\3\2\2\2\25p\3\2\2\2\27t\3\2\2\2\31{\3\2\2\2\33\u0081\3\2"+
		"\2\2\35\u0087\3\2\2\2\37\u008e\3\2\2\2!\u00cc\3\2\2\2#\u00ce\3\2\2\2%"+
		"\u00d0\3\2\2\2\'\u00d2\3\2\2\2)\u00d4\3\2\2\2+\u00d6\3\2\2\2-\u00d8\3"+
		"\2\2\2/\u00da\3\2\2\2\61\u00dc\3\2\2\2\63\u00df\3\2\2\2\65\u00e2\3\2\2"+
		"\2\67\u00ed\3\2\2\29\u00fb\3\2\2\2;\u00fe\3\2\2\2=\u0103\3\2\2\2?\u0117"+
		"\3\2\2\2A\u011a\3\2\2\2C\u0125\3\2\2\2E\u012c\3\2\2\2G\u0132\3\2\2\2I"+
		"\u0140\3\2\2\2K\u014b\3\2\2\2M\u0154\3\2\2\2OP\7}\2\2P\4\3\2\2\2QR\7\177"+
		"\2\2R\6\3\2\2\2ST\7v\2\2TU\7t\2\2UV\7w\2\2VW\7g\2\2W\b\3\2\2\2XY\7h\2"+
		"\2YZ\7c\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2]\n\3\2\2\2^_\7*\2\2_\f\3\2\2"+
		"\2`a\7+\2\2a\16\3\2\2\2bc\7k\2\2cd\7h\2\2d\20\3\2\2\2ef\7g\2\2fg\7n\2"+
		"\2gh\7u\2\2hi\7g\2\2i\22\3\2\2\2jk\7y\2\2kl\7j\2\2lm\7k\2\2mn\7n\2\2n"+
		"o\7g\2\2o\24\3\2\2\2pq\7h\2\2qr\7q\2\2rs\7t\2\2s\26\3\2\2\2tu\7t\2\2u"+
		"v\7g\2\2vw\7r\2\2wx\7g\2\2xy\7c\2\2yz\7v\2\2z\30\3\2\2\2{|\7w\2\2|}\7"+
		"p\2\2}~\7v\2\2~\177\7k\2\2\177\u0080\7n\2\2\u0080\32\3\2\2\2\u0081\u0082"+
		"\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7c\2\2\u0084\u0085\7f\2\2\u0085"+
		"\u0086\7*\2\2\u0086\34\3\2\2\2\u0087\u0088\7y\2\2\u0088\u0089\7t\2\2\u0089"+
		"\u008a\7k\2\2\u008a\u008b\7v\2\2\u008b\u008c\7g\2\2\u008c\u008d\7*\2\2"+
		"\u008d\36\3\2\2\2\u008e\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7"+
		"v\2\2\u0091\u0092\7w\2\2\u0092\u0093\7t\2\2\u0093\u0094\7p\2\2\u0094 "+
		"\3\2\2\2\u0095\u0096\7k\2\2\u0096\u00cd\7h\2\2\u0097\u0098\7g\2\2\u0098"+
		"\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u00cd\7g\2\2\u009b\u009c\7d\2\2"+
		"\u009c\u009d\7t\2\2\u009d\u009e\7g\2\2\u009e\u009f\7c\2\2\u009f\u00cd"+
		"\7m\2\2\u00a0\u00a1\7y\2\2\u00a1\u00a2\7j\2\2\u00a2\u00a3\7k\2\2\u00a3"+
		"\u00a4\7n\2\2\u00a4\u00cd\7g\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7\7q\2\2"+
		"\u00a7\u00cd\7t\2\2\u00a8\u00a9\7f\2\2\u00a9\u00cd\7q\2\2\u00aa\u00ab"+
		"\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7c\2\2\u00af\u00cd\7v\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7p\2\2"+
		"\u00b2\u00b3\7v\2\2\u00b3\u00b4\7k\2\2\u00b4\u00cd\7n\2\2\u00b5\u00b6"+
		"\7h\2\2\u00b6\u00b7\7w\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7e\2\2\u00b9"+
		"\u00ba\7v\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7q\2\2\u00bc\u00cd\7p\2\2"+
		"\u00bd\u00be\7t\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1"+
		"\7w\2\2\u00c1\u00c2\7t\2\2\u00c2\u00cd\7p\2\2\u00c3\u00c4\7y\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7v\2\2\u00c7\u00cd\7g\2\2"+
		"\u00c8\u00c9\7t\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cd"+
		"\7f\2\2\u00cc\u0095\3\2\2\2\u00cc\u0097\3\2\2\2\u00cc\u009b\3\2\2\2\u00cc"+
		"\u00a0\3\2\2\2\u00cc\u00a5\3\2\2\2\u00cc\u00a8\3\2\2\2\u00cc\u00aa\3\2"+
		"\2\2\u00cc\u00b0\3\2\2\2\u00cc\u00b5\3\2\2\2\u00cc\u00bd\3\2\2\2\u00cc"+
		"\u00c3\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cd\"\3\2\2\2\u00ce\u00cf\7-\2\2"+
		"\u00cf$\3\2\2\2\u00d0\u00d1\7/\2\2\u00d1&\3\2\2\2\u00d2\u00d3\7,\2\2\u00d3"+
		"(\3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7?\2\2\u00d7"+
		",\3\2\2\2\u00d8\u00d9\7.\2\2\u00d9.\3\2\2\2\u00da\u00db\7=\2\2\u00db\60"+
		"\3\2\2\2\u00dc\u00dd\7(\2\2\u00dd\u00de\7(\2\2\u00de\62\3\2\2\2\u00df"+
		"\u00e0\7~\2\2\u00e0\u00e1\7~\2\2\u00e1\64\3\2\2\2\u00e2\u00e3\7#\2\2\u00e3"+
		"\66\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\u00ee\7?\2\2\u00e6\u00ee\t\2\2\2"+
		"\u00e7\u00e8\7>\2\2\u00e8\u00ee\7?\2\2\u00e9\u00ea\7@\2\2\u00ea\u00ee"+
		"\7?\2\2\u00eb\u00ec\7#\2\2\u00ec\u00ee\7?\2\2\u00ed\u00e4\3\2\2\2\u00ed"+
		"\u00e6\3\2\2\2\u00ed\u00e7\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee8\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00fc"+
		"\7v\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7q\2\2\u00f5"+
		"\u00f6\7c\2\2\u00f6\u00fc\7v\2\2\u00f7\u00f8\7d\2\2\u00f8\u00f9\7q\2\2"+
		"\u00f9\u00fa\7q\2\2\u00fa\u00fc\7n\2\2\u00fb\u00ef\3\2\2\2\u00fb\u00f2"+
		"\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fc:\3\2\2\2\u00fd\u00ff\4\62;\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101<\3\2\2\2\u0102\u0104\4\62;\2\u0103\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010b\7\60\2\2\u0108\u010a\4\62;\2\u0109\u0108\3\2\2\2\u010a\u010d\3"+
		"\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c>\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010e\u010f\7v\2\2\u010f\u0110\7t\2\2\u0110\u0111\7w\2\2\u0111"+
		"\u0118\7g\2\2\u0112\u0113\7h\2\2\u0113\u0114\7c\2\2\u0114\u0115\7n\2\2"+
		"\u0115\u0116\7u\2\2\u0116\u0118\7g\2\2\u0117\u010e\3\2\2\2\u0117\u0112"+
		"\3\2\2\2\u0118@\3\2\2\2\u0119\u011b\t\3\2\2\u011a\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0121\3\2"+
		"\2\2\u011e\u0120\4\62;\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122B\3\2\2\2\u0123\u0121\3\2\2\2"+
		"\u0124\u0126\7\17\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127"+
		"\3\2\2\2\u0127\u0128\7\f\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b\"\2\2\u012a"+
		"D\3\2\2\2\u012b\u012d\t\4\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2"+
		"\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131"+
		"\b#\2\2\u0131F\3\2\2\2\u0132\u0133\7\61\2\2\u0133\u0134\7,\2\2\u0134\u0138"+
		"\3\2\2\2\u0135\u0137\13\2\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2"+
		"\u0138\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013b\u013c\7,\2\2\u013c\u013d\7\61\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013f\b$\2\2\u013fH\3\2\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7\61\2\2"+
		"\u0142\u0146\3\2\2\2\u0143\u0145\n\5\2\2\u0144\u0143\3\2\2\2\u0145\u0148"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0149\u014a\b%\2\2\u014aJ\3\2\2\2\u014b\u014f\7%\2\2\u014c"+
		"\u014e\n\5\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152"+
		"\u0153\b&\2\2\u0153L\3\2\2\2\u0154\u0155\13\2\2\2\u0155\u0156\3\2\2\2"+
		"\u0156\u0157\b\'\2\2\u0157N\3\2\2\2\21\2\u00cc\u00ed\u00fb\u0100\u0105"+
		"\u010b\u0117\u011c\u0121\u0125\u012e\u0138\u0146\u014f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}