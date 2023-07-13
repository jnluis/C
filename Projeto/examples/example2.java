import java.util.*;

public class example2 {

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
      example2 o = new example2();
      Scanner scan = new Scanner(System.in);

      // create table
      ATable t;
      t = o.new ATable(); 

      // add line
      int c;
      int v1 = 1;
      c = v1;
      String v2 = "One";
      t.name.add(v2);

      // add line
      int v3 = c;
      t.number.add(v3);
      t.name.add(null);
      t.number.add(null);

      // add line
      int v5 = c;
      int v6 = 1;
      int v4 = v5 + v6;
      c = v4;
      String v7 = "Two";
      t.name.add(v7);

      // add line
      int v8 = c;
      t.number.add(v8);
      t.name.add(null);
      t.number.add(null);

      // add line
      int v10 = c;
      int v11 = 1;
      int v9 = v10 + v11;
      c = v9;
      String v12 = "Three";
      t.name.add(v12);

      // add line
      int v13 = c;
      t.number.add(v13);
      t.name.add(null);
      t.number.add(null);

      // print table
      ATable v14 = t;
      System.out.println(v14);

      // create tt and make it only reference
      // the column name of the table t
      ATable tt;
      tt = o.new ATable(); 
      tt.name = t.name;
      for (int index = 0; index < tt.name.size(); index++) {
          tt.number.add(null);
      }
      tt.setHeaderTable("Table of names (view)");

      // create ttt and copy values of
      // the column name of the table t
      ATable ttt;
      ttt = o.new ATable(); 
      ttt.name = new ArrayList<>(t.name);
      ttt.setHeaderTable("Table of names (copy)");

      // add line with 'four'
      // should be present in tt
      // but not in ttt
      String v15 = "Four";
      t.name.add(v15);
      int v17 = c;
      int v18 = 1;
      int v16 = v17 + v18;
      t.number.add(v16);

      ATable v19 = tt;
      System.out.println(v19);

      ATable v20 = ttt;
      System.out.println(v20);

      // calculate the value for center
      // and print the string centered in the table
      String v21 = "Yet another print of a table";
      int v25 = AbstractTable.columnSize(t.headersMap.get("name"),new ArrayList<Object>(t.name));
      int v26 = 1;
      double v24 = v25 + v26;
      int v27 = AbstractTable.columnSize(t.headersMap.get("number"),new ArrayList<Object>(t.number));
      double v23 = v24 + v27;
      int v28 = 3;
      double v22 = v23 + v28;
      System.out.println(centerString((int)v22,v21));

      // forLoop
      Iterator<List<Object>> titerator = t.getIterator();
      while (titerator.hasNext()){
         List<Object> elem = titerator.next();
         Object v30 = elem.get(t.translatorMap.get("name")) + ":";
         elem.set(t.translatorMap.get("name"), v30);
         String v31 = "|";
         Object v32 = (Object)elem.get(t.translatorMap.get("name"));
         String v33 = "|";
         Object v34 = (Object)elem.get(t.translatorMap.get("number"));
         String v35 = "|";
         System.out.println(v31+v32+v33+v34+v35);
      }

      // create table t2 from the values in list1.csv
      ATable t2;
      Map<String,List<String>> f1 = ReadCsvFileMain.read("list1.csv");
      t2 = o.new ATable(); 
      t2.name = f1.get("name");
      List<Integer> v36 = new ArrayList<>();
      // convert from string to int
      for(String a : f1.get("number")) v36.add(Integer.valueOf(a));
      t2.number = v36;
      // print table
      ATable v37 = t2;
      System.out.println(v37);

      // set columns of table t2 from the values in list2.csv
      Map<String,List<String>> f2 = ReadCsvFileMain.read("list2.csv");
      // convert the header names that come as 'placeholder' by default
      f2.put("name", f2.remove("placeholder2"));
      f2.put("number", f2.remove("placeholder1"));
      t2 = o.new ATable(); 
      t2.name = f2.get("name");
      List<Integer> v38 = new ArrayList<>();
      for(String a : f2.get("number")) v38.add(Integer.valueOf(a));
      t2.number = v38;
      // print table
      ATable v39 = t2;
      System.out.println(v39);

      // same as before
      Map<String,List<String>> f3 = ReadCsvFileMain.read("list1.csv");
      f3.put("name", f3.remove("name"));
      f3.put("number", f3.remove("number"));
      t2 = o.new ATable(); 
      t2.name = f3.get("name");
      List<Integer> v40 = new ArrayList<>();
      for(String a : f3.get("number")) v40.add(Integer.valueOf(a));
      t2.number = v40;
      ATable v41 = t2;
      System.out.println(v41);
      scan.close();
   }
   public static String centerString (int width, String s){
      return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
   }
}
