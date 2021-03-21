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
		ADD=17, SUB=18, MUL=19, DIV=20, INCREMENTS=21, EQUAL=22, COMMA=23, SEMICOLON=24, 
		AND=25, OR=26, NO=27, COND=28, TYPE=29, ENTIER=30, FLOAT=31, BOOLEAN=32, 
		IDENTIFIANT=33, NEWLINE=34, WS=35, MULTILINECOMMENT=36, SINGLELINECOMMENT=37, 
		HASHTAGCOMMENT=38, UNMATCH=39;
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
			"SUB", "MUL", "DIV", "INCREMENTS", "EQUAL", "COMMA", "SEMICOLON", "AND", 
			"OR", "NO", "COND", "TYPE", "ENTIER", "FLOAT", "BOOLEAN", "IDENTIFIANT", 
			"NEWLINE", "WS", "MULTILINECOMMENT", "SINGLELINECOMMENT", "HASHTAGCOMMENT", 
			"UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'true'", "'false'", "'('", "')'", "'if'", "'else'", 
			"'while'", "'for'", "'repeat'", "'until'", "'read'", "'write'", "'return'", 
			null, "'+'", "'-'", "'*'", "'/'", null, "'='", "','", "';'", "'&&'", 
			"'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "KEYWORDS", "ADD", "SUB", "MUL", "DIV", "INCREMENTS", 
			"EQUAL", "COMMA", "SEMICOLON", "AND", "OR", "NO", "COND", "TYPE", "ENTIER", 
			"FLOAT", "BOOLEAN", "IDENTIFIANT", "NEWLINE", "WS", "MULTILINECOMMENT", 
			"SINGLELINECOMMENT", "HASHTAGCOMMENT", "UNMATCH"
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


	    private TablesSymboles tablesSymboles = new TablesSymboles();            //On utilise la table de symboles pour garder les
	    private int _cur_label = 1;                                              //liens id/type et les valeurs dans les adresses
	    private String getNewLabel(String name) { return name +(_cur_label++); } //Retourne un label avec un nom + index pour debug
	    
	    private int nbWarningsImplicitCast = 0;                                  //Comptage des avertissements
	    private int nbWarningsTotal = nbWarningsImplicitCast;

	    private int nbErrorsEmptyString = 0;                                     //Comptage des erreurs
	    private int nbErrorsAddress = 0;                              
	    private int nbErrorsOperator = 0;                             
	    private int nbErrorsCondition = 0;                            
	    private int nbErrorsCast = 0;                                 
	    private int nbErrorsAutoCast = 0;   
	    private int nbErrorsTotal                                     
	            = nbErrorsEmptyString + nbErrorsAddress               
	            + nbErrorsOperator + nbErrorsCondition 
	            + nbErrorsCast + nbErrorsAutoCast;  

	    private int mvapStackSize = 0;                                           //On garde la taille de la pile pour pouvoir la vider 

	    /****************FONCTIONS DEBUG****************/

	    private void printFinalDisplay(){
	      //Commentaires hashtag pour eviter erreur compilation de la stack machine
	      System.out.println("#mvapStackSize before freeing memory : " + mvapStackSize);
	      if(nbWarningsTotal > 0){
	        System.out.println("#>>> Found " + nbWarningsTotal + " total warnings in code <<<"); 
	        System.out.println("#>>> Found " + nbWarningsImplicitCast + " implicit cast warning in code <<<"); 
	      }
	      if(nbErrorsTotal > 0){
	        System.out.println("#!!! Found " + nbErrorsTotal + " total errors in code !!!"); 
	        System.out.println("#!!! Found " + nbErrorsAddress + " address errors in code !!!"); 
	        System.out.println("#!!! Found " + nbErrorsOperator + " operator errors in code !!!");
	        System.out.println("#!!! Found " + nbErrorsCondition + " condition errors in code !!!");
	        System.out.println("#!!! Found " + nbErrorsCast + " cast errors in code !!!"); 
	        System.out.println("#!!! Found " + nbErrorsAutoCast + " auto-cast errors in code !!!");
	      }else{
	        System.out.println("#Compilation successful !"); 
	      }
	    }

	    private void testEmptyStringErrors(String ... strings){
	      for(String s : strings){
	        if(s.isEmpty()){
	          nbErrorsEmptyString++;
	          System.err.println("-->ERROR empty string");
	          break;
	        }
	      }
	    }

	    private void testAddressNotFound(AdresseType at){
	      boolean noRightTypeTest = !(at.type.equals("int") || at.type.equals("float") || at.type.equals("bool") || at.type.equals("return"));
	      if(noRightTypeTest){
	        nbErrorsAddress++;
	        System.err.println("-->ERROR address, Address can't be found or is empty : [adress:" + at.adresse + ",type:" + at.type + "]");
	      }
	    }

	    private void triggerOperatorError(String op){
	      nbErrorsOperator++;
	      System.err.println("-->ERROR operator, found : " + op + ", expected : '+','-','*','/'");
	    }

	    private void triggerConditionError(String cond){
	      nbErrorsCondition++;
	      System.err.println("-->ERROR condition, found : " + cond + ", expected : '==','<=','>=','<','>','!='");
	    }

	    private void triggerCastError(String targetType){
	      nbErrorsCast++;
	      System.err.println("-->ERROR cast, found : " + targetType + ", expected : 'int','float','bool'");
	    }

	    private void triggerAutoCastError(String type, String type2){
	      nbErrorsAutoCast++;
	      System.err.println("-->ERROR auto-cast, found : [" + type + "," + type2 + "], expected : 'int','float','bool'");
	    }

	    private void triggerImplicitCastWarning(String type, String targetType){
	      nbWarningsImplicitCast++;
	      System.err.println("-->WARNING implicit cast, found : (" + type + "===>" + targetType + ")");
	    }

	    /****************FONCTIONS CAST****************/

	    //Renvoie le code pour un cast simple d'un type a un autre
	    private String tradOneElement(boolean implicit, String currentType, String targetType){ 
	      if(implicit){
	        triggerImplicitCastWarning(currentType, targetType);
	      }
	      String res = "";
	      if(currentType.equals(targetType)){     //Inutile si le type est deja du
	        return "";                            //meme type que le type cible
	      }
	      switch(targetType){
	        case "int":                           
	          if(currentType.equals("float")){    //Passage de float ===> int
	            res += "FTOI\n";
	            mvapStackSize -= 1;   
	          }
	          break;  
	        case "float":                         
	          res += "ITOF\n";                    //Passage de int ===> float
	          mvapStackSize += 1;
	          break;                             
	        case "bool":                          
	          String trueLabel = getNewLabel("true");
	          String falseLabel = getNewLabel("false");                           
	          String pushType;
	          String equalType;
	          if(currentType.equals("float")){    //Passage de float ===> bool
	            pushType = "PUSHF 0.0\n";
	            equalType = "FEQUAL\n"; 
	          }else{                              //Passage de int ===> bool
	            pushType = "PUSHI 0\n";
	            equalType = "EQUAL\n";
	          }   
	          res += pushType 
	              + equalType 
	              + "JUMPF " + trueLabel + "\n"
	              + "PUSHI 0\n" 
	              + "JUMP " + falseLabel + "\n"
	              + "LABEL " + trueLabel + "\n"
	              + "PUSHI 1\n" 
	              + "LABEL " + falseLabel + "\n";
	          mvapStackSize += 1;
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
	        mvapStackSize += 1;
	      }else if(type2.equals("float")){      //Passage de int + float ===> float
	        typeRes = "float";
	        mvapStackSize += 1;
	        exprRes.append(expr + "ITOF\n" + expr2);
	      }else{
	        triggerAutoCastError(type, type2);
	      }
	      return typeRes;
	    }

	    /****************FONCTIONS REFACTORING****************/

	    //Renvoie STOREG ou STOREL + l'adresse suivant le type de l'id
	    private String storeGOrL(String id){
	      String res = "";
	      AdresseType at = tablesSymboles.getAdresseType(id);        //Adresses positives : variables globales,
	      String storer = (at.adresse >= 0) ? "STOREG " : "STOREL "; //Adresses negatives : variables locales
	      boolean isIntOrBoolOrReturn = (at.type.equals("int") || at.type.equals("bool") || at.type.equals("return"));
	      if(isIntOrBoolOrReturn){
	        mvapStackSize -= 1;
	        res = storer + at.adresse + "\n";                         //Un store suffit pour les int et bool
	      }else{
	        mvapStackSize -= 2;
	        res = storer + (at.adresse + 1) + "\n"                    //Alors que les float ont besoin de deux
	            + storer + at.adresse + "\n";                         //places il faut donc store 2 elements dans l'ordre
	      }
	      return res;
	    }

	    //Renvoie PUSHG 0 ou PUSHL 0 suivant le type en entree
	    private String pushGOrL(String id){
	      String res = "";
	      AdresseType at = tablesSymboles.getAdresseType(id);       //Adresses positives : variables globales,
	      String pusher = (at.adresse >= 0) ? "PUSHG " : "PUSHL ";  //Adresses negatives : variables locales
	      boolean isIntOrBoolOrReturn = (at.type.equals("int") || at.type.equals("bool") || at.type.equals("return"));
	      if(isIntOrBoolOrReturn){
	        mvapStackSize += 1;
	        res = pusher 
	            + tablesSymboles.getAdresseType(id).adresse + "\n"; //Les int et bool ne prennent qu'une place dans la table
	      }else{
	        mvapStackSize += 2;
	        res = pusher 
	            + tablesSymboles.getAdresseType(id).adresse + "\n"  //Alors que les float ont besoin de deux place il faut donc
	            + pusher                                            //push deux fois
	            + (tablesSymboles.getAdresseType(id).adresse + 1) + "\n";
	      }
	      return res;
	    }

	    //Renvoie PUSHI ou PUSHF suivant le type en entree
	    private String pushIOrF(String type){
	      String res = "";
	      if(!type.equals("float")){
	        mvapStackSize += 1;
	        res = "PUSHI ";
	      }else{
	        mvapStackSize += 2;
	        res = "PUSHF ";
	      }
	      return res;
	    }

	    //Renvoie PUSHI 0 ou PUSHF 0.0 suivant le type en entree
	    private String pushIOrFZero(String type){
	      String res = "";
	      if(!type.equals("float")){
	        res = "PUSHI 0\n";
	        mvapStackSize += 1;
	      }else{
	        res = "PUSHF 0.0\n";
	        mvapStackSize += 2;
	      }
	      return res;
	    }

	    /****************FONCTIONS OPERATORS****************/

	    //Renvoie le code mvap pour chacune des operations possibles en prenant en compte le type
	    private String evalOp(String type, String op){
	      String res = "";
	      mvapStackSize -= 1;       //1 element en moins car les operations change 2 elements en 1 element
	      if(type.equals("float")){ //Si type float alors 
	        res += "F";             //FADD FSUB ... pour la stack machine*
	        mvapStackSize -= 1;     //1 element en moins dans la pile car float prend 2 places
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

	    //Renvoie le code approprier pour incrementer une variable
	    private String evalIncrement(String id, String incr){
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      testAddressNotFound(at);
	      testEmptyStringErrors(id, incr);
	      String pusher = pushGOrL(id);
	      String storer = storeGOrL(id);
	      String incrementer = "";
	      if(incr.equals("++")){                    
	        if(at.type.equals("float")){
	          incrementer = "PUSHF 1.0\nFADD\n";
	        }else{
	          incrementer = "PUSHI 1\nADD\n";
	        }  
	      }else if(incr.equals("--")){
	        if(at.type.equals("float")){
	          incrementer = "PUSHF 1.0\nFSUB\n";
	        }else{
	          incrementer = "PUSHI 1\nSUB\n";
	        }   
	      }
	      return pusher + incrementer + storer;
	    }

	    //Renvoie le code mvap pour chacune des conditions possibles
	    private String evalCond(String type, String expr1, String cond, String type2, String expr2){  
	      mvapStackSize -= 1;
	      String res = expr1 + expr2;
	      if(type.equals("float")){ //Si type float alors
	        res += "F";                                      //FEQUAL FINFEQ ... pour la stack machine
	        mvapStackSize -= 1;
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
	      String pusher = pushIOrFZero(type);
	      String content = expr;
	      String operator = evalOp(type, "-");
	      return pusher + content + operator;
	    }

	    /****************FONCTIONS DECLARATION ASSIGNATION****************/

	    //Renvoie le code pour une declaration simple suivant le type de l'id
	    private String evalDeclaration(String type, String id){  
	      tablesSymboles.putVar(id, type);
	      testEmptyStringErrors(type, id);
	      return pushIOrFZero(type); 
	    }

	    //Renvoie le code pour une declaration + assignation suivant le type de l'id
	    private String evalDeclarationExpr(String type, String id, String exprType, String expr){
	      tablesSymboles.putVar(id, type);  
	      AdresseType at = tablesSymboles.getAdresseType(id); 
	      testAddressNotFound(at);
	      testEmptyStringErrors(type, id, exprType, expr);
	      return expr;
	    }

	    //Renvoie le code pour une assignation suivant le type de l'id
	    private String evalAssign(String id, String exprType, String expr){ 
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      testAddressNotFound(at);
	      testEmptyStringErrors(id, exprType, expr);
	      return expr + tradOneElement(false, exprType, at.type) + storeGOrL(id);
	    }

	    /*******************FONCTIONS BOUCLES*******************/

	    //Fonction renvoyant le code mvap pour creer une boucle while
	    private String evalWhileLoop(String exprType, String expr, String instructions){ 
	      String startLabelW = getNewLabel("startWhile");                                     
	      String endLabelW = getNewLabel("endWhile");
	      System.err.println(exprType);
	      System.err.println(expr);
	      expr += tradOneElement(false, exprType, "bool");
	      mvapStackSize -= 1;
	      System.err.println("lol: "+expr);
	      testEmptyStringErrors(exprType, expr, instructions);
	      return "LABEL " + startLabelW + "\n" 
	             + expr 
	             + "JUMPF " + endLabelW + "\n"
	             + instructions 
	             + "JUMP " + startLabelW + "\n" 
	             + "LABEL " + endLabelW + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle for
	    private String evalForLoop(String init, String exprType, String expr, String iteration, String instructions){
	      System.err.println("exprt" + exprType);
	      String startLabelF = getNewLabel("startFor");                                                                    
	      String endLabelF = getNewLabel("endFor");
	      expr += tradOneElement(false, exprType, "bool");
	      mvapStackSize -= 1;
	      testEmptyStringErrors(init, exprType, expr, iteration, instructions);
	      return init 
	             + "LABEL " + startLabelF + "\n" 
	             + expr 
	             + "JUMPF " + endLabelF + "\n"
	             + instructions 
	             + iteration 
	             + "JUMP " + startLabelF + "\n" 
	             + "LABEL " + endLabelF + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle repeat until
	    private String evalRepeatLoop(String exprType, String expr, String instructions){                                                  
	      String startLabelR = getNewLabel("startRepeat");
	      String endLabelR = getNewLabel("endRepeat");
	      expr += tradOneElement(false, exprType, "bool"); 
	      mvapStackSize -= 1;
	      testEmptyStringErrors(exprType, expr, instructions);
	      return "LABEL " + startLabelR + "\n" 
	             + instructions 
	             + expr 
	             + "JUMPF " + startLabelR + "\n"
	             + "JUMP "+ endLabelR + "\n"
	             + "LABEL "+ endLabelR + "\n";
	    }

	    /*******************FONCTIONS INPUT OUTPUT*******************/

	    //Fonction renvoyant le code mvap pour utiliser read suivant le type de l'id
	    private String evalInput(String id){
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      String reader = "";
	      if(!at.type.equals("float")){
	        reader = "READ\n";
	        mvapStackSize += 1;
	      }else{
	        reader = "READF\n";
	        mvapStackSize += 2;
	      }
	      String storer = storeGOrL(id);
	      testAddressNotFound(at);
	      testEmptyStringErrors(id, reader, storer);
	      return reader + storer;
	    }

	    //Fonction renvoyant le code mvap pour utiliser write
	    private String evalOutput(String type){
	      testEmptyStringErrors(type);
	      String res = "";
	      if(!type.equals("float")){
	        res = "WRITE\nPOP\n";       //Un seul POP normal pour l'output
	        mvapStackSize -= 1;
	      }else{
	        res = "WRITEF\nPOP\nPOP\n"; //Double POP si c'est un float car les float 
	        mvapStackSize -= 2;         //prennent plus de place dans la stack machine
	      }                             
	      return res;
	    }                                      

	    /*******************FONCTIONS LOGIQUE*******************/

	    //Fonction renvoyant le code apres avoir tester
	    private String evalAnd(String expr1Type, String expr1, String expr2Type, String expr2){                  
	      String falseLabel1And = getNewLabel("false1And");
	      String trueLabel2And = getNewLabel("true2And");
	      expr1 += tradOneElement(false, expr1Type, "bool");
	      expr2 += tradOneElement(false, expr2Type, "bool"); 
	      testEmptyStringErrors(expr1Type, expr1, expr2Type, expr2);
	      return expr1 
	             + "JUMPF " + falseLabel1And + "\n" 
	             + expr2 
	             + "JUMP " + trueLabel2And + "\n"                    
	             + "LABEL " + falseLabel1And + "\n" 
	             + "PUSHI 0\n" 
	             + "LABEL " + trueLabel2And + "\n";
	    }

	    //Fonction renvoyant le code apres avoir tester
	    private String evalOr(String expr1Type, String expr1, String expr2Type, String expr2){                    
	      String falseLabel1Or = getNewLabel("false1Or");
	      String trueLabel1Or = getNewLabel("true1Or");
	      expr1 += tradOneElement(false, expr1Type, "bool");
	      expr2 += tradOneElement(false, expr2Type, "bool"); 
	      testEmptyStringErrors(expr1Type, expr1, expr2Type, expr2);
	      return expr1 
	             + "JUMPF " + falseLabel1Or + "\n" 
	             + "PUSHI 1\n" 
	             + "JUMP " + trueLabel1Or + "\n"
	             + "LABEL " + falseLabel1Or + "\n"
	             + expr2 
	             + "LABEL " + trueLabel1Or + "\n";
	    }

	    /*******************FONCTIONS BRANCHEMENTS*******************/

	    //Fonction renvoyant le code mvap lors d'un branchement if else
	    private String evalIfElse(String exprType, String expr, String ifInstructions, String elseInstructions){                                                                                 
	      String elseStartLabel = getNewLabel("startIfElse");                                                                   
	      String ifEndLabel = getNewLabel("endIfElse"); 
	      expr += tradOneElement(false, exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, ifInstructions, elseInstructions);
	      mvapStackSize -= 1;
	      return expr 
	             + "JUMPF " + elseStartLabel +"\n" 
	             + ifInstructions + "\n" 
	             + "JUMP " + ifEndLabel + "\n" 
	             + "LABEL " + elseStartLabel + "\n" 
	             + elseInstructions 
	             + "JUMP " + ifEndLabel + "\n"
	             + "LABEL " + ifEndLabel + "\n";
	    }

	    //Fonction renvoyant le code mvap pour un branchement compose d'un seul if
	    private String evalIf(String exprType, String expr, String ifInstructions){      
	      String ifEndLabel = getNewLabel("ifOnly");                                           
	      expr += tradOneElement(false, exprType, "bool"); 
	      testEmptyStringErrors(exprType, expr, ifInstructions);  
	      mvapStackSize -= 1;                                                   
	      return expr 
	             + "JUMPF " + ifEndLabel + "\n" 
	             + ifInstructions 
	             + "JUMP " + ifEndLabel + "\n"
	             + "LABEL " + ifEndLabel + "\n";
	    }

	    /*******************FONCTION RETURN*******************/

	    //Fonction renvoyant le code mvap pour les return
	    private String evalReturn(String exprType, String expr){
	      AdresseType at = tablesSymboles.getAdresseType("return");
	      testAddressNotFound(at);
	      testEmptyStringErrors(exprType, expr);
	      expr += tradOneElement(false, exprType, at.type);
	      String storer = "";
	      if(at.type.equals("float")){
	        storer = "STOREL " + (at.adresse + 1) + "\n"
	               + "STOREL " + at.adresse + "\n";
	        mvapStackSize -= 4; //2 store et un return float
	      }else{
	        storer = "STOREL " + at.adresse + "\n";
	        mvapStackSize -= 3;
	      }
	      return expr 
	             + storer
	             + "RETURN\n";
	    }      

	    private String evalFunctionCall(String type, String id, int nbArgs, String args){
	      String res = "";
	      String pusher = "";
	      if(!type.equals("float")){                    //Push un nombre random pour memoire float ou int
	        pusher = "PUSHI 0\n";
	        mvapStackSize += 3;
	      }else{
	        pusher = "PUSHF 0.0\n";
	        mvapStackSize += 4;                         //PUSHF 2 + CALL float 2
	      }
	      if(nbArgs > 0){                               //Si il y a des arguments
	        res = pusher
	            + args 
	            + "CALL " + id + "\n";                  //Ajout du code des arguments et du CALL mvap
	        for (int i = 0; i < nbArgs; i++){           //On pop tous les arguments lors du CALL      
	            res += "POP\n";
	            mvapStackSize -= 1;
	        }
	      }else{                                        //Si pas d'arguments
	        res = pusher 
	            + "CALL " + id + "\n";                  //Ajout du code et du CALL mvap
	      }
	      return res;    
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u0152\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00c3\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\5\26\u00d1\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u00ea\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u00f8\n\36\3\37\6\37\u00fb\n\37\r\37\16\37\u00fc\3 \6"+
		" \u0100\n \r \16 \u0101\3 \3 \7 \u0106\n \f \16 \u0109\13 \3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\5!\u0114\n!\3\"\6\"\u0117\n\"\r\"\16\"\u0118\3\"\7\""+
		"\u011c\n\"\f\"\16\"\u011f\13\"\3#\5#\u0122\n#\3#\3#\3$\6$\u0127\n$\r$"+
		"\16$\u0128\3$\3$\3%\3%\3%\3%\7%\u0131\n%\f%\16%\u0134\13%\3%\3%\3%\3%"+
		"\3%\3&\3&\3&\3&\7&\u013f\n&\f&\16&\u0142\13&\3&\3&\3\'\3\'\7\'\u0148\n"+
		"\'\f\'\16\'\u014b\13\'\3\'\3\'\3(\3(\3(\3(\3\u0132\2)\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)\3\2\6\4\2>>@@\4\2C\\c|\4\2\13\13\"\"\4\2\f\f\17\17\2\u016c\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3"+
		"\2\2\2\tZ\3\2\2\2\13`\3\2\2\2\rb\3\2\2\2\17d\3\2\2\2\21g\3\2\2\2\23l\3"+
		"\2\2\2\25r\3\2\2\2\27v\3\2\2\2\31}\3\2\2\2\33\u0083\3\2\2\2\35\u0088\3"+
		"\2\2\2\37\u008e\3\2\2\2!\u00c2\3\2\2\2#\u00c4\3\2\2\2%\u00c6\3\2\2\2\'"+
		"\u00c8\3\2\2\2)\u00ca\3\2\2\2+\u00d0\3\2\2\2-\u00d2\3\2\2\2/\u00d4\3\2"+
		"\2\2\61\u00d6\3\2\2\2\63\u00d8\3\2\2\2\65\u00db\3\2\2\2\67\u00de\3\2\2"+
		"\29\u00e9\3\2\2\2;\u00f7\3\2\2\2=\u00fa\3\2\2\2?\u00ff\3\2\2\2A\u0113"+
		"\3\2\2\2C\u0116\3\2\2\2E\u0121\3\2\2\2G\u0126\3\2\2\2I\u012c\3\2\2\2K"+
		"\u013a\3\2\2\2M\u0145\3\2\2\2O\u014e\3\2\2\2QR\7}\2\2R\4\3\2\2\2ST\7\177"+
		"\2\2T\6\3\2\2\2UV\7v\2\2VW\7t\2\2WX\7w\2\2XY\7g\2\2Y\b\3\2\2\2Z[\7h\2"+
		"\2[\\\7c\2\2\\]\7n\2\2]^\7u\2\2^_\7g\2\2_\n\3\2\2\2`a\7*\2\2a\f\3\2\2"+
		"\2bc\7+\2\2c\16\3\2\2\2de\7k\2\2ef\7h\2\2f\20\3\2\2\2gh\7g\2\2hi\7n\2"+
		"\2ij\7u\2\2jk\7g\2\2k\22\3\2\2\2lm\7y\2\2mn\7j\2\2no\7k\2\2op\7n\2\2p"+
		"q\7g\2\2q\24\3\2\2\2rs\7h\2\2st\7q\2\2tu\7t\2\2u\26\3\2\2\2vw\7t\2\2w"+
		"x\7g\2\2xy\7r\2\2yz\7g\2\2z{\7c\2\2{|\7v\2\2|\30\3\2\2\2}~\7w\2\2~\177"+
		"\7p\2\2\177\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7n\2\2\u0082\32"+
		"\3\2\2\2\u0083\u0084\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086\7c\2\2\u0086"+
		"\u0087\7f\2\2\u0087\34\3\2\2\2\u0088\u0089\7y\2\2\u0089\u008a\7t\2\2\u008a"+
		"\u008b\7k\2\2\u008b\u008c\7v\2\2\u008c\u008d\7g\2\2\u008d\36\3\2\2\2\u008e"+
		"\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7v\2\2\u0091\u0092\7w\2\2"+
		"\u0092\u0093\7t\2\2\u0093\u0094\7p\2\2\u0094 \3\2\2\2\u0095\u0096\7k\2"+
		"\2\u0096\u00c3\7h\2\2\u0097\u0098\7g\2\2\u0098\u0099\7n\2\2\u0099\u009a"+
		"\7u\2\2\u009a\u00c3\7g\2\2\u009b\u009c\7d\2\2\u009c\u009d\7t\2\2\u009d"+
		"\u009e\7g\2\2\u009e\u009f\7c\2\2\u009f\u00c3\7m\2\2\u00a0\u00a1\7y\2\2"+
		"\u00a1\u00a2\7j\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7n\2\2\u00a4\u00c3"+
		"\7g\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7\7q\2\2\u00a7\u00c3\7t\2\2\u00a8"+
		"\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7r\2\2\u00ab\u00ac\7g\2\2"+
		"\u00ac\u00ad\7c\2\2\u00ad\u00c3\7v\2\2\u00ae\u00af\7w\2\2\u00af\u00b0"+
		"\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7k\2\2\u00b2\u00c3\7n\2\2\u00b3"+
		"\u00b4\7y\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7v\2\2"+
		"\u00b7\u00c3\7g\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb"+
		"\7c\2\2\u00bb\u00c3\7f\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be"+
		"\u00bf\7v\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c3\7p\2\2"+
		"\u00c2\u0095\3\2\2\2\u00c2\u0097\3\2\2\2\u00c2\u009b\3\2\2\2\u00c2\u00a0"+
		"\3\2\2\2\u00c2\u00a5\3\2\2\2\u00c2\u00a8\3\2\2\2\u00c2\u00ae\3\2\2\2\u00c2"+
		"\u00b3\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c3\"\3\2\2\2"+
		"\u00c4\u00c5\7-\2\2\u00c5$\3\2\2\2\u00c6\u00c7\7/\2\2\u00c7&\3\2\2\2\u00c8"+
		"\u00c9\7,\2\2\u00c9(\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb*\3\2\2\2\u00cc"+
		"\u00cd\7-\2\2\u00cd\u00d1\7-\2\2\u00ce\u00cf\7/\2\2\u00cf\u00d1\7/\2\2"+
		"\u00d0\u00cc\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1,\3\2\2\2\u00d2\u00d3\7"+
		"?\2\2\u00d3.\3\2\2\2\u00d4\u00d5\7.\2\2\u00d5\60\3\2\2\2\u00d6\u00d7\7"+
		"=\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\7(\2\2\u00d9\u00da\7(\2\2\u00da\64"+
		"\3\2\2\2\u00db\u00dc\7~\2\2\u00dc\u00dd\7~\2\2\u00dd\66\3\2\2\2\u00de"+
		"\u00df\7#\2\2\u00df8\3\2\2\2\u00e0\u00e1\7?\2\2\u00e1\u00ea\7?\2\2\u00e2"+
		"\u00ea\t\2\2\2\u00e3\u00e4\7>\2\2\u00e4\u00ea\7?\2\2\u00e5\u00e6\7@\2"+
		"\2\u00e6\u00ea\7?\2\2\u00e7\u00e8\7#\2\2\u00e8\u00ea\7?\2\2\u00e9\u00e0"+
		"\3\2\2\2\u00e9\u00e2\3\2\2\2\u00e9\u00e3\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea:\3\2\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed"+
		"\u00f8\7v\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0\7n\2\2\u00f0\u00f1\7q\2\2"+
		"\u00f1\u00f2\7c\2\2\u00f2\u00f8\7v\2\2\u00f3\u00f4\7d\2\2\u00f4\u00f5"+
		"\7q\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f8\7n\2\2\u00f7\u00eb\3\2\2\2\u00f7"+
		"\u00ee\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f8<\3\2\2\2\u00f9\u00fb\4\62;\2"+
		"\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd>\3\2\2\2\u00fe\u0100\4\62;\2\u00ff\u00fe\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0107\7\60\2\2\u0104\u0106\4\62;\2\u0105\u0104\3\2\2\2\u0106"+
		"\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108@\3\2\2\2"+
		"\u0109\u0107\3\2\2\2\u010a\u010b\7v\2\2\u010b\u010c\7t\2\2\u010c\u010d"+
		"\7w\2\2\u010d\u0114\7g\2\2\u010e\u010f\7h\2\2\u010f\u0110\7c\2\2\u0110"+
		"\u0111\7n\2\2\u0111\u0112\7u\2\2\u0112\u0114\7g\2\2\u0113\u010a\3\2\2"+
		"\2\u0113\u010e\3\2\2\2\u0114B\3\2\2\2\u0115\u0117\t\3\2\2\u0116\u0115"+
		"\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011d\3\2\2\2\u011a\u011c\4\62;\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011eD\3\2\2\2\u011f\u011d"+
		"\3\2\2\2\u0120\u0122\7\17\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0124\7\f\2\2\u0124F\3\2\2\2\u0125\u0127\t"+
		"\4\2\2\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\b$\2\2\u012bH\3\2\2\2\u012c"+
		"\u012d\7\61\2\2\u012d\u012e\7,\2\2\u012e\u0132\3\2\2\2\u012f\u0131\13"+
		"\2\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0133\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7,"+
		"\2\2\u0136\u0137\7\61\2\2\u0137\u0138\3\2\2\2\u0138\u0139\b%\2\2\u0139"+
		"J\3\2\2\2\u013a\u013b\7\61\2\2\u013b\u013c\7\61\2\2\u013c\u0140\3\2\2"+
		"\2\u013d\u013f\n\5\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143"+
		"\u0144\b&\2\2\u0144L\3\2\2\2\u0145\u0149\7%\2\2\u0146\u0148\n\5\2\2\u0147"+
		"\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2"+
		"\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\b\'\2\2\u014d"+
		"N\3\2\2\2\u014e\u014f\13\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\b(\2\2"+
		"\u0151P\3\2\2\2\22\2\u00c2\u00d0\u00e9\u00f7\u00fc\u0101\u0107\u0113\u0118"+
		"\u011d\u0121\u0128\u0132\u0140\u0149\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}