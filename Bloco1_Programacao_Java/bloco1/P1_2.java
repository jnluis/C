package bloco1;
import java.util.*;

// ex 2
// echo "2 * 3" | java -ea -jar b1_1.jar


public class P1_2{
    public static void main(String[] args) {
        float x, y, result;
        String operator, input;
        String[] splitInput;
        HashMap<String, Float> variaveis = new HashMap<>();
        Scanner userInput = new Scanner(System.in);

        while (true){
            input = userInput.nextLine();

            if (input.contains("exit") || input.contains("quit")){
                userInput.close();
                System.exit(0);
            }

            splitInput = input.split(" ");

            if (input.contains("=")){
                // if assigning without calculation :
                // ex: n = 1
                if (splitInput.length <= 3)
                    variaveis.put(splitInput[0], Float.parseFloat(splitInput[2]));
                else{
                    // calculate right hand side (up to 1 calculation) and then store it
                    // ex: n = n + 1

                    x = numericValue(splitInput[2], variaveis);
                    y = numericValue(splitInput[4], variaveis);
                    
                    operator = splitInput[3];

                    result = calculator(x, y, operator);
                    variaveis.put(splitInput[0], result);
                }
            }
            else{
                // get operator and execute
                // ex: n + 1

                x = numericValue(splitInput[0], variaveis);
                y = numericValue(splitInput[2], variaveis);

                operator = splitInput[1];

                result = calculator(x, y, operator);
                
                System.out.println("Result: " + result);     
            }
        }
    }

    private static float numericValue(String input, HashMap<String, Float> variaveis){
        try {
            return Float.parseFloat(input);
        } catch (Exception e) {
            return variaveis.get(input);
        }
    }

    private static float calculator(float x, float y, String operator){
        float result = 0;

        switch (operator) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "/":
                result = x / y;
                break;
            case "*":
                result = x * y;
                break;
            default:
                System.err.println("Given operator is invalid");
                break;
        }

        return result;
    }
}
