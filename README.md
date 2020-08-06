# COOL Compiler #
===============================================================================
## Program Structure ##
===============================================================================

The Lexer implemented has mainly three sections. They are :

1. TOKENS
2. MEMBERS
3. RULES

***Kindly Note the following point***

- While reporting the error, I am reporting the starting line number of the token. 

## Tokens : ##
- The given skeleton code already contains "tokens". They are not modified as per given instructions.
- The lexer rules for these tokens are present in the RULES section.
## Members : ##
- The section members contains methods or functions to process strings, characters, etc.
- The functions present here are reportError(), processString(), processInvalidCharacter(), processInvalidString().
### reportError() :- ###
- This function is used to Report the errors in the test files and also passes them to the parser.
- It is not modified as it is mentioned in the file.
###  processString() :- ###
- This method processes the terminated strings (with no null character) by converting escape characters in string constants to their correct values.

```
Ex: if given STR_CONST is "ab\ncd" then instead of taking '\' and 'n' as two characters, we are converting it to single character '\n'.
```
 
- Also reporting the error "String constant too long" if string is long.
###  processInvaldCharacter() :- ###
- This method processes the invalid characters which can't begin any token. And this character is reported as error string.
### processInvalidString() :- ###
- This method processes the invalid strings (unterminated/EOF/containing null char) and reports the corresponding errors.
## RULES : ##
- Lexer rules specify token definitions or rules that helps in recognizing tokens. All these rules should be in uppercase.
- There are some protected rules called "Fragments", which are reusable parts of lexer rules. They can't match on their own, they need to be referenced from a lexer rule.
- The ANTLR tokenize the elements in the following way. It first checks for the rule that matches the longest input. If there are more than one such rules, then the rule which is defined first is considered.

- The Design rules for all the keywords, Identifiers, constants etc are explained below.

===============================================================================

### Design Rules ###

===============================================================================
### - - - - - - - - - - - - - - - - - Design rules for Keywords - - - - - - - - - - - - - - - - - - ###
1. All Keywords except 'true' and 'false' are case insensitive. 
2. So to become easy to write rules, defined fragments. 'A' indicates either 'a' or 'A'.
   ```
   Ex: fragment A : [aA];
   ```
3. The definition for keywords will be

CLASS : C L A S S 

whereas for 'true' and 'false' will be

BOOL_CONST : 't' R U E | 'f' A L S E

(As they should be recognised as a BOOL_CONST.)
### - - - - - - - - - - - - - - - - - Design rules for Identifiers - - - - - - - - - - - - - - - - - - ###
- Object identifiers begin with a lower case letter and Type identifiers begin with a upper case letter. So they are defined as follows:
  ```
  TYPEID      : ('A'..'Z')(ALPHA|DIGIT|'_')* ;

  OBJECTID    : ('a'..'z')(ALPHA|DIGIT|'_')* ;
  ```
- Where the fragments ALPHA and DIGIT are uppercase or lower case alphabet, digit from 0-9 respectively.
### - - - - - - - - - - - - - - - - - Design rules for Operators - - - - - - - - - - - - - - - - - - ###
- The rules for Operators, Paranthesis and Braces are simple as their names suggest. One example is shown below.
  ```
  Ex: PLUS : '+' ;
  ```
### - - - - - - - - - - - - - - - - - Design rules for Constants - - - - - - - - - - - - - - - - - - ###
### Integer constant : ###
- The rule for integers is :
  ```
  INT_CONST   : DIGIT+;
  ```
  where the fragment DIGIT is a digit from 0-9.
### String constant : ###
- Here the fragment IN_STR is basically a string body (one between two double quotes) or the valid characters a string body can have. 

- So if a valid string is encountered, we call the method "processString()" to process the string and safely tokenized as a STR_CONST. The definition is as follows.
  ```
  STR_CONST    : ('"') IN_STR* ('"') {processString() ;}
  ```
- Or if either end of file is reached or null char encounters or newline encounters, then we call the method "processInvalidString()" to report the corresponding errors.
- Here as '\\' is not considered in the fragment IN_STR, but it is valid to come before a null char and at end of file.
- Also in case of null chars, the string may have multiple null chars. And string may be terminated/unterminated/EOF. 
- Keeping the above points, The definitions are written as follows:
  ```
  ('"') IN_STR*('\\')?(EOF) {processInvalidString();}

  ('"') IN_STR*('\n') {processInvalidString();}

  ('"') (IN_STR*('\\')?('\u0000') IN_STR*)* ('"' | '\n' | (EOF)) {processInvalidString();}
  ```
### - - - - - - - - - - - - - - - - - Design rules for Comments - - - - - - - - - - - - - - - - - ###
### Single line comment : ###
- The fragment IN_SINGLE_COMMENT is the valid chars a single line comment can have. As we know the single line comment donot contain a new line. It is as follows:
  ```
  fragment IN_SINGLE_COMMENT : ~('\n');
  ```
- It may end with a new line or end of file may be reached (both are valid) so we skip them and definition is as follows:
  ```
  SINGLE_LINE_COMMENT	: ('--' IN_SINGLE_COMMENT* '\n' 		
  | '--' IN_SINGLE_COMMENT* (EOF))  -> skip;
  ```
### Multi line comment : ###
- The fragment IN_COMMENT is the valid chars a multi line comment can have in their body (between (* and *) ). As we the body shouldn't contain (\* and \*), it is defined as follows:
  ```
  fragment IN_COMMENT : (~('(' | '*' | ')')  | ('*'~(')')) | ('('~('*')));
  ```
- If a valid comment occurs the we simply skip it. As the multi line comment can be nested, The recursive definition is as follows:
  ```
  MULTI_LINE_COMMENT  : '(*' (MULTI_LINE_COMMENT|IN_COMMENT)* '*)' (EOF)? -> skip;
  ```
- If end of file is reached in between then reporting the error "EOF in comment". As nested ones may also ends in between, the recursive definition is as follows:

  ```
   ERROR_IN_MULTI_LINE	: '(*' (MULTI_LINE_COMMENT | ERROR_IN_MULTI_LINE| IN_COMMENT)* (EOF) {reportError("EOF in comment");};
  ```

- At this stage if *) this encounters it is clear that it is unmatched. If it would have matched then it would have been matched with the earlier definitions. So reporting error as "Unmatched *)". The definition is as follows:
  ```
  ERR_IN : '*)' (EOF)? {reportError("Unmatched *)");};
  ```
### - - - - - - - - - - - - - - - - Design rules for White spaces - - - - - - - - - - - - - - - - ###
- The white spaces like spaces, tabspace, newline, carriage return etc have to skipped. So the definition for this is as follows:

  ```
  WHITESPACE  : (' ' | '\t' | '\n' | '\r' | '\u000b' | '\b' | '\f')+ -> skip;
  ```
### - - - - - - - - - - - - - - Design rules for Invalid Characters - - - - - - - - - - - - - - ###
- This rule is written at the end of file so as to catch all the characters which can't begin any token. Whenever they are encountered we call the method "processInvalidCharacter()" which reports this character as error token. The definition is as follows:
  ```
  INVALID_CHARACTER	: . {processInvalidCharacter();};
  ```

===============================================================================

### Testing ###

===============================================================================

I have provided 6 test files, which will cover almost all the corner cases. I have conducted many tests on my code to ensure correctness. Also all the errors are reported same as the ones reported by coolc.
