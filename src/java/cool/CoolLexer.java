// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WHITESPACE=43, SINGLE_LINE_COMMENT=44, 
		MULTI_LINE_COMMENT=45, ERROR_IN_MULTI_LINE=46, ERR_IN=47, INVALID_CHARACTER=48;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DIGIT", "ALPHA", "IN_STR", "IN_COMMENT", "IN_SINGLE_COMMENT", "A", "B", 
		"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
		"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CLASS", "ELSE", "FI", 
		"IF", "IN", "INHERITS", "LET", "LOOP", "POOL", "THEN", "WHILE", "CASE", 
		"ESAC", "OF", "NEW", "ISVOID", "NOT", "BOOL_CONST", "INT_CONST", "TYPEID", 
		"OBJECTID", "SEMICOLON", "DARROW", "LPAREN", "RPAREN", "COLON", "ATSYM", 
		"COMMA", "PLUS", "MINUS", "STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", 
		"RBRACE", "DOT", "LE", "ASSIGN", "WHITESPACE", "STR_CONST", "SINGLE_LINE_COMMENT", 
		"MULTI_LINE_COMMENT", "ERROR_IN_MULTI_LINE", "ERR_IN", "INVALID_CHARACTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WHITESPACE", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "ERROR_IN_MULTI_LINE", 
		"ERR_IN", "INVALID_CHARACTER"
	};
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



		/*
			YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Use this function whenever your lexer encounters any erroneous input
		* DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString){
			setText(errorString);
			setType(ERROR);
		}

		//function which processes the valid strings
		public void processString() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			
			//write your code to test strings here
			
			String new_str = "";					//To store the modified string
			int i = 1;
			while(i < text.length()-1){ 		    //iterating through the string
				if('\\' == text.charAt(i)){ 		//making escape sequences as a single character
					char ch = text.charAt(++i);
					if(ch == 'b')
						new_str += '\b';
					else if(ch == 't')
						new_str += '\t';
					else if(ch == 'n')
						new_str += '\n';
					else if(ch == 'f')
						new_str += '\f';
					else if(ch == '\"')
						new_str += '\"';
					else if(ch == '\\')
						new_str += '\\';
					else
						new_str += ch;
				}else{
					new_str += text.charAt(i);
				}
				++i;		
			}
			if(new_str.length() > 1024){ 		//reporting error if the string is long
				reportError("String constant too long");
				return;
			}
			setText(new_str);
			return;
		}

		//function to process invalid characters
		public void processInvalidCharacter() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			reportError(text);
		}

		//function to process invalid strings
		public void processInvalidString(){
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();

			int i = 1;
			int count = 0, flag = 0;				//count will store the no.of chars in a string
			
			if(text.length() == 1){					//string having no characters and EOF is reached
				reportError("EOF in string constant"); //reporting error
				return;
			}

			while(i < text.length()){				//iterating through the string
				char inv = text.charAt(i);

				if((inv != '\u0000') && (inv != '\n') && (inv != '"') && (inv != '\\')){ 
					count++;						//counting the character if it is valid 
				}
				else if(inv == '\u0000'){			//reporting error if string contains null character
					reportError("String contains null character.");
					return;
				}
				else if(inv == '\n'){				//reporting error if string has unescaped new line
					reportError("Unterminated string constant");
					return;
				}
				else if(inv == '\\'){				
					if((i<text.length()-1) && (text.charAt(i+1) == '\\' || text.charAt(i+1) == '\n' || text.charAt(i+1) == '\"')){ //escaping the valid characters
						count++;					//incrementing count
						i = i+1;					//skipping the chars next to backslash
					}
					else if((i<text.length()-1) && text.charAt(i+1) == '\u0000'){  //escaped null char
						reportError("String contains escaped null character.");	   //reporting the error which is given by coolc compiler
						return;
					}
					else if(i == text.length()-1){	//if end of file is reached after a backslash
						reportError("backslash at end of file"); //reporting the error which is given by coolc compiler
						return;
					}
				}
				if(i==text.length()-1 && inv != '\n'){ //if end of file is reached
					reportError("EOF in string constant");
					return;
				}
				if(count > 1025){				 //if the string is too long then breaking the loop
					flag = 1;					 //updating flag	
					break;
				}
				++i;
			}
			if(count == 1025 && text.charAt(1025)!='\n'){	//exception case 
				reportError("EOF in string constant");		//coolc reports EOF rather than string too long
				return;
			}
			if(flag == 1){						//reporting the error if string is long
				reportError("String constant too long");
				return;
			}
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 72:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 75:
			ERROR_IN_MULTI_LINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 76:
			ERR_IN_action((RuleContext)_localctx, actionIndex);
			break;
		case 77:
			INVALID_CHARACTER_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			processString() ;
			break;
		case 1:
			processInvalidString();
			break;
		case 2:
			processInvalidString();
			break;
		case 3:
			processInvalidString();
			break;
		}
	}
	private void ERROR_IN_MULTI_LINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			reportError("EOF in comment");
			break;
		}
	}
	private void ERR_IN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			reportError("Unmatched *)");
			break;
		}
	}
	private void INVALID_CHARACTER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			processInvalidCharacter();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\62\u020c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u00ab\n\4\3\5\3\5\3\5\3\5\3\5\5\5\u00b2\n\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3"+
		",\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\5\62\u0147\n\62\3\63\6\63\u014a\n\63\r\63\16\63\u014b"+
		"\3\64\3\64\3\64\3\64\7\64\u0152\n\64\f\64\16\64\u0155\13\64\3\65\3\65"+
		"\3\65\3\65\7\65\u015b\n\65\f\65\16\65\u015e\13\65\3\66\3\66\3\67\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3"+
		"B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3G\3H\3H\3H\3I\6I\u018a\nI\rI\16I\u018b"+
		"\3I\3I\3J\3J\7J\u0192\nJ\fJ\16J\u0195\13J\3J\3J\3J\3J\7J\u019b\nJ\fJ\16"+
		"J\u019e\13J\3J\5J\u01a1\nJ\3J\3J\3J\3J\7J\u01a7\nJ\fJ\16J\u01aa\13J\3"+
		"J\3J\3J\3J\7J\u01b0\nJ\fJ\16J\u01b3\13J\3J\5J\u01b6\nJ\3J\3J\7J\u01ba"+
		"\nJ\fJ\16J\u01bd\13J\7J\u01bf\nJ\fJ\16J\u01c2\13J\3J\5J\u01c5\nJ\3J\5"+
		"J\u01c8\nJ\3K\3K\3K\3K\7K\u01ce\nK\fK\16K\u01d1\13K\3K\3K\3K\3K\3K\7K"+
		"\u01d8\nK\fK\16K\u01db\13K\3K\5K\u01de\nK\3K\3K\3L\3L\3L\3L\3L\7L\u01e7"+
		"\nL\fL\16L\u01ea\13L\3L\3L\3L\3L\5L\u01f0\nL\3L\3L\3M\3M\3M\3M\3M\3M\7"+
		"M\u01fa\nM\fM\16M\u01fd\13M\3M\3M\3M\3N\3N\3N\3N\5N\u0206\nN\3N\3N\3O"+
		"\3O\3O\2\2P\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33"+
		"\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2"+
		"A\34C\35E\36G\37I K!M\"O#Q$S%U&W\'Y([)]*_+a,c\6e\7g\4i\5k\rm\31o\tq\n"+
		"s\13u\fw\16y\17{\20}\21\177\22\u0081\23\u0083\24\u0085\25\u0087\26\u0089"+
		"\27\u008b\30\u008d\32\u008f\33\u0091-\u0093\b\u0095.\u0097/\u0099\60\u009b"+
		"\61\u009d\62\3\2&\3\2\62;\4\2C\\c|\6\2\2\2\f\f$$^^\3\2\2\2\3\2*,\3\2+"+
		"+\3\2,,\3\2\f\f\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2II"+
		"ii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2"+
		"RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4"+
		"\2[[{{\4\2\\\\||\4\2\n\17\"\"\4\3\f\f$$\u020f\2A\3\2\2\2\2C\3\2\2\2\2"+
		"E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3"+
		"\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2"+
		"\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2"+
		"k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3"+
		"\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2"+
		"\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\3\u009f\3\2\2\2\5\u00a1\3\2\2\2\7\u00aa\3\2\2\2\t\u00b1\3\2\2"+
		"\2\13\u00b3\3\2\2\2\r\u00b5\3\2\2\2\17\u00b7\3\2\2\2\21\u00b9\3\2\2\2"+
		"\23\u00bb\3\2\2\2\25\u00bd\3\2\2\2\27\u00bf\3\2\2\2\31\u00c1\3\2\2\2\33"+
		"\u00c3\3\2\2\2\35\u00c5\3\2\2\2\37\u00c7\3\2\2\2!\u00c9\3\2\2\2#\u00cb"+
		"\3\2\2\2%\u00cd\3\2\2\2\'\u00cf\3\2\2\2)\u00d1\3\2\2\2+\u00d3\3\2\2\2"+
		"-\u00d5\3\2\2\2/\u00d7\3\2\2\2\61\u00d9\3\2\2\2\63\u00db\3\2\2\2\65\u00dd"+
		"\3\2\2\2\67\u00df\3\2\2\29\u00e1\3\2\2\2;\u00e3\3\2\2\2=\u00e5\3\2\2\2"+
		"?\u00e7\3\2\2\2A\u00e9\3\2\2\2C\u00ef\3\2\2\2E\u00f4\3\2\2\2G\u00f7\3"+
		"\2\2\2I\u00fa\3\2\2\2K\u00fd\3\2\2\2M\u0106\3\2\2\2O\u010a\3\2\2\2Q\u010f"+
		"\3\2\2\2S\u0114\3\2\2\2U\u0119\3\2\2\2W\u011f\3\2\2\2Y\u0124\3\2\2\2["+
		"\u0129\3\2\2\2]\u012c\3\2\2\2_\u0130\3\2\2\2a\u0137\3\2\2\2c\u0146\3\2"+
		"\2\2e\u0149\3\2\2\2g\u014d\3\2\2\2i\u0156\3\2\2\2k\u015f\3\2\2\2m\u0161"+
		"\3\2\2\2o\u0164\3\2\2\2q\u0166\3\2\2\2s\u0168\3\2\2\2u\u016a\3\2\2\2w"+
		"\u016c\3\2\2\2y\u016e\3\2\2\2{\u0170\3\2\2\2}\u0172\3\2\2\2\177\u0174"+
		"\3\2\2\2\u0081\u0176\3\2\2\2\u0083\u0178\3\2\2\2\u0085\u017a\3\2\2\2\u0087"+
		"\u017c\3\2\2\2\u0089\u017e\3\2\2\2\u008b\u0180\3\2\2\2\u008d\u0182\3\2"+
		"\2\2\u008f\u0185\3\2\2\2\u0091\u0189\3\2\2\2\u0093\u01c7\3\2\2\2\u0095"+
		"\u01dd\3\2\2\2\u0097\u01e1\3\2\2\2\u0099\u01f3\3\2\2\2\u009b\u0201\3\2"+
		"\2\2\u009d\u0209\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\4\3\2\2\2\u00a1\u00a2"+
		"\t\3\2\2\u00a2\6\3\2\2\2\u00a3\u00ab\n\4\2\2\u00a4\u00a5\7^\2\2\u00a5"+
		"\u00ab\7$\2\2\u00a6\u00a7\7^\2\2\u00a7\u00ab\7\f\2\2\u00a8\u00a9\7^\2"+
		"\2\u00a9\u00ab\n\5\2\2\u00aa\u00a3\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a6"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\b\3\2\2\2\u00ac\u00b2\n\6\2\2\u00ad"+
		"\u00ae\7,\2\2\u00ae\u00b2\n\7\2\2\u00af\u00b0\7*\2\2\u00b0\u00b2\n\b\2"+
		"\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\n"+
		"\3\2\2\2\u00b3\u00b4\n\t\2\2\u00b4\f\3\2\2\2\u00b5\u00b6\t\n\2\2\u00b6"+
		"\16\3\2\2\2\u00b7\u00b8\t\13\2\2\u00b8\20\3\2\2\2\u00b9\u00ba\t\f\2\2"+
		"\u00ba\22\3\2\2\2\u00bb\u00bc\t\r\2\2\u00bc\24\3\2\2\2\u00bd\u00be\t\16"+
		"\2\2\u00be\26\3\2\2\2\u00bf\u00c0\t\17\2\2\u00c0\30\3\2\2\2\u00c1\u00c2"+
		"\t\20\2\2\u00c2\32\3\2\2\2\u00c3\u00c4\t\21\2\2\u00c4\34\3\2\2\2\u00c5"+
		"\u00c6\t\22\2\2\u00c6\36\3\2\2\2\u00c7\u00c8\t\23\2\2\u00c8 \3\2\2\2\u00c9"+
		"\u00ca\t\24\2\2\u00ca\"\3\2\2\2\u00cb\u00cc\t\25\2\2\u00cc$\3\2\2\2\u00cd"+
		"\u00ce\t\26\2\2\u00ce&\3\2\2\2\u00cf\u00d0\t\27\2\2\u00d0(\3\2\2\2\u00d1"+
		"\u00d2\t\30\2\2\u00d2*\3\2\2\2\u00d3\u00d4\t\31\2\2\u00d4,\3\2\2\2\u00d5"+
		"\u00d6\t\32\2\2\u00d6.\3\2\2\2\u00d7\u00d8\t\33\2\2\u00d8\60\3\2\2\2\u00d9"+
		"\u00da\t\34\2\2\u00da\62\3\2\2\2\u00db\u00dc\t\35\2\2\u00dc\64\3\2\2\2"+
		"\u00dd\u00de\t\36\2\2\u00de\66\3\2\2\2\u00df\u00e0\t\37\2\2\u00e08\3\2"+
		"\2\2\u00e1\u00e2\t \2\2\u00e2:\3\2\2\2\u00e3\u00e4\t!\2\2\u00e4<\3\2\2"+
		"\2\u00e5\u00e6\t\"\2\2\u00e6>\3\2\2\2\u00e7\u00e8\t#\2\2\u00e8@\3\2\2"+
		"\2\u00e9\u00ea\5\21\t\2\u00ea\u00eb\5#\22\2\u00eb\u00ec\5\r\7\2\u00ec"+
		"\u00ed\5\61\31\2\u00ed\u00ee\5\61\31\2\u00eeB\3\2\2\2\u00ef\u00f0\5\25"+
		"\13\2\u00f0\u00f1\5#\22\2\u00f1\u00f2\5\61\31\2\u00f2\u00f3\5\25\13\2"+
		"\u00f3D\3\2\2\2\u00f4\u00f5\5\27\f\2\u00f5\u00f6\5\35\17\2\u00f6F\3\2"+
		"\2\2\u00f7\u00f8\5\35\17\2\u00f8\u00f9\5\27\f\2\u00f9H\3\2\2\2\u00fa\u00fb"+
		"\5\35\17\2\u00fb\u00fc\5\'\24\2\u00fcJ\3\2\2\2\u00fd\u00fe\5\35\17\2\u00fe"+
		"\u00ff\5\'\24\2\u00ff\u0100\5\33\16\2\u0100\u0101\5\25\13\2\u0101\u0102"+
		"\5/\30\2\u0102\u0103\5\35\17\2\u0103\u0104\5\63\32\2\u0104\u0105\5\61"+
		"\31\2\u0105L\3\2\2\2\u0106\u0107\5#\22\2\u0107\u0108\5\25\13\2\u0108\u0109"+
		"\5\63\32\2\u0109N\3\2\2\2\u010a\u010b\5#\22\2\u010b\u010c\5)\25\2\u010c"+
		"\u010d\5)\25\2\u010d\u010e\5+\26\2\u010eP\3\2\2\2\u010f\u0110\5+\26\2"+
		"\u0110\u0111\5)\25\2\u0111\u0112\5)\25\2\u0112\u0113\5#\22\2\u0113R\3"+
		"\2\2\2\u0114\u0115\5\63\32\2\u0115\u0116\5\33\16\2\u0116\u0117\5\25\13"+
		"\2\u0117\u0118\5\'\24\2\u0118T\3\2\2\2\u0119\u011a\59\35\2\u011a\u011b"+
		"\5\33\16\2\u011b\u011c\5\35\17\2\u011c\u011d\5#\22\2\u011d\u011e\5\25"+
		"\13\2\u011eV\3\2\2\2\u011f\u0120\5\21\t\2\u0120\u0121\5\r\7\2\u0121\u0122"+
		"\5\61\31\2\u0122\u0123\5\25\13\2\u0123X\3\2\2\2\u0124\u0125\5\25\13\2"+
		"\u0125\u0126\5\61\31\2\u0126\u0127\5\r\7\2\u0127\u0128\5\21\t\2\u0128"+
		"Z\3\2\2\2\u0129\u012a\5)\25\2\u012a\u012b\5\27\f\2\u012b\\\3\2\2\2\u012c"+
		"\u012d\5\'\24\2\u012d\u012e\5\25\13\2\u012e\u012f\59\35\2\u012f^\3\2\2"+
		"\2\u0130\u0131\5\35\17\2\u0131\u0132\5\61\31\2\u0132\u0133\5\67\34\2\u0133"+
		"\u0134\5)\25\2\u0134\u0135\5\35\17\2\u0135\u0136\5\23\n\2\u0136`\3\2\2"+
		"\2\u0137\u0138\5\'\24\2\u0138\u0139\5)\25\2\u0139\u013a\5\63\32\2\u013a"+
		"b\3\2\2\2\u013b\u013c\7v\2\2\u013c\u013d\5/\30\2\u013d\u013e\5\65\33\2"+
		"\u013e\u013f\5\25\13\2\u013f\u0147\3\2\2\2\u0140\u0141\7h\2\2\u0141\u0142"+
		"\5\r\7\2\u0142\u0143\5#\22\2\u0143\u0144\5\61\31\2\u0144\u0145\5\25\13"+
		"\2\u0145\u0147\3\2\2\2\u0146\u013b\3\2\2\2\u0146\u0140\3\2\2\2\u0147d"+
		"\3\2\2\2\u0148\u014a\5\3\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014cf\3\2\2\2\u014d\u0153\4C\\\2\u014e"+
		"\u0152\5\5\3\2\u014f\u0152\5\3\2\2\u0150\u0152\7a\2\2\u0151\u014e\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154h\3\2\2\2\u0155\u0153\3\2\2\2"+
		"\u0156\u015c\4c|\2\u0157\u015b\5\5\3\2\u0158\u015b\5\3\2\2\u0159\u015b"+
		"\7a\2\2\u015a\u0157\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b"+
		"\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015dj\3\2\2\2"+
		"\u015e\u015c\3\2\2\2\u015f\u0160\7=\2\2\u0160l\3\2\2\2\u0161\u0162\7?"+
		"\2\2\u0162\u0163\7@\2\2\u0163n\3\2\2\2\u0164\u0165\7*\2\2\u0165p\3\2\2"+
		"\2\u0166\u0167\7+\2\2\u0167r\3\2\2\2\u0168\u0169\7<\2\2\u0169t\3\2\2\2"+
		"\u016a\u016b\7B\2\2\u016bv\3\2\2\2\u016c\u016d\7.\2\2\u016dx\3\2\2\2\u016e"+
		"\u016f\7-\2\2\u016fz\3\2\2\2\u0170\u0171\7/\2\2\u0171|\3\2\2\2\u0172\u0173"+
		"\7,\2\2\u0173~\3\2\2\2\u0174\u0175\7\61\2\2\u0175\u0080\3\2\2\2\u0176"+
		"\u0177\7\u0080\2\2\u0177\u0082\3\2\2\2\u0178\u0179\7>\2\2\u0179\u0084"+
		"\3\2\2\2\u017a\u017b\7?\2\2\u017b\u0086\3\2\2\2\u017c\u017d\7}\2\2\u017d"+
		"\u0088\3\2\2\2\u017e\u017f\7\177\2\2\u017f\u008a\3\2\2\2\u0180\u0181\7"+
		"\60\2\2\u0181\u008c\3\2\2\2\u0182\u0183\7>\2\2\u0183\u0184\7?\2\2\u0184"+
		"\u008e\3\2\2\2\u0185\u0186\7>\2\2\u0186\u0187\7/\2\2\u0187\u0090\3\2\2"+
		"\2\u0188\u018a\t$\2\2\u0189\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0189"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\bI\2\2\u018e"+
		"\u0092\3\2\2\2\u018f\u0193\7$\2\2\u0190\u0192\5\7\4\2\u0191\u0190\3\2"+
		"\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"\u0196\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0197\7$\2\2\u0197\u01c8\bJ\3"+
		"\2\u0198\u019c\7$\2\2\u0199\u019b\5\7\4\2\u019a\u0199\3\2\2\2\u019b\u019e"+
		"\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a0\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019f\u01a1\7^\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\2\2\3\u01a3\u01c8\bJ\4\2\u01a4"+
		"\u01a8\7$\2\2\u01a5\u01a7\5\7\4\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2"+
		"\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01ab\u01ac\7\f\2\2\u01ac\u01c8\bJ\5\2\u01ad\u01c0\7$\2"+
		"\2\u01ae\u01b0\5\7\4\2\u01af\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af"+
		"\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4"+
		"\u01b6\7^\2\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7\u01bb\7\2\2\2\u01b8\u01ba\5\7\4\2\u01b9\u01b8\3\2\2\2\u01ba"+
		"\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bf\3\2"+
		"\2\2\u01bd\u01bb\3\2\2\2\u01be\u01b1\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0"+
		"\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2"+
		"\2\2\u01c3\u01c5\t%\2\2\u01c4\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6"+
		"\u01c8\bJ\6\2\u01c7\u018f\3\2\2\2\u01c7\u0198\3\2\2\2\u01c7\u01a4\3\2"+
		"\2\2\u01c7\u01ad\3\2\2\2\u01c8\u0094\3\2\2\2\u01c9\u01ca\7/\2\2\u01ca"+
		"\u01cb\7/\2\2\u01cb\u01cf\3\2\2\2\u01cc\u01ce\5\13\6\2\u01cd\u01cc\3\2"+
		"\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d2\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01de\7\f\2\2\u01d3\u01d4\7/"+
		"\2\2\u01d4\u01d5\7/\2\2\u01d5\u01d9\3\2\2\2\u01d6\u01d8\5\13\6\2\u01d7"+
		"\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2"+
		"\2\2\u01da\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01de\7\2\2\3\u01dd"+
		"\u01c9\3\2\2\2\u01dd\u01d3\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\bK"+
		"\2\2\u01e0\u0096\3\2\2\2\u01e1\u01e2\7*\2\2\u01e2\u01e3\7,\2\2\u01e3\u01e8"+
		"\3\2\2\2\u01e4\u01e7\5\u0097L\2\u01e5\u01e7\5\t\5\2\u01e6\u01e4\3\2\2"+
		"\2\u01e6\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9"+
		"\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ec\7,\2\2\u01ec"+
		"\u01ed\7+\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01f0\7\2\2\3\u01ef\u01ee\3\2"+
		"\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\bL\2\2\u01f2"+
		"\u0098\3\2\2\2\u01f3\u01f4\7*\2\2\u01f4\u01f5\7,\2\2\u01f5\u01fb\3\2\2"+
		"\2\u01f6\u01fa\5\u0097L\2\u01f7\u01fa\5\u0099M\2\u01f8\u01fa\5\t\5\2\u01f9"+
		"\u01f6\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd\3\2"+
		"\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd"+
		"\u01fb\3\2\2\2\u01fe\u01ff\7\2\2\3\u01ff\u0200\bM\7\2\u0200\u009a\3\2"+
		"\2\2\u0201\u0202\7,\2\2\u0202\u0203\7+\2\2\u0203\u0205\3\2\2\2\u0204\u0206"+
		"\7\2\2\3\u0205\u0204\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0208\bN\b\2\u0208\u009c\3\2\2\2\u0209\u020a\13\2\2\2\u020a\u020b\bO"+
		"\t\2\u020b\u009e\3\2\2\2\37\2\u00aa\u00b1\u0146\u014b\u0151\u0153\u015a"+
		"\u015c\u018b\u0193\u019c\u01a0\u01a8\u01b1\u01b5\u01bb\u01c0\u01c4\u01c7"+
		"\u01cf\u01d9\u01dd\u01e6\u01e8\u01ef\u01f9\u01fb\u0205\n\b\2\2\3J\2\3"+
		"J\3\3J\4\3J\5\3M\6\3N\7\3O\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}