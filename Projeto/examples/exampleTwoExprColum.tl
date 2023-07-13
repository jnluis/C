
type table ATable {
   number: integer;
   name: text -> "Name:"; -- the final [optional] part indicates the textual view of the column (that is, what must be printed as the header of the table)
   price: real -> "Price:";
   peso: real -> "Peso:";
   caixaPeso: real;
   precoXpeso: real := price*peso; -- defined as a formula!
   pesoSF: real := peso-caixaPeso;
};

t: ATable;
t := new; -- new empty table

[0,"Maça",2.99,10.1,0.5] >> t;
[1,"Pessgo",3.99,13.1,0.3] >> t;
[2,"amexa",1.99,11.1,0.7] >> t;

println t;