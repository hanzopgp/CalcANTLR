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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, KEYWORDS=26, COND=27, TYPE=28, ENTIER=29, FLOAT=30, BOOLEAN=31, 
		IDENTIFIANT=32, NEWLINE=33, WS=34, MULTILINECOMMENT=35, SINGLELINECOMMENT=36, 
		HASHTAGCOMMENT=37, UNMATCH=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"KEYWORDS", "COND", "TYPE", "ENTIER", "FLOAT", "BOOLEAN", "IDENTIFIANT", 
			"NEWLINE", "WS", "MULTILINECOMMENT", "SINGLELINECOMMENT", "HASHTAGCOMMENT", 
			"UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'='", "'+'", "'-'", "'true'", "'false'", "'&&'", 
			"'||'", "'*'", "'/'", "'('", "')'", "'!'", "'if('", "'else'", "'while('", 
			"'for('", "';'", "'repeat'", "'until('", "'read('", "'write('", "','", 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "KEYWORDS", "COND", "TYPE", "ENTIER", "FLOAT", "BOOLEAN", 
			"IDENTIFIANT", "NEWLINE", "WS", "MULTILINECOMMENT", "SINGLELINECOMMENT", 
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
	      boolean noAddressTest = at.adresse == 0;
	      boolean noRightTypeTest = !(at.type.equals("int") || at.type.equals("float") || at.type.equals("bool"));
	      if(noAddressTest || noRightTypeTest){
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
	    private String evalWhileLoop(String exprType, String expr, String block){ 
	      String startLabelW = getNewLabel();                                     
	      String endLabelW = getNewLabel();
	      expr += tradOneElement(exprType, "bool");
	      testEmptyStringErrors(exprType, expr, block);
	      return "LABEL " + startLabelW + "\n" + expr + "JUMPF " + endLabelW + "\n"
	             + block + "JUMP " + startLabelW + "\n" + "LABEL " + endLabelW + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle for
	    private String evalForLoop(String init, String exprType, String expr, String iteration, String block){  
	      String startLabelF = getNewLabel();                                                                    
	      String endLabelF = getNewLabel();
	      expr += tradOneElement(exprType, "bool");
	      testEmptyStringErrors(init, exprType, expr, iteration, block);
	      return init + "LABEL " + startLabelF + "\n" + expr + "JUMPF " + endLabelF + "\n"
	             + block + iteration + "JUMP " + startLabelF + "\n" + "LABEL " + endLabelF + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle repeat until
	    private String evalRepeatLoop(String exprType, String expr, String block){                                                  
	      String startLabelR = getNewLabel();
	      expr += tradOneElement(exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, block);
	      return "LABEL " + startLabelR + "\n" + block 
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
	    private String evalIfElse(String exprType, String expr, String ifBlock, String elseBlock){                                                                                 
	      String elseStartLabel = getNewLabel();                                                                   
	      String ifEndLabel = getNewLabel(); 
	      expr += tradOneElement(exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, ifBlock, elseBlock);
	      return expr + "\n" + "JUMPF " + elseStartLabel +"\n" 
	             + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
	             + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
	    }

	    //Fonction renvoyant le code mvap pour un branchement compose d'un seul if
	    private String evalIf(String exprType, String expr, String ifBlock){      
	      String ifEndLabel = getNewLabel();                                           
	      expr += tradOneElement(exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, ifBlock);                                                     
	      return expr + "\n" + "JUMPF " + ifEndLabel 
	             + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u015c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5"+
		"\33\u00e7\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f2"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u0100\n\35\3\36\6\36\u0103\n\36\r\36\16\36\u0104\3\37\6\37\u0108\n\37"+
		"\r\37\16\37\u0109\3\37\3\37\7\37\u010e\n\37\f\37\16\37\u0111\13\37\3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \5 \u011c\n \3!\6!\u011f\n!\r!\16!\u0120\3!\7"+
		"!\u0124\n!\f!\16!\u0127\13!\3\"\5\"\u012a\n\"\3\"\3\"\3\"\3\"\3#\6#\u0131"+
		"\n#\r#\16#\u0132\3#\3#\3$\3$\3$\3$\7$\u013b\n$\f$\16$\u013e\13$\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\7%\u0149\n%\f%\16%\u014c\13%\3%\3%\3&\3&\7&\u0152"+
		"\n&\f&\16&\u0155\13&\3&\3&\3\'\3\'\3\'\3\'\3\u013c\2(\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(\3\2\6\4\2>>@@\4\2C\\c|\4\2\13\13\"\"\4\2\f\f\17\17\2\u0177\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7S\3\2\2\2\tU\3\2"+
		"\2\2\13W\3\2\2\2\rY\3\2\2\2\17^\3\2\2\2\21d\3\2\2\2\23g\3\2\2\2\25j\3"+
		"\2\2\2\27l\3\2\2\2\31n\3\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37t\3\2\2\2!x\3"+
		"\2\2\2#}\3\2\2\2%\u0084\3\2\2\2\'\u0089\3\2\2\2)\u008b\3\2\2\2+\u0092"+
		"\3\2\2\2-\u0099\3\2\2\2/\u009f\3\2\2\2\61\u00a6\3\2\2\2\63\u00a8\3\2\2"+
		"\2\65\u00e6\3\2\2\2\67\u00f1\3\2\2\29\u00ff\3\2\2\2;\u0102\3\2\2\2=\u0107"+
		"\3\2\2\2?\u011b\3\2\2\2A\u011e\3\2\2\2C\u0129\3\2\2\2E\u0130\3\2\2\2G"+
		"\u0136\3\2\2\2I\u0144\3\2\2\2K\u014f\3\2\2\2M\u0158\3\2\2\2OP\7}\2\2P"+
		"\4\3\2\2\2QR\7\177\2\2R\6\3\2\2\2ST\7?\2\2T\b\3\2\2\2UV\7-\2\2V\n\3\2"+
		"\2\2WX\7/\2\2X\f\3\2\2\2YZ\7v\2\2Z[\7t\2\2[\\\7w\2\2\\]\7g\2\2]\16\3\2"+
		"\2\2^_\7h\2\2_`\7c\2\2`a\7n\2\2ab\7u\2\2bc\7g\2\2c\20\3\2\2\2de\7(\2\2"+
		"ef\7(\2\2f\22\3\2\2\2gh\7~\2\2hi\7~\2\2i\24\3\2\2\2jk\7,\2\2k\26\3\2\2"+
		"\2lm\7\61\2\2m\30\3\2\2\2no\7*\2\2o\32\3\2\2\2pq\7+\2\2q\34\3\2\2\2rs"+
		"\7#\2\2s\36\3\2\2\2tu\7k\2\2uv\7h\2\2vw\7*\2\2w \3\2\2\2xy\7g\2\2yz\7"+
		"n\2\2z{\7u\2\2{|\7g\2\2|\"\3\2\2\2}~\7y\2\2~\177\7j\2\2\177\u0080\7k\2"+
		"\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082\u0083\7*\2\2\u0083$\3\2"+
		"\2\2\u0084\u0085\7h\2\2\u0085\u0086\7q\2\2\u0086\u0087\7t\2\2\u0087\u0088"+
		"\7*\2\2\u0088&\3\2\2\2\u0089\u008a\7=\2\2\u008a(\3\2\2\2\u008b\u008c\7"+
		"t\2\2\u008c\u008d\7g\2\2\u008d\u008e\7r\2\2\u008e\u008f\7g\2\2\u008f\u0090"+
		"\7c\2\2\u0090\u0091\7v\2\2\u0091*\3\2\2\2\u0092\u0093\7w\2\2\u0093\u0094"+
		"\7p\2\2\u0094\u0095\7v\2\2\u0095\u0096\7k\2\2\u0096\u0097\7n\2\2\u0097"+
		"\u0098\7*\2\2\u0098,\3\2\2\2\u0099\u009a\7t\2\2\u009a\u009b\7g\2\2\u009b"+
		"\u009c\7c\2\2\u009c\u009d\7f\2\2\u009d\u009e\7*\2\2\u009e.\3\2\2\2\u009f"+
		"\u00a0\7y\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7v\2\2"+
		"\u00a3\u00a4\7g\2\2\u00a4\u00a5\7*\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7"+
		".\2\2\u00a7\62\3\2\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7v\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7p\2\2\u00ae"+
		"\64\3\2\2\2\u00af\u00b0\7k\2\2\u00b0\u00e7\7h\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"\u00b3\7n\2\2\u00b3\u00b4\7u\2\2\u00b4\u00e7\7g\2\2\u00b5\u00b6\7d\2\2"+
		"\u00b6\u00b7\7t\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7c\2\2\u00b9\u00e7"+
		"\7m\2\2\u00ba\u00bb\7y\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7k\2\2\u00bd"+
		"\u00be\7n\2\2\u00be\u00e7\7g\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7q\2\2"+
		"\u00c1\u00e7\7t\2\2\u00c2\u00c3\7f\2\2\u00c3\u00e7\7q\2\2\u00c4\u00c5"+
		"\7t\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00e7\7v\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7p\2\2"+
		"\u00cc\u00cd\7v\2\2\u00cd\u00ce\7k\2\2\u00ce\u00e7\7n\2\2\u00cf\u00d0"+
		"\7h\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7e\2\2\u00d3"+
		"\u00d4\7v\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7q\2\2\u00d6\u00e7\7p\2\2"+
		"\u00d7\u00d8\7t\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7v\2\2\u00da\u00db"+
		"\7w\2\2\u00db\u00dc\7t\2\2\u00dc\u00e7\7p\2\2\u00dd\u00de\7y\2\2\u00de"+
		"\u00df\7t\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e7\7g\2\2"+
		"\u00e2\u00e3\7t\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e7"+
		"\7f\2\2\u00e6\u00af\3\2\2\2\u00e6\u00b1\3\2\2\2\u00e6\u00b5\3\2\2\2\u00e6"+
		"\u00ba\3\2\2\2\u00e6\u00bf\3\2\2\2\u00e6\u00c2\3\2\2\2\u00e6\u00c4\3\2"+
		"\2\2\u00e6\u00ca\3\2\2\2\u00e6\u00cf\3\2\2\2\u00e6\u00d7\3\2\2\2\u00e6"+
		"\u00dd\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e7\66\3\2\2\2\u00e8\u00e9\7?\2\2"+
		"\u00e9\u00f2\7?\2\2\u00ea\u00f2\t\2\2\2\u00eb\u00ec\7>\2\2\u00ec\u00f2"+
		"\7?\2\2\u00ed\u00ee\7@\2\2\u00ee\u00f2\7?\2\2\u00ef\u00f0\7#\2\2\u00f0"+
		"\u00f2\7?\2\2\u00f1\u00e8\3\2\2\2\u00f1\u00ea\3\2\2\2\u00f1\u00eb\3\2"+
		"\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f28\3\2\2\2\u00f3\u00f4"+
		"\7k\2\2\u00f4\u00f5\7p\2\2\u00f5\u0100\7v\2\2\u00f6\u00f7\7h\2\2\u00f7"+
		"\u00f8\7n\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7c\2\2\u00fa\u0100\7v\2\2"+
		"\u00fb\u00fc\7d\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe\7q\2\2\u00fe\u0100"+
		"\7n\2\2\u00ff\u00f3\3\2\2\2\u00ff\u00f6\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100"+
		":\3\2\2\2\u0101\u0103\4\62;\2\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2"+
		"\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105<\3\2\2\2\u0106\u0108\4"+
		"\62;\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010f\7\60\2\2\u010c\u010e\4"+
		"\62;\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110>\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7v\2\2\u0113"+
		"\u0114\7t\2\2\u0114\u0115\7w\2\2\u0115\u011c\7g\2\2\u0116\u0117\7h\2\2"+
		"\u0117\u0118\7c\2\2\u0118\u0119\7n\2\2\u0119\u011a\7u\2\2\u011a\u011c"+
		"\7g\2\2\u011b\u0112\3\2\2\2\u011b\u0116\3\2\2\2\u011c@\3\2\2\2\u011d\u011f"+
		"\t\3\2\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0125\3\2\2\2\u0122\u0124\4\62;\2\u0123\u0122\3\2"+
		"\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"B\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012a\7\17\2\2\u0129\u0128\3\2\2\2"+
		"\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\7\f\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012e\b\"\2\2\u012eD\3\2\2\2\u012f\u0131\t\4\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u0135\b#\2\2\u0135F\3\2\2\2\u0136\u0137"+
		"\7\61\2\2\u0137\u0138\7,\2\2\u0138\u013c\3\2\2\2\u0139\u013b\13\2\2\2"+
		"\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013d\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7,\2\2\u0140"+
		"\u0141\7\61\2\2\u0141\u0142\3\2\2\2\u0142\u0143\b$\2\2\u0143H\3\2\2\2"+
		"\u0144\u0145\7\61\2\2\u0145\u0146\7\61\2\2\u0146\u014a\3\2\2\2\u0147\u0149"+
		"\n\5\2\2\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014d\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\b%"+
		"\2\2\u014eJ\3\2\2\2\u014f\u0153\7%\2\2\u0150\u0152\n\5\2\2\u0151\u0150"+
		"\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\b&\2\2\u0157L\3\2\2\2\u0158"+
		"\u0159\13\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\b\'\2\2\u015bN\3\2\2\2"+
		"\21\2\u00e6\u00f1\u00ff\u0104\u0109\u010f\u011b\u0120\u0125\u0129\u0132"+
		"\u013c\u014a\u0153\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}