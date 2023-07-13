@SuppressWarnings("CheckReturnValue")
public class VisitCalc extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      if(ctx.expr() != null){
         Double res = visit(ctx.expr());
         System.out.println(res);
        
      }
      //return visitChildren(ctx);
      return 0.0;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      Double res= Double.parseDouble(ctx.Number().getText());
      return res;
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      String Op = ctx.op.getText();
      Double n1= visit(ctx.expr(0));
      Double n2= visit(ctx.expr(1));


      switch (Op) {
         case "+":
            return n1 + n2;
         case "-":
            return n1 - n2;
         case "*":
            return n1 * n2;
         case "/":
            if (n2 == 0) {
               System.out.println("Division by zero");
               return null;
            }
            return n1 / n2;
         default:
            return null;
      }
   }
}
