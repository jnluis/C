import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class StrLangMain {
   public static void main(String[] args) {
      try {
         if( args.length !=1){
            System.out.println("Usage: java StrLangMain <path2file>");
            System.exit(1);
         }
         File f = new File(args[0]);
         if (!f.exists()) {
            System.err.println("ERROR: file does not exist");
            System.exit(0);
         }
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(new FileInputStream(args[0]));
         // create a lexer that feeds off of input CharStream:
         StrLangLexer lexer = new StrLangLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         StrLangParser parser = new StrLangParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at main rule:
         ParseTree tree = parser.main();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            VIntepreter visitor0 = new VIntepreter();
            visitor0.visit(tree);
         }
      }
      catch(IOException e) {
         System.err.println("ERROR: invalid file \""+ args[0]);
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
