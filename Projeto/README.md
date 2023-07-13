# Tema **TabLan**, grupo **tablan-06**
-----


████████╗░█████╗░██████╗░██╗░░░░░░█████╗░███╗░░██╗
╚══██╔══╝██╔══██╗██╔══██╗██║░░░░░██╔══██╗████╗░██║
░░░██║░░░███████║██████╦╝██║░░░░░███████║██╔██╗██║
░░░██║░░░██╔══██║██╔══██╗██║░░░░░██╔══██║██║╚████║
░░░██║░░░██║░░██║██████╦╝███████╗██║░░██║██║░╚███║
░░░╚═╝░░░╚═╝░░╚═╝╚═════╝░╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝

## Constituição dos grupos e participação individual global

| NMec | Nome | email | Participação |
|:---:|:---|:---|:---:|
| 105937 | BÁRBARA NÓBREGA GALIZA | barbara.galiza@ua.pt | 16.67% |
| 107969 | JOÃO MIGUEL DIAS ANDRADE | joao.andrade06@ua.pt | 23.33% |
| 107403 | JOÃO NUNO DA SILVA LUÍS | jnluis@ua.pt | 13.33% |
| 107449 | MIGUEL DA SILVA PINTO | miguel.silva48@ua.pt | 13.33% |
| 109986 | PEDRO DANIEL FIDALGO DE PINHO | pd.pinho@ua.pt | 16.67% |
| 109018 | TOMÁS ANTÓNIO DE OLIVEIRA VICTAL | tomasvictal@ua.pt | 16.67% |

## Estrutura do repositório

- **src** - deve conter todo o código fonte do projeto.

- **doc** -- deve conter toda a documentação adicional a este README.

- **examples** -- deve conter os exemplos ilustrativos das linguagens criadas.

    - Estes exemplos devem conter comentários (no formato aceite pelas linguagens),
      que os tornem auto-explicativos.

## Relatório

### **Introdução**

Este trabalho pretende desenvolver uma linguagem de programação compilada que permita a manipulação avançada de tabelas. Para isto estas são definidas como um tipo de dados para além dos tipos de dados elementares como inteiros (*integer*),  reais (*real*) e texto (*text*).

Neste trabalho foram desenvolvidas todas as caraterísticas mínimas solicitadas, listadas a seguir:
- Instrução para definir um novo tipo de dados tabela;
- Os tipo de de dados inteiro, real e texto;
- Aceitar expressões aritméticas standard para os tipos de dados numéricos, aceitando também a operação de concatenação de texto;
- Instrução de escrita no *standard input*;
- Operadores de conversão entre tipos de dados;
- Instrução para adicionar linha no fim de uma tabela;
- Instrução para adicionar cabeçalho à tabela ou a cada coluna da tabela;
- Instrução de iteração (*loop*) das linha de tabelas;
- Verificação semântica do sistema de tipos.

Para além destas caraterística mínimas, desenvolvemos ainda:
- O tipo de dados booleano;
- Operações condicionais com dados booleanos (maior, menor, ...);
- funcionalidade "in line if".

De forma a atingirmos estes objetivos foram desenvolvidas quatro componentes que tratam de cada uma das fases de compilação:
- Gramática principal da linguagem
- Gramática auxiliar ( Leitura de ficheiros .csv )
- Análise Semântica
- Geração de código

### **Linguagem Principal**
A linguagem principal (linguagem TabLan) tem como objetivo a criação e manipulação de tabelas. Para isso, utiliza-se um compilador que faz a tradução dessa para a linguagem Java.

Na linguagem TabLan, existem os tipos real, integer e text, e a possibilidade para criar um tipo de dados para definir a tabela. Para facilitar e padronizar a criação deste último, utilizámos uma class abstrata, AbstractTable, que é herdada pelas classes concretas criadas pelo programador. Na criação da tabela, são definidas as variáveis para as colunas e seus tipos, ou seja, o tipo de dados (real, integer ou text) dos elementos que cada coluna vai conter. Cada coluna pode ser independente ou dependente: as colunas dependentes têm os valores calculados a partir de uma fórmula que utiliza os valores de uma ou mais colunas independentes. Essa fórmula é definida pelo programador, e pode ser qualquer tipo de expressão aritmética, caso seu tipo seja numérico. Também é possível adicionar um cabeçalho a uma coluna e/ou a uma tabela.

