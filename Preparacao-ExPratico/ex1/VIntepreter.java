import java.util.Scanner;
import java.util.HashMap;

public class VIntepreter extends StrLangBaseVisitor<String> {
   HashMap<String,String> vars = new HashMap<>();
   Scanner sc = new Scanner(System.in);

   @Override public String visitPrintSTAT(StrLangParser.PrintSTATContext ctx) {
      String print_stat = visit(ctx.expr());;
      System.out.println("\"" +print_stat + "\"");
      return null;
   }

   @Override public String visitInputAssign(StrLangParser.InputAssignContext ctx) {
      String varName = ctx.ID().getText();
      String value = "";

      System.out.print(ctx.STRING().getText()+ "? : ");
      if(sc.hasNext()){
         value = sc.next();
         vars.put(varName,value);
      }
      else{
         System.out.println("No input");
      }
      
      return null;
   }

   @Override public String visitNormalAssign(StrLangParser.NormalAssignContext ctx) {
      String varName = ctx.ID().getText();
      if (visit(ctx.expr()).isEmpty()){
         System.out.println("Trying to assign a empty string to a variable");
      }
         
      vars.put(varName,visit(ctx.expr()));
      
      return visitChildren(ctx);
   }

   // @Override public String visitAssign(StrLangParser.AssignContext ctx) {
   //    String res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }
   @Override public String visitAddExpr(StrLangParser.AddExprContext ctx) {
      String String1 = visit(ctx.expr(0)); 
      String String2 = visit(ctx.expr(1));

      return String1 + String2;
   }

   @Override public String visitSubExpr(StrLangParser.SubExprContext ctx) {
      String String1 = visit(ctx.expr(0)); 
      String String2 = visit(ctx.expr(1));

      return String1.replace(String2, "");
   }

   @Override public String visitTrimExpr(StrLangParser.TrimExprContext ctx) {
      String res = visit(ctx.expr()); 
      return res.trim();
   }

   @Override public String visitPareExpr(StrLangParser.PareExprContext ctx) {
      return visit(ctx.expr()); 
   }

   @Override public String visitReplaceExpr(StrLangParser.ReplaceExprContext ctx) {
      String var = visit(ctx.expr(0)); 
      String exprToRemove = visit(ctx.expr(1));
      String exprToReplace = visit(ctx.expr(2));

      return var.replace(exprToRemove,exprToReplace);
   }

   @Override public String visitIdExpr(StrLangParser.IdExprContext ctx) {
       if (!vars.containsKey(ctx.getText())){
         System.err.println("The following  variable hasnt been declared  -> " + ctx.getText());
         System.exit(0);
      }
      return vars.get(ctx.getText());
   }

   @Override public String visitStringExpr(StrLangParser.StringExprContext ctx) {
      return ctx.getText().replace("\"","");
      //return res;
   }
}
