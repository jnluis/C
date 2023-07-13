import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")

public class Execute extends NumbersTransBaseListener {
   HashMap<String, Integer> dict;

   public Execute() {
      this.dict = new HashMap<String, Integer>();
   }

   @Override public void exitLineAssoc(NumbersTransParser.LineAssocContext ctx) {
      Integer num = Integer.parseInt(ctx.Number().getText());
      String textDesc = ctx.Word().getText();
      this.dict.put(textDesc, num);
   }

   public HashMap getMap() {
      return this.dict;
   }

 
}
