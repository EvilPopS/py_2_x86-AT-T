grammar PyAtHome;


tokens { INDENT, DEDENT }


@lexer::members {
private final IndentationTracker indentTracker = new IndentationTracker();

@Override
public Token nextToken() {
	Token tk = indentTracker.sendDentTokenIfNeeded();
    if (tk != null)
        return tk;

    tk = super.nextToken();
    indentTracker.processToken(tk);
    return tk;
}
}

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
    : ID typing? ASSIGN numExpression
    ;

typing
    : COLON types
    ;

types
    : T_INT
    | T_FLOAT
    | T_BOOLEAN
    | T_STRING
    | T_NONE
    ;

numExpression
    : expression
    | L_PAREN numExpression R_PAREN
    | numExpression mulDivOperators numExpression
    | numExpression addSubOperators numExpression
    | numExpression relOperators numExpression
    | numExpression logicAndOperator numExpression
    | numExpression logicOrOperator numExpression
    ;

addSubOperators
    : PLUS
    | MINUS
    ;

mulDivOperators
    : MUL
    | DIV
    ;

relOperators
    : EQ
    | NEQ
    | GR
    | LS
    | GREQ
    | LSEQ
    ;

logicAndOperator
    : AND
    ;

logicOrOperator
    : OR
    ;

expression
    : literal
    | ID
    ;

literal
    : INTEGER
    | FLOAT
    | BOOLEAN
    | STRING
    ;

/* Parser rules - END */


/* Lexer rules - START */

WS_SKIP: [ \r\t]+ -> skip;
COMMENT_SKIP: '#'~[\n]* -> skip;

NEWLINE
    : '\n'[ \n\t\r]*'\n'[ \t]+
    | '\n'[ \n\t\r]*'\n'
    | '\n'[ \t]+
    | '\n'
    ;

T_INT: 'int';
T_FLOAT: 'float';
T_BOOLEAN: 'bool';
T_STRING: 'str';
T_NONE: 'None';

COLON
    : ':'
    ;

ASSIGN: '=' ;

L_PAREN: '(';
R_PAREN: ')';

PLUS: '+' ;
MINUS: '-' ;
MUL: '*' ;
DIV: '/' ;

EQ: '==';
NEQ: '!=';
GR: '>';
LS: '<';
GREQ: '>=';
LSEQ: '<=';

AND: 'and';
OR: 'or';

BOOLEAN
    : 'True'
    | 'False'
    ;

ID: [a-zA-Z_][a-zA-Z0-9_]* ;

FLOAT
    : '-'?([1-9][0-9]*)?'.'[0-9]+
    | '-'?[1-9][0-9]*'.'[0-9]*
    ;
INTEGER
    : '-'?[0-9]+
    ;

STRING
    : '"'(~["\\\n]|'\\'.)*'"'
    | '\''(~['\\\n]|'\\'.)*'\''
    ;
/* Lexer rules - END */
