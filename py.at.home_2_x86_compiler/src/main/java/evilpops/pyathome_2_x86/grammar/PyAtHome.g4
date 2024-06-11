grammar PyAtHome;


tokens { INDENT, DEDENT, INVALID_DENT }


@lexer::members {
private final IndentationTracker indentTracker = new IndentationTracker();

@Override
public Token nextToken() {
	Token tk = indentTracker.sendDentTokenIfNeeded(this.getLine());
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
    : NEWLINE? statementsList simpleStatement? INVALID_DENT? EOF
    ;

statementsList
    : statement+
    ;

statement
    : simpleStatement NEWLINE
    | compundStatement
    ;

simpleStatement
    : assignStatement
    | returnStatement
    | functionCall
    ;

compundStatement
    : functionDef
    ;

assignStatement
    : ID varType? ASSIGN numExpression
    ;

returnStatement
    : RETURN numExpression
    | RETURN
    ;

functionDef
    : functionDeclaration block
    ;

functionDeclaration
    : functionIdentifier L_PAREN parameters? R_PAREN retType? COLON NEWLINE
    ;

functionIdentifier
    :  DEF ID
    ;

parameters
    : paramNonDefVal COMMA paramDefVal
    | paramNonDefVal
    | paramDefVal
    ;

paramNonDefVal
    : ID varType?
    | paramNonDefVal COMMA paramNonDefVal
    ;

paramDefVal
    : ID varType? ASSIGN numExpression
    | paramDefVal COMMA paramDefVal
    ;

block
    : INDENT statementsList DEDENT
    ;

retType
    : ARROW types
    ;

varType
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
    | functionCall
    | ID
    ;

functionCall
    : ID L_PAREN arguments? R_PAREN
    ;

arguments
    : nonIdArgs COMMA idArgs
    | nonIdArgs
    | idArgs
    ;

nonIdArgs
    : numExpression
    | nonIdArgs COMMA nonIdArgs
    ;

idArgs
    : ID ASSIGN numExpression
    | idArgs COMMA idArgs
    ;

literal
    : INTEGER
    | FLOAT
    | BOOLEAN
    | STRING
    | NONE
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
RETURN: 'return';

T_INT: 'int';
T_FLOAT: 'float';
T_BOOLEAN: 'bool';
T_STRING: 'str';
T_NONE: 'none';

ARROW: '->';

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

NONE
    : 'None'
    ;

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