Após a criação da tabela, algumas das operações disponíveis sobre esta são: adicionar uma linha com valores, adicionar uma linha vazia, iterar sobre as linhas, impressão, atribuir uma view de outra tabela (muda quando a tabela original é alterada), atribuir uma cópia de outra tabela (não muda quando a tabela original é alterada posterior à atribuição), atribuir os valores lidos de um ficheiro .csv com a utilização da linguagem auxiliar e atribuir valores lidos do standard input.

No caso da adição de uma nova linha, podem ser adicionados valores às colunas independentes, não sendo obrigatório que isto seja feito para todas. Caso uma linha seja adicionada sem atribuir um valor para alguma das colunas, essas colunas ficam com o valor indefinido "null" naquela linha. Além disso, caso exista uma ou mais colunas dependentes, novos valores são automaticamente adicionados a ela(s) quando se adiciona às colunas independentes da qual ela(s) depende(m). 

Por fim, é possível fazer cast entre tipos, declarar variáveis dos tipos real, integer e text fora das tabelas e realizar operações aritméticas sobre elas.

Principais comandos:


Obs: Todos os comandos da linguagem terminam por ";".

```
--                                                   -->   comentário
type table ATable {...};                             -->   cria o tipo de tabela "ATable"
number: integer;*                                    -->   cria a coluna "number" do tipo "integer"
t: ATable;                                           -->   instancia "t" como um objeto do tipo "ATable"
t := new;                                            -->   cria a tabela vazia
t -> "Table:";                                       -->    atribui cabeçalho à tabela
t.number -> "Number:";                               -->    atribui cabeçalho à coluna
["One", c] >> t;                                     -->    adiciona nova linha à tabela
println t;                                           -->    imprime a tabela para o standard output
tt := t.name;                                        -->    atribui uma view da coluna "name" da tabela "t"
ttt := new(t.name);                                  -->   atribui uma copia da coluna "name" da tabela "t"
for elem in t do {...} end;                          -->   itera sobre as linhas da tabela
t2 := read "list1.csv";                              -->     atribui os valores lidos do ficheiro à tabela
[real(read in "n1:"), real(read in "n2:")] >> t;     -->    atribui os valores lidos do standard input a uma nova linha da tabela   

```
\* = Comando utilizado dentro do corpo do comando anterior (criação do tipo de tabela) 

### **Linguagem Auxiliar**
Esta linguagem é utilizada para ler ficheiros .csv, e para isso utiliza um interpretador responsável por guardar as colunas do ficheiro fornecido vão ser num ArrayList. Posteriormente, estas vão ser colocadas numa instância do tipo de dados table, que entretanto foi criada.

### **Análise Semântica**
A análise semântica tem como objetivo verificar se os dados introduzidos tem tanto os seus tipos corretos como também, em caso de criação de variável, não deixar criar variáveis já existentes, sejam elas colunas, tabelas ou variáveis dos tipos real, integer ou text. Além disso, permite verificar se é possível fazer uma operação aritmética, casts, entre outros.

Para esta verificação nós utilizamos 4 mapas diferentes.
Para verificarmos se a coluna que estamos a criar dentro da classe tabela já existe ou não, recorremos à tableColumns. Além disso, utilizamos esta tabela para guardar as colunas que serão acedidas no compilador.
Para a verificação de variáveis já ou não criadas, utilizamos o mapa symbolTable. Desta forma, guardamos tanto o seu nome de variável como outras informações, como o tipo e se o valor já foi ou não definido.
No caso da verificação dos tipos de tabela e para termos acesso a que tipo uma tabela(variável) pertence, então utilizamos o mapa typeTable.
Finalmente, em relação à verificação de fórmulas e o acesso às mesmas, utilizamos o mapa formulaVariables que irá guardar as variáveis (colunas) necessárias para a fórmula utilizada para as colunas dependentes.

A análise semântica também contém um papel muito importante de verificação, no qual a mesma verifica se é possível fazer uma operação entre dois tipos de variáveis, verificando os seus tipos e só executando quando for aceite.

### **Geração de código**
Para gerar o código na linguagem "target", nesse caso o Java, utilizamos a bibllioteca String Template. Em geral, utilizamos uma classe principal e a cada nova instrução (stat) adicionamos à função main da classe. Além disso, a cada criação de tabela definimos uma classe fora da função main, mas dentro da classe principal (inner class). Para definir as colunas dependentes, utilizamos funções criadas no corpo das inner classes.

Utilizamos a documentação presente em: https://github.com/antlr/stringtemplate4/blob/master/doc/cheatsheet.md .

### **Compilação e execução**
Foram criados três ficheiros em bash por forma a compilar e executar o código desenvolvido.
Estes encontram-se na pasta ```examples``` e devem ser corridos pela seguinte ordem:
1. `./build.sh`
2. `./compile.sh <example>` sendo a tag example substituída pelo exemplo que queremos testar
3. `./run.sh` 
 

