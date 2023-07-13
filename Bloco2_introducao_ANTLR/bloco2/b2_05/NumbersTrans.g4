grammar NumbersTrans;

program:
    line* EOF // Zero or more repetitions of stat
    ;
line:
    Number '-' Word NEWLINE #LineAssoc
    | NEWLINE               #LineEmpty
    ;

Word: [a-z]+;
Number: [0-9]+; // fixed point real number
NEWLINE: 'r'? '\n';
WS: [ \t]+ -> skip;