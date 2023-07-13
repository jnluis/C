import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class NumbersTransMain {
   public static void main(String[] args) {
      try {

         Path File = Paths.get("numbers.txt");

         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromPath(File);
         // create a lexer that feeds off of input CharStream:
         NumbersTransLexer lexer = new NumbersTransLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         NumbersTransParser parser = new NumbersTransParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         String line,output;
         String split[];
         HashMap map;

         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            Execute listener0 = new Execute();
            walker.walk(listener0, tree);

            map = listener0.getMap();

            Scanner scan = new Scanner(System.in);

            while (scan.hasNextLine()) {
               line = scan.nextLine();
               split = line.split(" |-");
               output = "";
               for (String word : split) {

                  word.trim();

                  if (word.isEmpty())
                     continue;

                  if (map.get(word) == null)
                     output += String.format("%s ", word);
                  else
                     output += String.format("%d ", map.get(word));
               }
               System.out.println(output);
            }
            scan.close();
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
