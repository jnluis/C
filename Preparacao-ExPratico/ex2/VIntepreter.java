import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class VIntepreter extends FracLangBaseVisitor<Fraction> {
   private Map<String, Fraction> symbolTable = new HashMap<>();
   private static Scanner in = new Scanner(System.in);

   @Override
   public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null) {
         System.out.println(res.toString());
      }
      return res;
   }

   @Override
   public Fraction visitAssignment(FracLangParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      String id = ctx.ID().getText();

      if (res != null) {
         symbolTable.put(id, res);
      }
      return res;
   }

   @Override
   public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {

      String[] fraction = ctx.getText().split("/");
      if (fraction.length == 2) {
         return new Fraction(Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1]));

      } else {
         return new Fraction(Integer.parseInt(fraction[0]));
      }
   }

   @Override
   public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      Fraction res = visit(ctx.expr());
      if(res != null){
         if("-".equals(ctx.op.getText())){
            res = new Fraction(-res.num(), res.den());
         }
      }
      return res;
   }

   @Override
   public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {

      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));

      if (e1 != null && e2 != null) {
         switch (ctx.op.getText()) {
            case "*":
               res = new Fraction(e1.num() * e2.num(), e1.den() * e2.den());
               break;
            case ":":
               res = new Fraction(e1.num() * e2.den(), e1.den() * e2.num());
               break;
         }

      }
      return res;
   }

   @Override
   public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {

      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));

      if (e1 != null && e2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               res = new Fraction((e1.num() * e2.den()) + (e2.num() * e1.den()), e1.den() * e2.den()); // conta que tá
                                                                                                       // no enunciado
               break;
            case "-":
               res = new Fraction((e1.num() * e2.den()) - (e2.num() * e1.den()), e1.den() * e2.den()); // conta que tá
                                                                                                       // no enunciado
               break;
         }

      }
      return res;
   }

   @Override
   public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
      return visit(ctx.expr()).reduce();
   }

   @Override
   public Fraction visitExprParent(FracLangParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprRead(FracLangParser.ExprReadContext ctx) {
   String prompt = ctx.String().getText();
   prompt = prompt.substring(1, prompt.length()-1);
   System.out.println(prompt+ ": ");
   Integer frac = Integer.parseInt(in.nextLine());
   Fraction res = new Fraction(frac);
   if(res.error()){
   System.err.println("ERROR: invalid literal fraction \"" + frac + "\"!");
   res= null;
   }
   return res;
   }

   @Override
   public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      Fraction res = null;
      String id = ctx.ID().getText();

      if (!symbolTable.containsKey(id)) {
         System.err.println("ERROR: variable \"" + id + "\"not found!");
      } else {
         res = symbolTable.get(id);
      }
      return res;
   }
}
