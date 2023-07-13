import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CalcFracBaseVisitor<Fraction> {

   HashMap<String,Fraction> map = new HashMap<>();

   @Override public Fraction visitAssignment(CalcFracParser.AssignmentContext ctx) {
      Fraction fraq = visit(ctx.expr());
      String id = ctx.ID().getText();
      map.put(id, fraq);
      return null;
   }

   @Override public Fraction visitPrint(CalcFracParser.PrintContext ctx) {
      Fraction res = visit(ctx.expr());
      System.out.println(res.toString());
      return null;
      //return res;
   }

   @Override public Fraction visitExprAddSub(CalcFracParser.ExprAddSubContext ctx) {
      String chars = ctx.op.getText();
      Fraction n1 = visit(ctx.expr(0));
      Fraction n2 = visit(ctx.expr(1));
      switch (chars) {
         case "+":
            return n1.add(n2);
         case "-":
            return n1.subtract(n2);
         default:
            return null;
      }
      //return res;
   }

   @Override public Fraction visitExprRead(CalcFracParser.ExprReadContext ctx) {
      String res = ctx.String().getText();
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();
      Fraction f = new Fraction(x, 1);
      return f;
      //return res;
   }

   @Override public Fraction visitExprPoten(CalcFracParser.ExprPotenContext ctx) {
      Fraction n1 = visit(ctx.expr(0));
      Fraction n2 = visit(ctx.expr(1));
      Fraction res = n1.powtencia(n2);
      return res;
   }

   @Override public Fraction visitExprParent(CalcFracParser.ExprParentContext ctx) {
      Fraction res = visit(ctx.expr());
      return res;
      //return res;
   }

   @Override public Fraction visitExprNeg(CalcFracParser.ExprNegContext ctx) {
      Fraction res = visit(ctx.expr());
      Fraction neg = new Fraction(-1, 1);
      res = res.multiply(neg);
      return res;
      //return res;
   }

   @Override public Fraction visitExprIntegerRat(CalcFracParser.ExprIntegerRatContext ctx) {
      int x = Integer.parseInt(ctx.Integer(0).getText());
      int y = Integer.parseInt(ctx.Integer(1).getText());
      Fraction f = new Fraction(x, y);
      return f;
      //return res;
   }

   @Override public Fraction visitExprInteger(CalcFracParser.ExprIntegerContext ctx) {
      Integer res = Integer.parseInt(ctx.Integer().getText());
      Fraction f = new Fraction(res, 1);
      return f;
   }

   @Override public Fraction visitExprReduce(CalcFracParser.ExprReduceContext ctx) {
      Fraction res = visit(ctx.expr());
      res.reduce();
      return res;
      //return res;
   }

   @Override public Fraction visitExprID(CalcFracParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      if(map.containsKey(id)){
         return map.get(id);
      }
      return null;
      //return res;
   }

   @Override public Fraction visitExprMultDivMod(CalcFracParser.ExprMultDivModContext ctx) {
      String chars = ctx.op.getText();
      Fraction n1 = visit(ctx.expr(0));
      Fraction n2 = visit(ctx.expr(1));
      switch (chars) {
         case "*":
            return n1.multiply(n2);
         case ":":
            return n1.divide(n2);
         default:
            return null;
      }
      //return res;
   }
}
