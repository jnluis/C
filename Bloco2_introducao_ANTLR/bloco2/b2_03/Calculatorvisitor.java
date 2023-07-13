@SuppressWarnings("CheckReturnValue")
public class Calculatorvisitor extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      if(ctx.expr() != null){
         Integer res = visit(ctx.expr());
         if(res!= null){
            System.out.println(res);
         }        
      }
      //return visitChildren(ctx);
      return 0;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      String Op = ctx.op.getText();
      Integer n1= visit(ctx.expr(0));
      Integer n2= visit(ctx.expr(1));


      switch (Op) {
         case "+":
            return n1 + n2;
         case "-":
            return n1 - n2; 
         default:
            return null;
      }
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Integer visitExprNeg(CalculatorParser.ExprNegContext ctx) {
      Integer res = visit(ctx.expr());
      Integer resl= Integer.parseInt("-"+res);
      return resl;
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      String Op = ctx.op.getText();
      Integer n1= visit(ctx.expr(0));
      Integer n2= visit(ctx.expr(1));


      switch (Op) {
         case "*":
            return n1 * n2;
         case "/":
            if (n2 == 0) {
               System.out.println("Division by zero");
               return null;
            }
            return n1 / n2;
         case "%":
            return n1 % n2;
         default:
            return null;
         }
      }
}