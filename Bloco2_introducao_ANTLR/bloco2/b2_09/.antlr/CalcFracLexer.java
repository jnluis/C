// Generated from /home/joao/Documents/Ano2/Semestre2/C-Compiladores/Bloco2_introducao_ANTLR/bloco2/b2_09/CalcFrac.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcFracLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ID=15, String=16, Integer=17, 
		COMMENT=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "ID", "String", "Integer", 
			"COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'->'", "'print'", "'-'", "'*'", "':'", "'%'", "'+'", "'/'", 
			"'reduce'", "'^'", "'('", "')'", "'read'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "String", "Integer", "COMMENT", "WS"
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


	public CalcFracLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalcFrac.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\6\20"+
		"T\n\20\r\20\16\20U\3\21\3\21\7\21Z\n\21\f\21\16\21]\13\21\3\21\3\21\3"+
		"\22\6\22b\n\22\r\22\16\22c\3\23\3\23\3\23\3\23\7\23j\n\23\f\23\16\23m"+
		"\13\23\3\23\3\23\5\23q\n\23\3\23\3\23\3\23\3\23\3\24\6\24x\n\24\r\24\16"+
		"\24y\3\24\3\24\4[k\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\5\4\2C\\c|\3\2\62;"+
		"\5\2\13\f\17\17\"\"\2\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3"+
		"\2\2\2\7.\3\2\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21"+
		"<\3\2\2\2\23>\3\2\2\2\25@\3\2\2\2\27G\3\2\2\2\31I\3\2\2\2\33K\3\2\2\2"+
		"\35M\3\2\2\2\37S\3\2\2\2!W\3\2\2\2#a\3\2\2\2%e\3\2\2\2\'w\3\2\2\2)*\7"+
		"=\2\2*\4\3\2\2\2+,\7/\2\2,-\7@\2\2-\6\3\2\2\2./\7r\2\2/\60\7t\2\2\60\61"+
		"\7k\2\2\61\62\7p\2\2\62\63\7v\2\2\63\b\3\2\2\2\64\65\7/\2\2\65\n\3\2\2"+
		"\2\66\67\7,\2\2\67\f\3\2\2\289\7<\2\29\16\3\2\2\2:;\7\'\2\2;\20\3\2\2"+
		"\2<=\7-\2\2=\22\3\2\2\2>?\7\61\2\2?\24\3\2\2\2@A\7t\2\2AB\7g\2\2BC\7f"+
		"\2\2CD\7w\2\2DE\7e\2\2EF\7g\2\2F\26\3\2\2\2GH\7`\2\2H\30\3\2\2\2IJ\7*"+
		"\2\2J\32\3\2\2\2KL\7+\2\2L\34\3\2\2\2MN\7t\2\2NO\7g\2\2OP\7c\2\2PQ\7f"+
		"\2\2Q\36\3\2\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V \3"+
		"\2\2\2W[\7$\2\2XZ\13\2\2\2YX\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2[Y\3\2\2\2\\"+
		"^\3\2\2\2][\3\2\2\2^_\7$\2\2_\"\3\2\2\2`b\t\3\2\2a`\3\2\2\2bc\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2d$\3\2\2\2ef\7\61\2\2fg\7\61\2\2gk\3\2\2\2hj\13\2"+
		"\2\2ih\3\2\2\2jm\3\2\2\2kl\3\2\2\2ki\3\2\2\2lp\3\2\2\2mk\3\2\2\2no\7\61"+
		"\2\2oq\7t\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\f\2\2st\3\2\2\2tu\b\23"+
		"\2\2u&\3\2\2\2vx\t\4\2\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2"+
		"\2\2{|\b\24\2\2|(\3\2\2\2\t\2U[ckpy\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}