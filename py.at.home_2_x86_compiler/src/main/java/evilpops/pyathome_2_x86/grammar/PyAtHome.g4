grammar PyAtHome;


tokens { INDENT, DEDENT, INVALID_DENT }


@lexer::members {
private final IndentationTracker indentTracker = new IndentationTracker();

@Override
public Token nextToken() {
	Token tk = indentTracker.sendDentTokenIfNeeded(this.getLine());
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
    : NEWLINE* statementsList? simpleStatement? INVALID_DENT? EOF
    ;

statementsList
    : statement+
    ;

statement
    : simpleStatement NEWLINE+
    | compoundStatement NEWLINE*
    ;

simpleStatement
    : assignStatement
    | multiAssignStatement
    | returnStatement
    | continueStatement
    | breakStatement
    | passStatement
    | printFunctionCall
    | functionCall
    ;

compoundStatement
    : functionDef
    | whileElseStatement
    | ifElifElseStatement
    ;

assignStatement
    : ID varType? ASSIGN complexExpression
    ;

multiAssignStatement
    : multiAssignIdPart ASSIGN multiAssignNumExpPart
    ;

multiAssignIdPart
    : multiAssignId (COMMA multiAssignId)+
    ;

multiAssignId
    : ID varType?
    ;

multiAssignNumExpPart
    : multiAssignNumExpression (COMMA multiAssignNumExpression)+
    ;

multiAssignNumExpression
    : complexExpression
    ;

returnStatement
    : RETURN complexExpression
    | RETURN
    ;

continueStatement
    : CONTINUE
    ;

breakStatement
    : BREAK
    ;

passStatement
    : PASS
    ;

printFunctionCall
    : INBUILT_PRINT_FUNC L_PAREN complexExpression R_PAREN
    ;

functionDef
    : functionDeclaration INDENT statementsList DEDENT
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
    : ID varType? ASSIGN complexExpression
    | paramDefVal COMMA paramDefVal
    ;

whileElseStatement
    : whileStatPart elseStatPart?
    ;

whileStatPart
    : whileConditionPart nonTerminalBlock
    ;

whileConditionPart
    : WHILE complexExpression COLON NEWLINE
    ;

ifElifElseStatement
    : ifStatPart elifStatPart* elseStatPart?
    ;

ifStatPart
    :  ifConditionPart terminalBlock
    ;

ifConditionPart
    : IF complexExpression COLON NEWLINE
    ;

elifStatPart
    : elifConditionPart terminalBlock
    ;

elifConditionPart
    : ELIF complexExpression COLON NEWLINE
    ;

elseStatPart
    : ELSE COLON NEWLINE terminalBlock
    ;

nonTerminalBlock
    : block
    ;

terminalBlock
    : block
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

complexExpression
    : simpleExpression
    | L_PAREN complexExpression R_PAREN
    | complexExpression mulDivOperators complexExpression
    | complexExpression addSubOperators complexExpression
    | complexExpression relOperators complexExpression
    | complexExpression logicAndOperator complexExpression
    | complexExpression logicOrOperator complexExpression
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

simpleExpression
    : literal
    | funcCallExpression
    | ID
    ;

funcCallExpression
    : functionCall
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
    : argNumExpression
    | nonIdArgs COMMA nonIdArgs
    ;

idArgs
    : ID ASSIGN argNumExpression
    | idArgs COMMA idArgs
    ;

argNumExpression
    : complexExpression
    ;

literal
    : integerLiteral
    | floatLiteral
    | BOOLEAN
    | STRING
    | NONE
    ;

integerLiteral
    : INTEGER
    | MINUS+ INTEGER
    ;

floatLiteral
    : FLOAT
    | MINUS+ FLOAT
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
PASS: 'pass';
CONTINUE: 'continue';
BREAK: 'break';
INBUILT_PRINT_FUNC: 'print';

WHILE: 'while';
IF: 'if';
ELIF: 'elif';
ELSE: 'else';

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
    : ([1-9][0-9]*)?'.'[0-9]+
    | [1-9][0-9]*'.'[0-9]*
    | [0-9]'.'[0-9]*
    ;

INTEGER
    : [1-9][0-9]+
    | [0-9]
    ;

STRING
    : '"'(~["\\\n]|'\\'.)*'"'
    | '\''(~['\\\n]|'\\'.)*'\''
    ;
/* Lexer rules - END */
