// Generated from skeleton.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class skeletonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NEWLINE=2, WS=3, OP=4, ENTIER=5, UNMATCH=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "NEWLINE", "WS", "OP", "ENTIER", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NEWLINE", "WS", "OP", "ENTIER", "UNMATCH"
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


	public skeletonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "skeleton.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\b;\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\5\3\23\n\3\3\3\3\3"+
		"\3\3\3\3\3\4\6\4\32\n\4\r\4\16\4\33\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\61\n\5\3\6\6\6\64\n\6\r"+
		"\6\16\6\65\3\7\3\7\3\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\3\4\2\13"+
		"\13\"\"\2A\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\3\17\3\2\2\2\5\22\3\2\2\2\7\31\3\2\2\2\t\60\3\2\2\2\13"+
		"\63\3\2\2\2\r\67\3\2\2\2\17\20\7=\2\2\20\4\3\2\2\2\21\23\7\17\2\2\22\21"+
		"\3\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25\7\f\2\2\25\26\3\2\2\2\26\27"+
		"\b\3\2\2\27\6\3\2\2\2\30\32\t\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31"+
		"\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\b\4\2\2\36\b\3\2\2\2\37 \7"+
		"R\2\2 !\7W\2\2!\"\7U\2\2\"#\7J\2\2#\61\7K\2\2$%\7C\2\2%&\7F\2\2&\61\7"+
		"F\2\2\'(\7U\2\2()\7W\2\2)\61\7D\2\2*+\7O\2\2+,\7W\2\2,\61\7N\2\2-.\7F"+
		"\2\2./\7K\2\2/\61\7X\2\2\60\37\3\2\2\2\60$\3\2\2\2\60\'\3\2\2\2\60*\3"+
		"\2\2\2\60-\3\2\2\2\61\n\3\2\2\2\62\64\4\62;\2\63\62\3\2\2\2\64\65\3\2"+
		"\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\f\3\2\2\2\678\13\2\2\289\3\2\2\29"+
		":\b\7\2\2:\16\3\2\2\2\7\2\22\33\60\65\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}