grammar PyAtHome;


tokens { INDENT, DEDENT, INVALID_DENT }


@lexer::members {
private final IndentationTracker indentTracker = new IndentationTracker();

@Override
public Token nextToken() {
	Token tk = indentTracker.sendDentTokenIfNeeded();
    if (tk != null) {
        System.out.println(tk);
        return tk;
    }

    tk = super.nextToken();
    System.out.println(tk);
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
    : simpleStatement (NEWLINE EOF | NEWLINE | EOF)
    | compundStatement
    ;

simpleStatement
    : assignStatement
    ;

compundStatement
    : functionDef
    ;

assignStatement
    : ID typing? ASSIGN numExpression
    ;

functionDef
    : DEF ID L_PAREN parameters? R_PAREN COLON NEWLINE block
    ;

parameters
    : paramNonDefVal COMMA paramDefVal
    | paramNonDefVal
    | paramDefVal
    ;

paramDefVal
    : ID ASSIGN numExpression
    | paramDefVal COMMA paramDefVal
    ;

paramNonDefVal
    : ID
    | paramDefVal COMMA paramNonDefVal
    ;

block
    : INDENT statementsList (DEDENT (INVALID_DENT)? EOF | DEDENT | (INVALID_DENT)? EOF )
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

DEF: 'def';

T_INT: 'int';
T_FLOAT: 'float';
T_BOOLEAN: 'bool';
T_STRING: 'str';
T_NONE: 'None';

COMMA: ',';
COLON: ':';

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
