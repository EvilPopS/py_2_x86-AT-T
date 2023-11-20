grammar PyAtHome;


@parser::members {
	 static class ContextExtention extends ParserRuleContext {
		protected int refToSymTab;
		public ContextExtention(ParserRuleContext parent, int invokingState) {
			 super(parent, invokingState);
			 refToSymTab = -1;
	 	}
		public void setRefToSymTab(int ref) {
			this.refToSymTab = ref;
		}
		public int getRefToSymTab() {
			return this.refToSymTab;
		}
	}
}

options {
  contextSuperClass=ContextExtention;
}

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
    : ID ASSIGN numExpression
    ;

numExpression
    : expression
    | numExpression addSubOperators numExpression
    ;

addSubOperators
    : PLUS
    ;

expression
    : literal
    | ID
    ;

literal
    : INTEGER
    | FLOAT
    | BOOLEAN
    ;
/* Parser rules - END */


/* Lexer rules - START */
WS_SKIP: [ \r]+ -> skip;
COMMENT_SKIP: '#'~[\n]* -> skip;

NEWLINE: '\n' ;

ASSIGN: '=' ;
PLUS: '+' ;

BOOLEAN
    : 'True'
    | 'False'
    ;

ID: [a-zA-Z_][a-zA-Z0-9_]* ;

FLOAT
    : ([1-9][0-9]*)?'.'[0-9]+
    | [1-9][0-9]*'.'[0-9]*
    ;
INTEGER
    : [0-9]+
    ;
/* Lexer rules - END */
