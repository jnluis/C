grammar CalcFrac;

program:
    stat* EOF;

stat:
    ((assignment | print) ';') 
    ;
assignment:
    expr '->' ID
    ;
print:
    'print' expr
    ;
expr:
    '-' expr                        #ExprNeg
    | expr op=('*'|':'|'%') expr    #ExprMultDivMod
    | expr op=('+'|'-') expr        #ExprAddSub
    | Integer '/' Integer           #ExprIntegerRat
    | 'reduce' expr				    # ExprReduce
    | <assoc = right> expr '^' expr # ExprPoten
    | ID                            #ExprID
    | Integer                       #ExprInteger
    | '(' expr ')'                  #ExprParent
	| 'read' String 		        # ExprRead
    ;

ID: [a-zA-Z]+;
String: '"' .*? '"';
Integer: [0-9]+; //implement with long integers
/*NEWLINE: '\r'? '\n';*/
COMMENT: '//' .*? '/r'?'\n' -> skip;
WS: [ \t\r\n]+ -> skip;
