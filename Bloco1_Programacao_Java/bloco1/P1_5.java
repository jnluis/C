package bloco1;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

//$ echo "two thousand and thirty three" | java -ea b1_4

public class P1_5 {
    public static void main(String[] args) {
        Path path = Paths.get("numbers.txt"); // é sempre o mesmo ficheiro, por isso pode ser assim
        String linha;
        HashMap<String, String> map;
        map = new HashMap<>();
        ArrayList<Integer> PartesNumero = new ArrayList<>();

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
            output = output + map.get(word);
            PartesNumero.add(Integer.parseInt(output));
        }

        //Percorrer a lista e somar os valores
        int resultado = 0;
        int temp = 0;
        for (int i = 0; i < PartesNumero.size(); i++){
            temp= PartesNumero.get(i);
            resultado += temp; // Não funciona bem
        }
        System.out.println(resultado);

        sc.close();
    }
    
}
