import java.util.*;

public class example1 {

   // create a new class that extends table
   // and has 2 columns: name, and number   
   public class ATable extends AbstractTable {
      List<String> name = new ArrayList<>();
      List<Integer> number = new ArrayList<>();

      // map used to get the index of a column
      int columnID = 0;
      Map<String, Integer> translatorMap = Map.of(
         "name", columnID++,
         "number", columnID++
      );

      // set the headers for each column
      ATable(){
         headersMap.put("name","Name:");
         headersMap.put("number","number");
      }

      // add nulls to columns that are not
      // the same length
      public void checkSizes(){
            List<Integer> t = Arrays.asList(name.size(),number.size());
            int tableSize = Collections.max(t);
            while(name.size() < tableSize){
               name.add(null);
            }
            while(number.size() < tableSize){
               number.add(null);
            }
      }

      // iterator implementation for the for loop
      public Iterator<List<Object>> getIterator(){
         return (this).new tableIterator();
      }

      private class tableIterator implements Iterator<List<Object>>{
         private int idx;
         tableIterator(){
            checkSizes();
            idx = -1;
         }
         public boolean hasNext(){
            if(idx + 1 < name.size()){
               return true;
            }
            return false;
         }
         public List<Object> next(){
            if(hasNext()){
               idx++;
               return new ArrayList<Object>(Arrays.asList(name.get(idx), number.get(idx)));
            }
            throw new NoSuchElementException("Out of Bounds");
         }
      }

      // toString method that makes a pretty
      // print of the table
      @Override
      public String toString() {
         checkSizes();
         List<String> format = new ArrayList<>();
         System.out.println(headerTable);
         int nameMaxSize = columnSize(headersMap.get("name"),new ArrayList<Object>(name));
         format.add("| %"+nameMaxSize+"s ");
         int numberMaxSize = columnSize(headersMap.get("number"),new ArrayList<Object>(number));
         format.add("| %"+numberMaxSize+"s ");
         String s = "";
         for (String string : format) {
            s += string;
         }
         s+= "|%n";
         System.out.printf(s, headersMap.get("name"),headersMap.get("number"));
         for (int i = 0; i < name.size(); i++) {
            System.out.printf(s, name.get(i),number.get(i));
         }
         return "\n";
      }
   }
   public static void main(String[] args) {
      example1 o = new example1();
      Scanner scan = new Scanner(System.in);
      // declare t as ATable
      ATable t;
      // initialize t
      t = o.new ATable(); 
      // set header of table and columns
      t.setHeaderTable("Table:");
      t.setHeaderColum("number","Number:");

      // create variable c and add 
      // line with its value
      int c;
      int v1 = 1;
      c = v1;
      String v2 = "One";
      t.name.add(v2);
      int v3 = c;
      t.number.add(v3);

      int v5 = c;
      int v6 = 1;
      int v4 = v5 + v6;
      c = v4;
      String v7 = "Two";
      t.name.add(v7);
      int v8 = c;
      t.number.add(v8);

      int v10 = c;
      int v11 = 1;
      int v9 = v10 + v11;
      c = v9;
      String v12 = "Three";
      t.name.add(v12);
      int v13 = c;
      t.number.add(v13);

      // print the table
      ATable v14 = t;
      System.out.println(v14);
      scan.close();
   }

   // function used to center strings
   public static String centerString (int width, String s){
      return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
   }
}
