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
		T__17=18, T__18=19, T__19=20, EXPRLOG=21, COND=22, TYPE=23, NEWLINE=24, 
		WS=25, ENTIER=26, FLOAT=27, IDENTIFIANT=28, UNMATCH=29;
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
			"T__17", "T__18", "T__19", "EXPRLOG", "COND", "TYPE", "NEWLINE", "WS", 
			"ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'if('", 
			"'else'", "'read('", "'write('", "'while('", "'for('", "';'", "'repeat'", 
			"'until('", "'true'", "'false'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "EXPRLOG", "COND", 
			"TYPE", "NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
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

	    public String evalWhileLoop(String condition, String block){                                  //Fonction renvoyant le code mvap pour creer
	      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
	      String endLabel = getNewLabel();
	      String res = "LABEL " + startLabel + "\n" + condition + "JUMPF " + endLabel + "\n"
	          + block + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
	      return res;
	    }

	    public String evalForLoop(String init, String condition, String iteration, String block){     //Fonction renvoyant le code mvap pour creer une
	      String startLabel = getNewLabel();                                                          //boucle for
	      String endLabel = getNewLabel();
	      String res = init + "LABEL " + startLabel + "\n" + condition + "JUMPF " + endLabel + "\n"
	            + block + iteration + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
	      return res;
	    }

	    public String evalRepeatLoop(String condition, String block){                                 //Fonction renvoyant le code mvap pour creer une                  
	      String startLabel = getNewLabel();                                                          //boucle repeat until
	      String res = "LABEL " + startLabel + "\n" + block 
	            + condition + "\n" + "JUMPF " + startLabel + "\n";
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
	      String elseStartLabel = getNewLabel();                                                      //branchement if else
	      String ifEndLabel = getNewLabel();  
	      String res = condition + "\n" + "JUMPF " + elseStartLabel +"\n" 
	                 + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
	                 + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
	      return res;
	    }

	    public String evalIf(String condition, String ifBlock){                                       //Fonction renvoyant le code pour gerer les
	      String ifEndLabel = getNewLabel();                                                          //branchement if
	      String res = condition + "\n" + "JUMPF " + ifEndLabel 
	                 + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00d5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u0092\n\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u009d\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u00a7\n\30\3\31\5\31\u00aa\n\31\3\31\3\31\3\31\3\31\3\32\6\32\u00b1"+
		"\n\32\r\32\16\32\u00b2\3\32\3\32\3\33\6\33\u00b8\n\33\r\33\16\33\u00b9"+
		"\3\34\6\34\u00bd\n\34\r\34\16\34\u00be\3\34\3\34\6\34\u00c3\n\34\r\34"+
		"\16\34\u00c4\3\35\6\35\u00c8\n\35\r\35\16\35\u00c9\3\35\7\35\u00cd\n\35"+
		"\f\35\16\35\u00d0\13\35\3\36\3\36\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\5\4\2>>@@\4\2"+
		"\13\13\"\"\4\2C\\c|\2\u00e2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC"+
		"\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25"+
		"Q\3\2\2\2\27V\3\2\2\2\31\\\3\2\2\2\33c\3\2\2\2\35j\3\2\2\2\37o\3\2\2\2"+
		"!q\3\2\2\2#x\3\2\2\2%\177\3\2\2\2\'\u0084\3\2\2\2)\u008a\3\2\2\2+\u0091"+
		"\3\2\2\2-\u009c\3\2\2\2/\u00a6\3\2\2\2\61\u00a9\3\2\2\2\63\u00b0\3\2\2"+
		"\2\65\u00b7\3\2\2\2\67\u00bc\3\2\2\29\u00c7\3\2\2\2;\u00d1\3\2\2\2=>\7"+
		"}\2\2>\4\3\2\2\2?@\7\177\2\2@\6\3\2\2\2AB\7*\2\2B\b\3\2\2\2CD\7+\2\2D"+
		"\n\3\2\2\2EF\7,\2\2F\f\3\2\2\2GH\7\61\2\2H\16\3\2\2\2IJ\7-\2\2J\20\3\2"+
		"\2\2KL\7/\2\2L\22\3\2\2\2MN\7k\2\2NO\7h\2\2OP\7*\2\2P\24\3\2\2\2QR\7g"+
		"\2\2RS\7n\2\2ST\7u\2\2TU\7g\2\2U\26\3\2\2\2VW\7t\2\2WX\7g\2\2XY\7c\2\2"+
		"YZ\7f\2\2Z[\7*\2\2[\30\3\2\2\2\\]\7y\2\2]^\7t\2\2^_\7k\2\2_`\7v\2\2`a"+
		"\7g\2\2ab\7*\2\2b\32\3\2\2\2cd\7y\2\2de\7j\2\2ef\7k\2\2fg\7n\2\2gh\7g"+
		"\2\2hi\7*\2\2i\34\3\2\2\2jk\7h\2\2kl\7q\2\2lm\7t\2\2mn\7*\2\2n\36\3\2"+
		"\2\2op\7=\2\2p \3\2\2\2qr\7t\2\2rs\7g\2\2st\7r\2\2tu\7g\2\2uv\7c\2\2v"+
		"w\7v\2\2w\"\3\2\2\2xy\7w\2\2yz\7p\2\2z{\7v\2\2{|\7k\2\2|}\7n\2\2}~\7*"+
		"\2\2~$\3\2\2\2\177\u0080\7v\2\2\u0080\u0081\7t\2\2\u0081\u0082\7w\2\2"+
		"\u0082\u0083\7g\2\2\u0083&\3\2\2\2\u0084\u0085\7h\2\2\u0085\u0086\7c\2"+
		"\2\u0086\u0087\7n\2\2\u0087\u0088\7u\2\2\u0088\u0089\7g\2\2\u0089(\3\2"+
		"\2\2\u008a\u008b\7?\2\2\u008b*\3\2\2\2\u008c\u008d\7(\2\2\u008d\u0092"+
		"\7(\2\2\u008e\u008f\7~\2\2\u008f\u0092\7~\2\2\u0090\u0092\7#\2\2\u0091"+
		"\u008c\3\2\2\2\u0091\u008e\3\2\2\2\u0091\u0090\3\2\2\2\u0092,\3\2\2\2"+
		"\u0093\u0094\7?\2\2\u0094\u009d\7?\2\2\u0095\u009d\t\2\2\2\u0096\u0097"+
		"\7>\2\2\u0097\u009d\7?\2\2\u0098\u0099\7@\2\2\u0099\u009d\7?\2\2\u009a"+
		"\u009b\7#\2\2\u009b\u009d\7?\2\2\u009c\u0093\3\2\2\2\u009c\u0095\3\2\2"+
		"\2\u009c\u0096\3\2\2\2\u009c\u0098\3\2\2\2\u009c\u009a\3\2\2\2\u009d."+
		"\3\2\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a7\7v\2\2\u00a1"+
		"\u00a2\7h\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7c\2\2"+
		"\u00a5\u00a7\7v\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a7\60\3"+
		"\2\2\2\u00a8\u00aa\7\17\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\31"+
		"\2\2\u00ae\62\3\2\2\2\u00af\u00b1\t\3\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\b\32\2\2\u00b5\64\3\2\2\2\u00b6\u00b8\4\62;\2\u00b7\u00b6\3\2\2"+
		"\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\66"+
		"\3\2\2\2\u00bb\u00bd\4\62;\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\7\60"+
		"\2\2\u00c1\u00c3\4\62;\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c58\3\2\2\2\u00c6\u00c8\t\4\2\2"+
		"\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\4\62;\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf:\3\2\2\2"+
		"\u00d0\u00ce\3\2\2\2\u00d1\u00d2\13\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4"+
		"\b\36\2\2\u00d4<\3\2\2\2\r\2\u0091\u009c\u00a6\u00a9\u00b2\u00b9\u00be"+
		"\u00c4\u00c9\u00ce\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}