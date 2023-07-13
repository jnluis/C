package bloco1;
import java.util.Scanner;


public class P1_1 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Double n1 = sc.nextDouble();
            String op = sc.next();
            Double n2 = sc.nextDouble();

            switch (op) {
                case "+":
                    System.out.println(n1 + n2);
                    break;
                case "-":
                    System.out.println(n1 - n2);
                    break;
                case "*":
                    System.out.println(n1 * n2);
                    break;
                case "/":
                if (n2 == 0) {
                    System.err.println("Divisão por zero!");
                    System.exit(1);
                    }
                    System.out.println(n1 / n2);
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
            sc.close();
        }   
}   