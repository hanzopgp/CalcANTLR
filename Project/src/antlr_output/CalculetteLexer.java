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
		IDENTIFIANT=32, NEWLINE=33, WS=34, UNMATCH=35;
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
			"NEWLINE", "WS", "UNMATCH"
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
			"IDENTIFIANT", "NEWLINE", "WS", "UNMATCH"
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
	    private int _cur_label = 1;                                   //liens var/type et les valeurs dans les adresses
	    private String getNewLabel() { return "B" +(_cur_label++); }  //Generateur de nom d'etiquettes pour les boucles                                

	    //Renvoie le code pour un cast simple d'un type a un autre
	    private String trad(String currentType, String currentExpr, String targetType){ 
	      String res = currentExpr;
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
	          if(currentType.equals("float")){   //Passage de float ===> bool
	            pushType = "PUSHF 0\n";
	            equalType = "FEQUAL\n";
	          }else{                             //Passage de int ===> bool
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

	    //Modifie 2 objets String pour recuperer le code des deux entrees mises au meme type
	    private void tradTwo(String type, String expr, String type2, String expr2, String typeRes, String exprRes){
	      if(type.equals(type2)){               //Operation sur deux expressions de meme type
	        typeRes = type;
	        exprRes = expr + expr2;
	      }else if(type.equals("float")){       //Passage de float + int ===> float
	        typeRes = "float";
	        exprRes = expr + expr2 + "ITOF\n";
	      }else if(type2.equals("float")){      //Passage de int + float ===> float
	        typeRes = "float";
	        exprRes = expr + "ITOF\n" + expr2;
	      }
	    }

	    //Renvoie le code pour une declaration simple
	    private String evalDeclaration(String type, String id){  
	      tablesSymboles.putVar(id, type);
	      return ((type.equals("int") || type.equals("bool")) ? "PUSHI 0\n" : "PUSHF 0.0\n"); 
	    }

	    //Renvoie le code pour une declaration assignation
	    private String evalDeclarationExpr(String type, String id, String expr, String exprType){
	      tablesSymboles.putVar(id, type);  
	      AdresseType at = tablesSymboles.getAdresseType(id); 
	      return ((type.equals("int") || type.equals("bool")) ? "PUSHI 0\n" : "PUSHF 0.0\n")
	             + trad(exprType, expr, at.type) + "STOREG "  + at.adresse + "\n";
	    }

	    //Renvoie le code pour une assignation
	    private String evalAssign(String id, String expr, String exprType){ 
	      AdresseType at = tablesSymboles.getAdresseType(id);
	      return trad(exprType, expr, at.type) + "STOREG " + at.adresse + "\n";
	    }

	    //Renvoie le code mvap pour chacune des conditions possibles
	    private String evalCond(String exp1, String cond, String exp2){  
	      String res = exp1 + exp2;                                     
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

	    //Fonction renvoyant le code mvap pour creer une boucle while
	    private String evalWhileLoop(String expr, String exprType, String block){ 
	      String startLabelW = getNewLabel();                                     
	      String endLabelW = getNewLabel();
	      String tradExpr = trad(exprType, expr, "bool");
	      return "LABEL " + startLabelW + "\n" + tradExpr + "JUMPF " + endLabelW + "\n"
	             + block + "JUMP " + startLabelW + "\n" + "LABEL " + endLabelW + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle for
	    private String evalForLoop(String init, String expr, String exprType, String iteration, String block){  
	      String startLabelF = getNewLabel();                                                                    
	      String endLabelF = getNewLabel();
	      String tradExpr = trad(exprType, expr, "bool");
	      return init + "LABEL " + startLabelF + "\n" + tradExpr + "JUMPF " + endLabelF + "\n"
	             + block + iteration + "JUMP " + startLabelF + "\n" + "LABEL " + endLabelF + "\n";
	    }

	    //Fonction renvoyant le code mvap pour creer une boucle repeat until
	    private String evalRepeatLoop(String expr, String exprType, String block){                                                  
	      String startLabelR = getNewLabel();
	      String tradExpr = trad(exprType, expr, "bool"); 
	      return "LABEL " + startLabelR + "\n" + block 
	             + tradExpr + "\n" + "JUMPF " + startLabelR + "\n";
	    }

	     //Fonction renvoyant le code apres avoir tester
	    private String evalAnd(String expr1Type, String expr1, String expr2Type, String expr2){                  
	      String falseLabel1And = getNewLabel();
	      String trueLabel2And = getNewLabel();
	      expr1 = trad(expr1Type, expr1, "bool");
	      expr2 = trad(expr2Type, expr2, "bool"); 
	      return expr1 + "JUMPF " + falseLabel1And + "\n" + expr2 + "JUMP " + trueLabel2And + "\n"                    
	              + "LABEL " + falseLabel1And + "\n" + "PUSHI 0\n" + "LABEL " + trueLabel2And + "\n";
	    }

	    //Fonction renvoyant le code apres avoir tester
	    private String evalOr(String expr1Type, String expr1, String expr2Type, String expr2){                    
	      String falseLabel1Or = getNewLabel();
	      String trueLabel1Or = getNewLabel();
	      expr1 = trad(expr1Type, expr1, "bool");
	      expr2 = trad(expr2Type, expr2, "bool"); 
	      return expr1 + "JUMPF " + falseLabel1Or + "\n" + "PUSHI 1\n" + "JUMP " + trueLabel1Or + "\n"
	             + "LABEL " + falseLabel1Or + expr2 + "LABEL " + trueLabel1Or + "\n";
	    }

	    //Fonction renvoyant le code mvap lors d'un branchement if else
	    private String evalIfElse(String expr, String exprType, String ifBlock, String elseBlock){                                                                                 
	      String elseStartLabel = getNewLabel();                                                                   
	      String ifEndLabel = getNewLabel(); 
	      String tradExpr = trad(exprType, expr, "bool"); 
	      return tradExpr + "\n" + "JUMPF " + elseStartLabel +"\n" 
	             + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
	             + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
	    }

	    //Fonction renvoyant le code mvap pour un branchement compose d'un seul if
	    private String evalIf(String expr, String exprType, String ifBlock){      
	      String ifEndLabel = getNewLabel();                                           
	      String tradExpr = trad(exprType, expr, "bool");                                                      
	      return tradExpr + "\n" + "JUMPF " + ifEndLabel 
	             + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
	    }

	    //Fonction renvoyant le code mvap pour les return
	    private String evalReturn(String expr, String exprType){
	      AdresseType at = tablesSymboles.getAdresseType("return");
	      return trad(expr, exprType, at.type)
	             + "STOREG " + at.adresse + "\n" + "RETURN\n";
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0134\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00e1\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00ec\n\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fa\n\35\3\36\6\36"+
		"\u00fd\n\36\r\36\16\36\u00fe\3\37\6\37\u0102\n\37\r\37\16\37\u0103\3\37"+
		"\3\37\7\37\u0108\n\37\f\37\16\37\u010b\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \5 \u0116\n \3!\6!\u0119\n!\r!\16!\u011a\3!\7!\u011e\n!\f!\16!\u0121"+
		"\13!\3\"\5\"\u0124\n\"\3\"\3\"\3\"\3\"\3#\6#\u012b\n#\r#\16#\u012c\3#"+
		"\3#\3$\3$\3$\3$\2\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%\3\2\5\4\2>>@@\4\2C\\c|\4\2\13\13\"\""+
		"\2\u014c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13Q\3\2\2\2\r"+
		"S\3\2\2\2\17X\3\2\2\2\21^\3\2\2\2\23a\3\2\2\2\25d\3\2\2\2\27f\3\2\2\2"+
		"\31h\3\2\2\2\33j\3\2\2\2\35l\3\2\2\2\37n\3\2\2\2!r\3\2\2\2#w\3\2\2\2%"+
		"~\3\2\2\2\'\u0083\3\2\2\2)\u0085\3\2\2\2+\u008c\3\2\2\2-\u0093\3\2\2\2"+
		"/\u0099\3\2\2\2\61\u00a0\3\2\2\2\63\u00a2\3\2\2\2\65\u00e0\3\2\2\2\67"+
		"\u00eb\3\2\2\29\u00f9\3\2\2\2;\u00fc\3\2\2\2=\u0101\3\2\2\2?\u0115\3\2"+
		"\2\2A\u0118\3\2\2\2C\u0123\3\2\2\2E\u012a\3\2\2\2G\u0130\3\2\2\2IJ\7}"+
		"\2\2J\4\3\2\2\2KL\7\177\2\2L\6\3\2\2\2MN\7?\2\2N\b\3\2\2\2OP\7-\2\2P\n"+
		"\3\2\2\2QR\7/\2\2R\f\3\2\2\2ST\7v\2\2TU\7t\2\2UV\7w\2\2VW\7g\2\2W\16\3"+
		"\2\2\2XY\7h\2\2YZ\7c\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2]\20\3\2\2\2^_\7"+
		"(\2\2_`\7(\2\2`\22\3\2\2\2ab\7~\2\2bc\7~\2\2c\24\3\2\2\2de\7,\2\2e\26"+
		"\3\2\2\2fg\7\61\2\2g\30\3\2\2\2hi\7*\2\2i\32\3\2\2\2jk\7+\2\2k\34\3\2"+
		"\2\2lm\7#\2\2m\36\3\2\2\2no\7k\2\2op\7h\2\2pq\7*\2\2q \3\2\2\2rs\7g\2"+
		"\2st\7n\2\2tu\7u\2\2uv\7g\2\2v\"\3\2\2\2wx\7y\2\2xy\7j\2\2yz\7k\2\2z{"+
		"\7n\2\2{|\7g\2\2|}\7*\2\2}$\3\2\2\2~\177\7h\2\2\177\u0080\7q\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7*\2\2\u0082&\3\2\2\2\u0083\u0084\7=\2\2\u0084"+
		"(\3\2\2\2\u0085\u0086\7t\2\2\u0086\u0087\7g\2\2\u0087\u0088\7r\2\2\u0088"+
		"\u0089\7g\2\2\u0089\u008a\7c\2\2\u008a\u008b\7v\2\2\u008b*\3\2\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\u0090\7k\2\2"+
		"\u0090\u0091\7n\2\2\u0091\u0092\7*\2\2\u0092,\3\2\2\2\u0093\u0094\7t\2"+
		"\2\u0094\u0095\7g\2\2\u0095\u0096\7c\2\2\u0096\u0097\7f\2\2\u0097\u0098"+
		"\7*\2\2\u0098.\3\2\2\2\u0099\u009a\7y\2\2\u009a\u009b\7t\2\2\u009b\u009c"+
		"\7k\2\2\u009c\u009d\7v\2\2\u009d\u009e\7g\2\2\u009e\u009f\7*\2\2\u009f"+
		"\60\3\2\2\2\u00a0\u00a1\7.\2\2\u00a1\62\3\2\2\2\u00a2\u00a3\7t\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7t\2\2"+
		"\u00a7\u00a8\7p\2\2\u00a8\64\3\2\2\2\u00a9\u00aa\7k\2\2\u00aa\u00e1\7"+
		"h\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae\u00e1"+
		"\7g\2\2\u00af\u00b0\7d\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"\u00b3\7c\2\2\u00b3\u00e1\7m\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7j\2\2"+
		"\u00b6\u00b7\7k\2\2\u00b7\u00b8\7n\2\2\u00b8\u00e1\7g\2\2\u00b9\u00ba"+
		"\7h\2\2\u00ba\u00bb\7q\2\2\u00bb\u00e1\7t\2\2\u00bc\u00bd\7f\2\2\u00bd"+
		"\u00e1\7q\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7r\2\2"+
		"\u00c1\u00c2\7g\2\2\u00c2\u00c3\7c\2\2\u00c3\u00e1\7v\2\2\u00c4\u00c5"+
		"\7w\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7k\2\2\u00c8"+
		"\u00e1\7n\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7p\2\2"+
		"\u00cc\u00cd\7e\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0"+
		"\7q\2\2\u00d0\u00e1\7p\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7g\2\2\u00d3"+
		"\u00d4\7v\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7t\2\2\u00d6\u00e1\7p\2\2"+
		"\u00d7\u00d8\7y\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7k\2\2\u00da\u00db"+
		"\7v\2\2\u00db\u00e1\7g\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7g\2\2\u00de"+
		"\u00df\7c\2\2\u00df\u00e1\7f\2\2\u00e0\u00a9\3\2\2\2\u00e0\u00ab\3\2\2"+
		"\2\u00e0\u00af\3\2\2\2\u00e0\u00b4\3\2\2\2\u00e0\u00b9\3\2\2\2\u00e0\u00bc"+
		"\3\2\2\2\u00e0\u00be\3\2\2\2\u00e0\u00c4\3\2\2\2\u00e0\u00c9\3\2\2\2\u00e0"+
		"\u00d1\3\2\2\2\u00e0\u00d7\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\66\3\2\2"+
		"\2\u00e2\u00e3\7?\2\2\u00e3\u00ec\7?\2\2\u00e4\u00ec\t\2\2\2\u00e5\u00e6"+
		"\7>\2\2\u00e6\u00ec\7?\2\2\u00e7\u00e8\7@\2\2\u00e8\u00ec\7?\2\2\u00e9"+
		"\u00ea\7#\2\2\u00ea\u00ec\7?\2\2\u00eb\u00e2\3\2\2\2\u00eb\u00e4\3\2\2"+
		"\2\u00eb\u00e5\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec8"+
		"\3\2\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7p\2\2\u00ef\u00fa\7v\2\2\u00f0"+
		"\u00f1\7h\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7c\2\2"+
		"\u00f4\u00fa\7v\2\2\u00f5\u00f6\7d\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8"+
		"\7q\2\2\u00f8\u00fa\7n\2\2\u00f9\u00ed\3\2\2\2\u00f9\u00f0\3\2\2\2\u00f9"+
		"\u00f5\3\2\2\2\u00fa:\3\2\2\2\u00fb\u00fd\4\62;\2\u00fc\u00fb\3\2\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff<\3"+
		"\2\2\2\u0100\u0102\4\62;\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0109\7\60"+
		"\2\2\u0106\u0108\4\62;\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a>\3\2\2\2\u010b\u0109\3\2\2\2"+
		"\u010c\u010d\7v\2\2\u010d\u010e\7t\2\2\u010e\u010f\7w\2\2\u010f\u0116"+
		"\7g\2\2\u0110\u0111\7h\2\2\u0111\u0112\7c\2\2\u0112\u0113\7n\2\2\u0113"+
		"\u0114\7u\2\2\u0114\u0116\7g\2\2\u0115\u010c\3\2\2\2\u0115\u0110\3\2\2"+
		"\2\u0116@\3\2\2\2\u0117\u0119\t\3\2\2\u0118\u0117\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011f\3\2\2\2\u011c"+
		"\u011e\4\62;\2\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120B\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0124"+
		"\7\17\2\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2"+
		"\u0125\u0126\7\f\2\2\u0126\u0127\3\2\2\2\u0127\u0128\b\"\2\2\u0128D\3"+
		"\2\2\2\u0129\u012b\t\4\2\2\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\b#"+
		"\2\2\u012fF\3\2\2\2\u0130\u0131\13\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133"+
		"\b$\2\2\u0133H\3\2\2\2\16\2\u00e0\u00eb\u00f9\u00fe\u0103\u0109\u0115"+
		"\u011a\u011f\u0123\u012c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}