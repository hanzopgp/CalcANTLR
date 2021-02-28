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
		EXPRLOG=18, COND=19, TYPE=20, NEWLINE=21, WS=22, ENTIER=23, FLOAT=24, 
		IDENTIFIANT=25, UNMATCH=26;
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
			"EXPRLOG", "COND", "TYPE", "NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", 
			"UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'if('", 
			"'else'", "'read('", "'write('", "'while('", "'true'", "'false'", "'='", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "EXPRLOG", "COND", "TYPE", "NEWLINE", 
			"WS", "ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
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

	    public String evalIfElse(String condition, String ifBlock, String elseBlock){                 //Fonction renvoyant le code pour gerer les                                                                
	      String endLabel = getNewLabel();                                                            //if else avec condition
	      String startLabelIf = getNewLabel();                                                          
	      String endLabelIf = getNewLabel();
	      String startLabelElse = getNewLabel();                                                          
	      String endLabelElse = getNewLabel();
	      String res = "";

	      res += condition;                        //Condition
	      res += "JUMPF " + startLabelIf + "\n";   //Si condition ok on va au block if


	                                               //Si condition pas ok on va au block else ???


	      res += "LABEL " + startLabelIf + "\n";   //Debut du block if
	      res += ifBlock;                          //Block if
	      res += "JUMP " + endLabelElse + "\n";    //Si on a fait le block if on saute a la fin du block else

	      res += "LABEL " + startLabelElse + "\n"; //Debut du block else
	      res += elseBlock;                        //Block else
	      res += "LABEL " + endLabelElse + "\n";   //Fin du block else

	      if(elseBlock!=null){
	        res += elseBlock;
	        res += "JUMP " + startLabelElse + "\n";
	        res += "LABEL " + endLabelElse + "\n";
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00bc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23y\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u0084\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u008e\n\25\3\26\5\26\u0091\n\26\3\26\3\26\3\26\3\26\3"+
		"\27\6\27\u0098\n\27\r\27\16\27\u0099\3\27\3\27\3\30\6\30\u009f\n\30\r"+
		"\30\16\30\u00a0\3\31\6\31\u00a4\n\31\r\31\16\31\u00a5\3\31\3\31\6\31\u00aa"+
		"\n\31\r\31\16\31\u00ab\3\32\6\32\u00af\n\32\r\32\16\32\u00b0\3\32\7\32"+
		"\u00b4\n\32\f\32\16\32\u00b7\13\32\3\33\3\33\3\33\3\33\2\2\34\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\5\4\2>>@@\4\2\13\13"+
		"\"\"\4\2C\\c|\2\u00c9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3"+
		"\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17C\3\2"+
		"\2\2\21E\3\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27P\3\2\2\2\31V\3\2\2\2\33]\3"+
		"\2\2\2\35d\3\2\2\2\37i\3\2\2\2!o\3\2\2\2#q\3\2\2\2%x\3\2\2\2\'\u0083\3"+
		"\2\2\2)\u008d\3\2\2\2+\u0090\3\2\2\2-\u0097\3\2\2\2/\u009e\3\2\2\2\61"+
		"\u00a3\3\2\2\2\63\u00ae\3\2\2\2\65\u00b8\3\2\2\2\678\7}\2\28\4\3\2\2\2"+
		"9:\7\177\2\2:\6\3\2\2\2;<\7*\2\2<\b\3\2\2\2=>\7+\2\2>\n\3\2\2\2?@\7,\2"+
		"\2@\f\3\2\2\2AB\7\61\2\2B\16\3\2\2\2CD\7-\2\2D\20\3\2\2\2EF\7/\2\2F\22"+
		"\3\2\2\2GH\7k\2\2HI\7h\2\2IJ\7*\2\2J\24\3\2\2\2KL\7g\2\2LM\7n\2\2MN\7"+
		"u\2\2NO\7g\2\2O\26\3\2\2\2PQ\7t\2\2QR\7g\2\2RS\7c\2\2ST\7f\2\2TU\7*\2"+
		"\2U\30\3\2\2\2VW\7y\2\2WX\7t\2\2XY\7k\2\2YZ\7v\2\2Z[\7g\2\2[\\\7*\2\2"+
		"\\\32\3\2\2\2]^\7y\2\2^_\7j\2\2_`\7k\2\2`a\7n\2\2ab\7g\2\2bc\7*\2\2c\34"+
		"\3\2\2\2de\7v\2\2ef\7t\2\2fg\7w\2\2gh\7g\2\2h\36\3\2\2\2ij\7h\2\2jk\7"+
		"c\2\2kl\7n\2\2lm\7u\2\2mn\7g\2\2n \3\2\2\2op\7?\2\2p\"\3\2\2\2qr\7=\2"+
		"\2r$\3\2\2\2st\7(\2\2ty\7(\2\2uv\7~\2\2vy\7~\2\2wy\7#\2\2xs\3\2\2\2xu"+
		"\3\2\2\2xw\3\2\2\2y&\3\2\2\2z{\7?\2\2{\u0084\7?\2\2|\u0084\t\2\2\2}~\7"+
		">\2\2~\u0084\7?\2\2\177\u0080\7@\2\2\u0080\u0084\7?\2\2\u0081\u0082\7"+
		"#\2\2\u0082\u0084\7?\2\2\u0083z\3\2\2\2\u0083|\3\2\2\2\u0083}\3\2\2\2"+
		"\u0083\177\3\2\2\2\u0083\u0081\3\2\2\2\u0084(\3\2\2\2\u0085\u0086\7k\2"+
		"\2\u0086\u0087\7p\2\2\u0087\u008e\7v\2\2\u0088\u0089\7h\2\2\u0089\u008a"+
		"\7n\2\2\u008a\u008b\7q\2\2\u008b\u008c\7c\2\2\u008c\u008e\7v\2\2\u008d"+
		"\u0085\3\2\2\2\u008d\u0088\3\2\2\2\u008e*\3\2\2\2\u008f\u0091\7\17\2\2"+
		"\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\7\f\2\2\u0093\u0094\3\2\2\2\u0094\u0095\b\26\2\2\u0095,\3\2\2\2\u0096"+
		"\u0098\t\3\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\27\2\2\u009c"+
		".\3\2\2\2\u009d\u009f\4\62;\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\60\3\2\2\2\u00a2\u00a4"+
		"\4\62;\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\7\60\2\2\u00a8\u00aa\4"+
		"\62;\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\62\3\2\2\2\u00ad\u00af\t\4\2\2\u00ae\u00ad\3\2\2"+
		"\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b5"+
		"\3\2\2\2\u00b2\u00b4\4\62;\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\64\3\2\2\2\u00b7\u00b5\3\2\2"+
		"\2\u00b8\u00b9\13\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b\33\2\2\u00bb"+
		"\66\3\2\2\2\r\2x\u0083\u008d\u0090\u0099\u00a0\u00a5\u00ab\u00b0\u00b5"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}