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
		T__9=10, T__10=11, T__11=12, T__12=13, COND=14, TYPE=15, NEWLINE=16, WS=17, 
		ENTIER=18, FLOAT=19, IDENTIFIANT=20, UNMATCH=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "COND", "TYPE", "NEWLINE", "WS", "ENTIER", 
			"FLOAT", "IDENTIFIANT", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'read('", "'write('", 
			"'while('", "'true'", "'false'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "COND", "TYPE", "NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", 
			"UNMATCH"
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
	                                                                                                  //liens var/type et les valeurs dans les adresses
	    private int _cur_label = 1;                                                                   
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

	    public String evalLoop(String condition, String instruction){                                 //Fonction renvoyant le code mvap pour creer
	      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
	      String endLabel = getNewLabel();
	      String res = "";
	      res += "LABEL " + startLabel + "\n";
	      res += condition;
	      res += "JUMPF " + endLabel + "\n";
	      res += instruction;
	      res += "JUMP " + startLabel + "\n";
	      res += "LABEL " + endLabel + "\n";
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u009e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17f\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20p\n\20"+
		"\3\21\5\21s\n\21\3\21\3\21\3\21\3\21\3\22\6\22z\n\22\r\22\16\22{\3\22"+
		"\3\22\3\23\6\23\u0081\n\23\r\23\16\23\u0082\3\24\6\24\u0086\n\24\r\24"+
		"\16\24\u0087\3\24\3\24\6\24\u008c\n\24\r\24\16\24\u008d\3\25\6\25\u0091"+
		"\n\25\r\25\16\25\u0092\3\25\7\25\u0096\n\25\f\25\16\25\u0099\13\25\3\26"+
		"\3\26\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\5\4\2>>@@\4\2"+
		"\13\13\"\"\4\2C\\c|\2\u00a9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2\2\r"+
		"\67\3\2\2\2\179\3\2\2\2\21?\3\2\2\2\23F\3\2\2\2\25M\3\2\2\2\27R\3\2\2"+
		"\2\31X\3\2\2\2\33Z\3\2\2\2\35e\3\2\2\2\37o\3\2\2\2!r\3\2\2\2#y\3\2\2\2"+
		"%\u0080\3\2\2\2\'\u0085\3\2\2\2)\u0090\3\2\2\2+\u009a\3\2\2\2-.\7*\2\2"+
		".\4\3\2\2\2/\60\7+\2\2\60\6\3\2\2\2\61\62\7,\2\2\62\b\3\2\2\2\63\64\7"+
		"\61\2\2\64\n\3\2\2\2\65\66\7-\2\2\66\f\3\2\2\2\678\7/\2\28\16\3\2\2\2"+
		"9:\7t\2\2:;\7g\2\2;<\7c\2\2<=\7f\2\2=>\7*\2\2>\20\3\2\2\2?@\7y\2\2@A\7"+
		"t\2\2AB\7k\2\2BC\7v\2\2CD\7g\2\2DE\7*\2\2E\22\3\2\2\2FG\7y\2\2GH\7j\2"+
		"\2HI\7k\2\2IJ\7n\2\2JK\7g\2\2KL\7*\2\2L\24\3\2\2\2MN\7v\2\2NO\7t\2\2O"+
		"P\7w\2\2PQ\7g\2\2Q\26\3\2\2\2RS\7h\2\2ST\7c\2\2TU\7n\2\2UV\7u\2\2VW\7"+
		"g\2\2W\30\3\2\2\2XY\7?\2\2Y\32\3\2\2\2Z[\7=\2\2[\34\3\2\2\2\\]\7?\2\2"+
		"]f\7?\2\2^f\t\2\2\2_`\7>\2\2`f\7?\2\2ab\7@\2\2bf\7?\2\2cd\7#\2\2df\7?"+
		"\2\2e\\\3\2\2\2e^\3\2\2\2e_\3\2\2\2ea\3\2\2\2ec\3\2\2\2f\36\3\2\2\2gh"+
		"\7k\2\2hi\7p\2\2ip\7v\2\2jk\7h\2\2kl\7n\2\2lm\7q\2\2mn\7c\2\2np\7v\2\2"+
		"og\3\2\2\2oj\3\2\2\2p \3\2\2\2qs\7\17\2\2rq\3\2\2\2rs\3\2\2\2st\3\2\2"+
		"\2tu\7\f\2\2uv\3\2\2\2vw\b\21\2\2w\"\3\2\2\2xz\t\3\2\2yx\3\2\2\2z{\3\2"+
		"\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\b\22\2\2~$\3\2\2\2\177\u0081\4\62"+
		";\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083&\3\2\2\2\u0084\u0086\4\62;\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008b\7\60\2\2\u008a\u008c\4\62;\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e(\3\2\2\2"+
		"\u008f\u0091\t\4\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097\3\2\2\2\u0094\u0096\4\62;\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098*\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\13\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009d\b\26\2\2\u009d,\3\2\2\2\f\2eor{\u0082\u0087\u008d"+
		"\u0092\u0097\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}