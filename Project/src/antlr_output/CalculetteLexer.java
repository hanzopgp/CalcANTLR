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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, EXPRLOG=16, 
		COND=17, TYPE=18, NEWLINE=19, WS=20, ENTIER=21, FLOAT=22, IDENTIFIANT=23, 
		UNMATCH=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "EXPRLOG", "COND", 
			"TYPE", "NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21l\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22w\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u0081\n\23\3\24\5\24\u0084\n\24\3\24\3\24\3\24\3\24\3"+
		"\25\6\25\u008b\n\25\r\25\16\25\u008c\3\25\3\25\3\26\6\26\u0092\n\26\r"+
		"\26\16\26\u0093\3\27\6\27\u0097\n\27\r\27\16\27\u0098\3\27\3\27\6\27\u009d"+
		"\n\27\r\27\16\27\u009e\3\30\6\30\u00a2\n\30\r\30\16\30\u00a3\3\30\7\30"+
		"\u00a7\n\30\f\30\16\30\u00aa\13\30\3\31\3\31\3\31\3\31\2\2\32\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\5\4\2>>@@\4\2\13\13\"\"\4\2C\\"+
		"c|\2\u00bc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2"+
		"\2\2\13;\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25I\3"+
		"\2\2\2\27P\3\2\2\2\31W\3\2\2\2\33\\\3\2\2\2\35b\3\2\2\2\37d\3\2\2\2!k"+
		"\3\2\2\2#v\3\2\2\2%\u0080\3\2\2\2\'\u0083\3\2\2\2)\u008a\3\2\2\2+\u0091"+
		"\3\2\2\2-\u0096\3\2\2\2/\u00a1\3\2\2\2\61\u00ab\3\2\2\2\63\64\7}\2\2\64"+
		"\4\3\2\2\2\65\66\7\177\2\2\66\6\3\2\2\2\678\7*\2\28\b\3\2\2\29:\7+\2\2"+
		":\n\3\2\2\2;<\7,\2\2<\f\3\2\2\2=>\7\61\2\2>\16\3\2\2\2?@\7-\2\2@\20\3"+
		"\2\2\2AB\7/\2\2B\22\3\2\2\2CD\7t\2\2DE\7g\2\2EF\7c\2\2FG\7f\2\2GH\7*\2"+
		"\2H\24\3\2\2\2IJ\7y\2\2JK\7t\2\2KL\7k\2\2LM\7v\2\2MN\7g\2\2NO\7*\2\2O"+
		"\26\3\2\2\2PQ\7y\2\2QR\7j\2\2RS\7k\2\2ST\7n\2\2TU\7g\2\2UV\7*\2\2V\30"+
		"\3\2\2\2WX\7v\2\2XY\7t\2\2YZ\7w\2\2Z[\7g\2\2[\32\3\2\2\2\\]\7h\2\2]^\7"+
		"c\2\2^_\7n\2\2_`\7u\2\2`a\7g\2\2a\34\3\2\2\2bc\7?\2\2c\36\3\2\2\2de\7"+
		"=\2\2e \3\2\2\2fg\7(\2\2gl\7(\2\2hi\7~\2\2il\7~\2\2jl\7#\2\2kf\3\2\2\2"+
		"kh\3\2\2\2kj\3\2\2\2l\"\3\2\2\2mn\7?\2\2nw\7?\2\2ow\t\2\2\2pq\7>\2\2q"+
		"w\7?\2\2rs\7@\2\2sw\7?\2\2tu\7#\2\2uw\7?\2\2vm\3\2\2\2vo\3\2\2\2vp\3\2"+
		"\2\2vr\3\2\2\2vt\3\2\2\2w$\3\2\2\2xy\7k\2\2yz\7p\2\2z\u0081\7v\2\2{|\7"+
		"h\2\2|}\7n\2\2}~\7q\2\2~\177\7c\2\2\177\u0081\7v\2\2\u0080x\3\2\2\2\u0080"+
		"{\3\2\2\2\u0081&\3\2\2\2\u0082\u0084\7\17\2\2\u0083\u0082\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7\f\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\b\24\2\2\u0088(\3\2\2\2\u0089\u008b\t\3\2\2\u008a\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\b\25\2\2\u008f*\3\2\2\2\u0090\u0092\4\62;\2"+
		"\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094,\3\2\2\2\u0095\u0097\4\62;\2\u0096\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009c\7\60\2\2\u009b\u009d\4\62;\2\u009c\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f.\3\2\2\2"+
		"\u00a0\u00a2\t\4\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a8\3\2\2\2\u00a5\u00a7\4\62;\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\60\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\13\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\b\31\2\2\u00ae\62\3\2\2\2\r\2kv\u0080\u0083\u008c"+
		"\u0093\u0098\u009e\u00a3\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}