Se, aquando da execução de qualquer estes ficheiros, o terminal deolver o erro de *permission denied*, deve ser feito `chmod u+x filename `

### **Exemplos a funcionar** 
1. `examples/example1.tl`<br>
Neste primeiro exemplo, é criada uma tabela denominada "ATable" com duas colunas: a primeira do tipo text, sendo especificado o seu nome para "Name:" e uma segunda coluna do tipo integer.
De seguida, esta tabela é inicializada vazia, sendo-lhe atribuída um nome. Posteriormente, é dado o nome "Number:" à coluna do tipo integer.
Neste exemplo, é também criada uma variável que é inserida na tabela, sendo que a linguagem suporta operações com variáveis, pelo que essas operações ocorrem, e os resultados são armazenados em novas linhas da tabela.
Por último, é usado o método `println`, que permite imprimir a tabela.
2. `examples/example2.tl` <br>
No segundo exemplo, para além do que já era possível fazer no primeiro exemplo, é possível também criar novas tabelas com apenas parte das colunas de outras tabelas, mas também criar vistas de uma tabela já existente, pelo que, se a tabela for atualizada, esta view vai também ser atualizada. 
Neste exemplo é também possível iterar sobre uma tabela através da palavra reservada `for`.
Por último, neste exemplo, é utilizado também a leitura de ficheiros .csv, que vai guardar as colunas oriudas do ficheiro nas colunas do tipo de dados table, associada à variável entretanto definida.
3. `examples/example3.tl` <br>
No terceiro exemplo, este tem a caraterística de permitir a introdução de valores reais, que vão ser guardados em variáveis, e a criação de uma coluna dependente, cujos valores são calculados a partir da média dos valores das colunas n1 e n2. Além disso, é utilizada a leitura do standard input para acrescentar novas linhas à tabela.
4. `examples/exampleTwoExprColum.tl` <br>
Neste exemplo demonstramos que o compilador suporta uma tabela com duas colunas que são derivadas de uma expressão das outras colunas.
5. `examples/exampleBool.tl` <br>
Aqui mostramos algumas das funcionalidades extras implementadas, incluindo o use do tipo booleano e o in line if.

### **Exemplos com erros**
1. `examples/exampleErrors1.tl` <br>
Neste primeiro exemplo, podemos observar a semântica a atuar na parte de verificação da classe table já ter sido criada anteriormente com o mesmo nome.
2. `examples/exampleErrors2.tl` <br>
No segundo exemplo, demonstramos que não podemos criar duas variáveis com o mesmo nome.
3. `examples/exampleErrors3.tl` <br> 
No terceiro exemplo, confirmamos que não podemos redefinir/criar uma nova variável com o mesmo nome de uma variável já definida.
4. `examples/exampleErrors4.tl` <br>
Finalmente no último exemplo, a semântica analisa se as colunas têm todas nomes diferentes.

## Contribuições
Nas contribuições individuais, mencionamos as partes gerais do trabalho em que cada um trabalhou, porque existiram partes específicas que tiveram de ser refeitas por outros membros do grupo, pelo que manter o *tracking* dessas contribuições era mais difícil. <br>


+ #### **Bárbara Galiza**
  + Gramática Principal
  + Gr.Principal-Análise-Semântica
  + Geração de código
  + Compilador
  + Relatório
+ #### **João Andrade**
  + Gramática Principal
  + Gr.Principal-Análise-Semântica
  + Gramática Secundária
  + Secundária-Interpretação/Geração de código
  + Geração de código
  + Compilador
+ #### **João Luís**
  + Gramática Principal
  + Compilador
  + Scripts Bash
  + Relatório
+ #### **Miguel Pinto**
  + Gramática Principal
  + Gramática Secundária
  + Java Examples
+ #### **Pedro Pinho**
  + Gramática Principal
  + Gr.Principal-Análise-Semântica
  + Geração de Código
  + Compilador
  + Relatório
  + Java Examples
+ #### **Tomás Victal**
  + Gramática Principal
  + Gr.Principal-Análise-Semântica
  + Geração de código
  + Compilador
  + Java Examples

Lista completa de tópicos: <br>
1. Gramática Principal  <br>
2. Gr.Principal-Análise-Semântica  <br>
3. Gramática Secundária  <br>
4. Secundária-Interpretação/Geração de código <br>
5. Geração de código <br>
6. Compilador <br>
7. Scripts Bash <br>
8. Relatório <br>
9. Java Examples <br>
<br>
