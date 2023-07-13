package bloco1;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Scanner;

// echo "A list of numbers: eight million two hundred thousand five hundred twenty-four" | java -ea b1_3

public class P1_4 {
    public static void main(String[] args) {
        Path path = Paths.get("numbers.txt"); // é sempre o mesmo ficheiro, por isso pode ser assim
        String linha;
        HashMap<String, String> map;
        map = new HashMap<>();

        try{
            BufferedReader reader = Files.newBufferedReader(path);
            
            while((linha = reader.readLine()) != null) {
                String[] split = linha.split(" ");
                map.put(split[2], split[0]); // key = word, value = number
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] splitInput = input.split(" ");
        String output = "";
        for (String word : splitInput){
            output = output + map.get(word) + " ";
        }
        System.out.println(output);

        sc.close();
    }
}
