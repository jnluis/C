grammar CalculatorVar;

program:
    stat* EOF;

stat:
    expr? NEWLINE                #ExprStat   
    | ID '=' expr NEWLINE        #AssignStat
    ;  

assignment:
    ID '=' expr NEWLINE         
    ;

expr:
    '-' expr                      #ExprNeg
    | expr op=('*'|'/'|'%') expr  #ExprMultDivMod
    | expr op=('+'|'-') expr      #ExprAddSub
    | Integer                     #ExprInteger
    | ID                          #ExprID
    | '(' expr ')'                #ExprParent
    ;

Integer: [0-9]+; //implement with long integers
ID: [a-zA-Z-]+;  
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;