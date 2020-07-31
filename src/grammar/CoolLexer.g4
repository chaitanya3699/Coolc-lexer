lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,		
	OBJECTID,	
	BOOL_CONST,	
	INT_CONST,	
	STR_CONST,  
	LPAREN, 	
	RPAREN, 	
	COLON, 		
	ATSYM, 		
	SEMICOLON, 	
	COMMA,		
	PLUS,		
	MINUS,		
	STAR,		
	SLASH,		
	TILDE,		
	LT,			
	EQUALS,		
	LBRACE,		
	RBRACE,		
	DOT,		
	DARROW, 	
	LE,			
	ASSIGN,		
	CLASS, 		
	ELSE,  		
	FI, 		
	IF,			
	IN,			
	INHERITS,	
	LET,		
	LOOP,		
	POOL,		
	THEN,		
	WHILE,		
	CASE,		
	ESAC,		
	OF,			
	NEW,		
	ISVOID,		
	NOT	
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

@members{

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
}

/*
	WRITE ALL LEXER RULES BELOW
*/

//protected rules
fragment DIGIT  : [0-9];
fragment ALPHA  : [A-Za-z];
fragment IN_STR : (~('\u0000' | '\n' | '"' | '\\') | ('\\''\"') | ('\\''\n') | ('\\'~('\u0000')));	//valid chars a string can have inside it
fragment IN_COMMENT : (~('(' | '*' | ')')  | ('*'~(')')) | ('('~('*')));							//valid chars a multi line comment can have inside it
fragment IN_SINGLE_COMMENT : ~('\n');																//valid chars a single line comment can have inside it

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

//Rules for KEYWORDS, CONSTANTS and IDENTIFIERS
CLASS       : C L A S S;
ELSE        : E L S E;
FI          : F I;
IF          : I F;
IN          : I N;
INHERITS    : I N H E R I T S;
LET         : L E T;
LOOP        : L O O P;
POOL        : P O O L;
THEN        : T H E N;
WHILE       : W H I L E;
CASE        : C A S E;
ESAC        : E S A C;
OF          : O F;
NEW         : N E W;
ISVOID      : I S V O I D;
NOT         : N O T;

//CONSTANTS
BOOL_CONST  : 't' R U E | 'f' A L S E ;
INT_CONST   : DIGIT+;

//IDENTIFIERS
TYPEID      : ('A'..'Z')(ALPHA|DIGIT|'_')* ;
OBJECTID    : ('a'..'z')(ALPHA|DIGIT|'_')* ;


//Rules for OPERATORS, PARANTHESIS and BRACES.
SEMICOLON   : ';';
DARROW      : '=>';
LPAREN		: '(' ;
RPAREN		: ')' ;
COLON		: ':' ;
ATSYM		: '@' ;
COMMA		: ',' ;
PLUS		: '+' ;
MINUS		: '-' ;
STAR		: '*' ;
SLASH		: '/' ;
TILDE		: '~' ;
LT			: '<' ;
EQUALS		: '=' ;
LBRACE		: '{' ;
RBRACE		: '}' ;
DOT			: '.' ;
LE  		: '<=' ;
ASSIGN		: '<-' ;

WHITESPACE  : (' ' | '\t' | '\n' | '\r' | '\u000b' | '\b' | '\f')+ -> skip;  //skipping spaces, tabs, newlines.

STR_CONST    : ('"') IN_STR* ('"') {processString() ;}						 //to process a valid string
					| ('"') IN_STR*('\\')?(EOF) {processInvalidString();}	 //to process a string having EOF
					| ('"') IN_STR*('\n') {processInvalidString();}			 //to process a string having unescaped new line
					| ('"') (IN_STR*('\\')?('\u0000') IN_STR*)* ('"' | '\n' | (EOF)) {processInvalidString();} //to process a string having null char
					;

/* comment */
SINGLE_LINE_COMMENT	: ('--' IN_SINGLE_COMMENT* '\n' 						//single line comment
					    | '--' IN_SINGLE_COMMENT* (EOF))  -> skip;

//MULTI LINE COMMENT along with nested comments
MULTI_LINE_COMMENT  : '(*' (MULTI_LINE_COMMENT|IN_COMMENT)* '*)' (EOF)? -> skip; //a valid multi line comment
ERROR_IN_MULTI_LINE	: '(*' (MULTI_LINE_COMMENT|ERROR_IN_MULTI_LINE|IN_COMMENT)* (EOF) {reportError("EOF in comment");}; //comment having EOF in the middle of it
ERR_IN              : '*)' (EOF)? {reportError("Unmatched *)");};           //Unmatched '*)'

INVALID_CHARACTER	: . {processInvalidCharacter();};						//to process a char which can't begin any token is reported.