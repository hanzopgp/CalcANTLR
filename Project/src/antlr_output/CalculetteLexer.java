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
		T__9=10, TYPE=11, NEWLINE=12, WS=13, ENTIER=14, FLOAT=15, IDENTIFIANT=16, 
		UNMATCH=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "TYPE", "NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'write('", "')'", "'read('", "'('", "'*'", "'/'", "'+'", "'-'", 
			"';'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
			"NEWLINE", "WS", "ENTIER", "FLOAT", "IDENTIFIANT", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\fK\n\f\3\r\5\rN\n\r\3\r\3\r\3\r\3\r\3\16\6\16U\n\16\r\16"+
		"\16\16V\3\16\3\16\3\17\6\17\\\n\17\r\17\16\17]\3\20\6\20a\n\20\r\20\16"+
		"\20b\3\20\3\20\6\20g\n\20\r\20\16\20h\3\21\6\21l\n\21\r\21\16\21m\3\21"+
		"\7\21q\n\21\f\21\16\21t\13\21\3\22\3\22\3\22\3\22\2\2\23\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"\3\2\4\4\2\13\13\"\"\4\2C\\c|\2\u0080\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5,\3\2\2\2\7.\3\2"+
		"\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21<\3\2\2\2\23"+
		">\3\2\2\2\25@\3\2\2\2\27J\3\2\2\2\31M\3\2\2\2\33T\3\2\2\2\35[\3\2\2\2"+
		"\37`\3\2\2\2!k\3\2\2\2#u\3\2\2\2%&\7y\2\2&\'\7t\2\2\'(\7k\2\2()\7v\2\2"+
		")*\7g\2\2*+\7*\2\2+\4\3\2\2\2,-\7+\2\2-\6\3\2\2\2./\7t\2\2/\60\7g\2\2"+
		"\60\61\7c\2\2\61\62\7f\2\2\62\63\7*\2\2\63\b\3\2\2\2\64\65\7*\2\2\65\n"+
		"\3\2\2\2\66\67\7,\2\2\67\f\3\2\2\289\7\61\2\29\16\3\2\2\2:;\7-\2\2;\20"+
		"\3\2\2\2<=\7/\2\2=\22\3\2\2\2>?\7=\2\2?\24\3\2\2\2@A\7?\2\2A\26\3\2\2"+
		"\2BC\7k\2\2CD\7p\2\2DK\7v\2\2EF\7h\2\2FG\7n\2\2GH\7q\2\2HI\7c\2\2IK\7"+
		"v\2\2JB\3\2\2\2JE\3\2\2\2K\30\3\2\2\2LN\7\17\2\2ML\3\2\2\2MN\3\2\2\2N"+
		"O\3\2\2\2OP\7\f\2\2PQ\3\2\2\2QR\b\r\2\2R\32\3\2\2\2SU\t\2\2\2TS\3\2\2"+
		"\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\b\16\2\2Y\34\3\2\2\2Z\\\4"+
		"\62;\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^\36\3\2\2\2_a\4\62;\2"+
		"`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2df\7\60\2\2eg\4\62;"+
		"\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i \3\2\2\2jl\t\3\2\2kj\3\2\2"+
		"\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2nr\3\2\2\2oq\4\62;\2po\3\2\2\2qt\3\2\2"+
		"\2rp\3\2\2\2rs\3\2\2\2s\"\3\2\2\2tr\3\2\2\2uv\13\2\2\2vw\3\2\2\2wx\b\22"+
		"\2\2x$\3\2\2\2\13\2JMV]bhmr\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}