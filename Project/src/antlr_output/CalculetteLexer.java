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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, KEYWORDS=23, EXPRLOG=24, 
		COND=25, TYPE=26, ENTIER=27, FLOAT=28, BOOL=29, IDENTIFIANT=30, NEWLINE=31, 
		WS=32, UNMATCH=33;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "KEYWORDS", "EXPRLOG", "COND", 
			"TYPE", "ENTIER", "FLOAT", "BOOL", "IDENTIFIANT", "NEWLINE", "WS", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00ff\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00a9\n\30"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u00b0\n\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u00bb\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u00c5\n\33\3\34\6\34\u00c8\n\34\r\34\16\34\u00c9\3\35\6\35\u00cd"+
		"\n\35\r\35\16\35\u00ce\3\35\3\35\7\35\u00d3\n\35\f\35\16\35\u00d6\13\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00e1\n\36\3\37\6\37"+
		"\u00e4\n\37\r\37\16\37\u00e5\3\37\7\37\u00e9\n\37\f\37\16\37\u00ec\13"+
		"\37\3 \5 \u00ef\n \3 \3 \3 \3 \3!\6!\u00f6\n!\r!\16!\u00f7\3!\3!\3\"\3"+
		"\"\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#\3\2\5\4\2>>@@\4\2C\\c|\4\2\13\13\"\"\2\u010f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2"+
		"\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2\17Q\3\2\2\2\21S\3\2\2"+
		"\2\23U\3\2\2\2\25Y\3\2\2\2\27^\3\2\2\2\31d\3\2\2\2\33k\3\2\2\2\35r\3\2"+
		"\2\2\37w\3\2\2\2!y\3\2\2\2#\u0080\3\2\2\2%\u0087\3\2\2\2\'\u008c\3\2\2"+
		"\2)\u0092\3\2\2\2+\u0094\3\2\2\2-\u0096\3\2\2\2/\u00a8\3\2\2\2\61\u00af"+
		"\3\2\2\2\63\u00ba\3\2\2\2\65\u00c4\3\2\2\2\67\u00c7\3\2\2\29\u00cc\3\2"+
		"\2\2;\u00e0\3\2\2\2=\u00e3\3\2\2\2?\u00ee\3\2\2\2A\u00f5\3\2\2\2C\u00fb"+
		"\3\2\2\2EF\7}\2\2F\4\3\2\2\2GH\7\177\2\2H\6\3\2\2\2IJ\7*\2\2J\b\3\2\2"+
		"\2KL\7+\2\2L\n\3\2\2\2MN\7,\2\2N\f\3\2\2\2OP\7\61\2\2P\16\3\2\2\2QR\7"+
		"-\2\2R\20\3\2\2\2ST\7/\2\2T\22\3\2\2\2UV\7k\2\2VW\7h\2\2WX\7*\2\2X\24"+
		"\3\2\2\2YZ\7g\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2]\26\3\2\2\2^_\7t\2\2_`"+
		"\7g\2\2`a\7c\2\2ab\7f\2\2bc\7*\2\2c\30\3\2\2\2de\7y\2\2ef\7t\2\2fg\7k"+
		"\2\2gh\7v\2\2hi\7g\2\2ij\7*\2\2j\32\3\2\2\2kl\7y\2\2lm\7j\2\2mn\7k\2\2"+
		"no\7n\2\2op\7g\2\2pq\7*\2\2q\34\3\2\2\2rs\7h\2\2st\7q\2\2tu\7t\2\2uv\7"+
		"*\2\2v\36\3\2\2\2wx\7=\2\2x \3\2\2\2yz\7t\2\2z{\7g\2\2{|\7r\2\2|}\7g\2"+
		"\2}~\7c\2\2~\177\7v\2\2\177\"\3\2\2\2\u0080\u0081\7w\2\2\u0081\u0082\7"+
		"p\2\2\u0082\u0083\7v\2\2\u0083\u0084\7k\2\2\u0084\u0085\7n\2\2\u0085\u0086"+
		"\7*\2\2\u0086$\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089\u008a"+
		"\7w\2\2\u008a\u008b\7g\2\2\u008b&\3\2\2\2\u008c\u008d\7h\2\2\u008d\u008e"+
		"\7c\2\2\u008e\u008f\7n\2\2\u008f\u0090\7u\2\2\u0090\u0091\7g\2\2\u0091"+
		"(\3\2\2\2\u0092\u0093\7?\2\2\u0093*\3\2\2\2\u0094\u0095\7.\2\2\u0095,"+
		"\3\2\2\2\u0096\u0097\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099"+
		"\u009a\7w\2\2\u009a\u009b\7t\2\2\u009b\u009c\7p\2\2\u009c.\3\2\2\2\u009d"+
		"\u009e\7k\2\2\u009e\u00a9\7h\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7n\2\2"+
		"\u00a1\u00a2\7u\2\2\u00a2\u00a9\7g\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5"+
		"\7t\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a9\7m\2\2\u00a8"+
		"\u009d\3\2\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9\60\3\2\2"+
		"\2\u00aa\u00ab\7(\2\2\u00ab\u00b0\7(\2\2\u00ac\u00ad\7~\2\2\u00ad\u00b0"+
		"\7~\2\2\u00ae\u00b0\7#\2\2\u00af\u00aa\3\2\2\2\u00af\u00ac\3\2\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\u00bb\7?\2\2"+
		"\u00b3\u00bb\t\2\2\2\u00b4\u00b5\7>\2\2\u00b5\u00bb\7?\2\2\u00b6\u00b7"+
		"\7@\2\2\u00b7\u00bb\7?\2\2\u00b8\u00b9\7#\2\2\u00b9\u00bb\7?\2\2\u00ba"+
		"\u00b1\3\2\2\2\u00ba\u00b3\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b6\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\64\3\2\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be"+
		"\7p\2\2\u00be\u00c5\7v\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7n\2\2\u00c1"+
		"\u00c2\7q\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c5\7v\2\2\u00c4\u00bc\3\2\2"+
		"\2\u00c4\u00bf\3\2\2\2\u00c5\66\3\2\2\2\u00c6\u00c8\4\62;\2\u00c7\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"8\3\2\2\2\u00cb\u00cd\4\62;\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2"+
		"\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d4"+
		"\7\60\2\2\u00d1\u00d3\4\62;\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5:\3\2\2\2\u00d6\u00d4\3"+
		"\2\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7w\2\2\u00da"+
		"\u00e1\7g\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de\7n\2\2"+
		"\u00de\u00df\7u\2\2\u00df\u00e1\7g\2\2\u00e0\u00d7\3\2\2\2\u00e0\u00db"+
		"\3\2\2\2\u00e1<\3\2\2\2\u00e2\u00e4\t\3\2\2\u00e3\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00ea\3\2"+
		"\2\2\u00e7\u00e9\4\62;\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb>\3\2\2\2\u00ec\u00ea\3\2\2\2"+
		"\u00ed\u00ef\7\17\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f1\7\f\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b \2\2\u00f3"+
		"@\3\2\2\2\u00f4\u00f6\t\4\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa"+
		"\b!\2\2\u00faB\3\2\2\2\u00fb\u00fc\13\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\b\"\2\2\u00feD\3\2\2\2\17\2\u00a8\u00af\u00ba\u00c4\u00c9\u00ce"+
		"\u00d4\u00e0\u00e5\u00ea\u00ee\u00f7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}