@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitCommand(HelloParser.CommandContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      String res = null;
      System.out.println("Boassss "+ctx.ID().getText());
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitGoodbyes(HelloParser.GoodbyesContext ctx) {
      String res = null;
      System.out.println("Foste embora "+ctx.ID().getText());
      return visitChildren(ctx);
      //return res;
   }
}
