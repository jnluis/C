grammar StrLang;

main: stat* EOF;

stat: assign        #assignSTAT
    | 'print' expr  #printSTAT
    ;

assign: ID ':' 'input(' STRING ')' #InputAssign
    | ID ':' expr #NormalAssign
    ;

expr: expr '+' expr             #addExpr
    | expr '-' expr             #subExpr
    | 'trim' expr               #trimExpr
    | '(' expr ')'              #pareExpr
    | expr '/' expr '/' expr    #replaceExpr
    | ID                        #idExpr
    | STRING                    #stringExpr
    ;


STRING: '"' .*? '"' ;
ID: [a-zA-Z_][a-zA-Z0-9_]*; // ID must start with a letter or underscore
WS: [ \t\r\n] -> skip;
COMMENT: '//' .*? '\n' -> skip;