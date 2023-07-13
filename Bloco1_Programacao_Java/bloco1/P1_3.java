package bloco1;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class P1_3 {
    public static void main(String[] args) {
        Stack<Float> numberStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        sc.close();
        for (String string : str) {
            try {
                float n = Float.parseFloat(string);
                numberStack.push(n);
            } catch (Exception e) {
                float y = numberStack.pop();
                float x = numberStack.pop();
                char op = string.charAt(0);
                x = calc(op, x, y);
                numberStack.push(x);
            }
            String out = "Stack:";
            for (Float n : Collections.list(numberStack.elements())) {
                out = out + n;
            }
            System.out.println(out);
        }
    }

    public static float calc(char op, float x, float y) {
        switch (op) {
            case '+':
                x = x + y;
                break;
            case '-':
                x = x - y;
                break;
            case '/':
                x = x / y;
                break;
            case '%':
                x = x % y;
                break;
            case '*':
                x = x * y;
                break;
            default:
                System.out.println("operaÃ§ao invalida");
        }
        return x;
    }
}

