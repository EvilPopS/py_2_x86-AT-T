grammar PyAtHome;

/* Parser rules - START */
program
    : statementsList
    ;

statementsList
    : statement+
    ;

statement
    : simpleStatement NEWLINE
    | simpleStatement EOF
    ;

simpleStatement
    : assignStatement
    ;

assignStatement
    : ID ASSIGN NUMBER
    ;
/* Parser rules - END */


/* Lexer rules - START */
WS_SKIP: [ \r]+ -> skip;
COMMENT_SKIP: '#'~[\n]* -> skip;

NEWLINE: '\n' ;

ASSIGN: '=' ;

ID: [a-zA-Z_][a-zA-Z0-9_]* ;

NUMBER
    : ([1-9][0-9]*)?'.'[0-9]+
    | [1-9][0-9]*'.'[0-9]*
    | [0-9]+
    ;
/* Lexer rules - END */
