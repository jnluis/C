grammar Hello ;              // Define a grammar called Hello
order: command +;
command : greetings | goodbyes ;        // Define a rule called command that matches greetings
greetings : 'hello' ID ;                // match keyword hello followed by an identifier
goodbyes : 'bye' ID ;               // match keyword goodbye followed by an identifier
ID : [a-zA-Z]+ ;                        // match lower-case identifiers        
WS : [ \t\r\n]+ -> skip ;               // skip spaces, tabs, newlines, \r (Windows)