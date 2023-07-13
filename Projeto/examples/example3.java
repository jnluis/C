import java.util.*;

public class example3 {

   // create a new class that extends table
   // and has 3 columns: n1, n2 and average
   // average is calculated using the 2 other columns
   public class Table extends AbstractTable {
      List<Double> n1 = new ArrayList<>();
      List<Double> n2 = new ArrayList<>();

      // map used to get the index of a column
      int columnID = 0;
      Map<String, Integer> translatorMap = Map.of(
         "n1", columnID++,
         "n2", columnID++,
         "average", columnID++
      );

      // set the headers for each column
      Table(){
         headersMap.put("n1","n1");
         headersMap.put("n2","n2");
         headersMap.put("average","average");
      }

      List<Double> average = new ArrayList<>();

      // function used to calculate values of column "average"
      private double average(double n1 , double n2){
         double v3 = n1;
         double v4 = n2;
         double v2 = v3 + v4;
         int v5 = 2;
         double v1 = v2 / v5;
         return v1;
         }

      // add nulls to columns that are not
      // the same length
      public void checkSizes(){
            List<Integer> t = Arrays.asList(n1.size(),n2.size(),average.size());
            int tableSize = Collections.max(t);
            while(n1.size() < tableSize){
               n1.add(null);
            }
            while(n2.size() < tableSize){
               n2.add(null);
            }
            while(average.size() < tableSize){
               average.add(null);
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
            if(idx + 1 < n1.size()){
               return true;
            }
            return false;
         }
         public List<Object> next(){
            if(hasNext()){
               idx++;
               return new ArrayList<Object>(Arrays.asList(n1.get(idx), n2.get(idx),average.get(idx)));
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
         int n1MaxSize = columnSize(headersMap.get("n1"),new ArrayList<Object>(n1));
         format.add("| %"+n1MaxSize+"s ");
         int n2MaxSize = columnSize(headersMap.get("n2"),new ArrayList<Object>(n2));
         format.add("| %"+n2MaxSize+"s ");
         int averageMaxSize = columnSize(headersMap.get("average"),new ArrayList<Object>(average));
         format.add("| %"+averageMaxSize+"s ");
         String s = "";
         for (String string : format) {
            s += string;
         }
         s+= "|%n";
         System.out.printf(s, headersMap.get("n1"),headersMap.get("n2"),headersMap.get("average"));
         for (int i = 0; i < n1.size(); i++) {
            System.out.printf(s, n1.get(i),n2.get(i),average.get(i));
         }
         return "\n";
      }
   }
   public static void main(String[] args) {
      example3 o = new example3();
      Scanner scan = new Scanner(System.in);

      // read from stdin and set
      // the column value
      Table t;
      t = o.new Table(); 
      System.out.println("n1:");
      String v7 = scan.nextLine();
      double v6 = Double.valueOf(v7);
      t.n1.add(v6);

      // read from stdin and set
      // the column value
      System.out.println("n2:");
      String v9 = scan.nextLine();
      double v8 = Double.valueOf(v9);
      t.n2.add(v8);
      // the average function is used to set the value
      // of the "average" column
      t.average.add(t.average(v6,v8));

      // read from stdin and set
      // the column value
      System.out.println("n1:");
      String v11 = scan.nextLine();
      double v10 = Double.valueOf(v11);
      t.n1.add(v10);

      // read from stdin and set
      // the column value
      System.out.println("n2:");
      String v13 = scan.nextLine();
      double v12 = Double.valueOf(v13);
      t.n2.add(v12);
      t.average.add(t.average(v10,v12));

      // read from stdin and set
      // the column value
      String v14 = "n1 and ";
      System.out.print(v14);
      String v15 = " n2: ";
      System.out.println(v15);

      // read from stdin and set
      // the column value
      String v17 = scan.nextLine();
      double v16 = Double.valueOf(v17);
      t.n1.add(v16);

      // read from stdin and set
      // the column value
      String v19 = scan.nextLine();
      double v18 = Double.valueOf(v19);
      t.n2.add(v18);
      t.average.add(t.average(v16,v18));

      // print the table
      Table v20 = t;
      System.out.println(v20);
      scan.close();
   }
   public static String centerString (int width, String s){
      return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
   }
}
