import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class PhoneBookBetter {
    private FastScanner in = new FastScanner();
    Map<Integer, String> contacts = new HashMap<>();

    public static void main(String[] args) {
        // start timer
        final long startTime = System.currentTimeMillis();
      //  System.out.println(startTime);
        // process the queries
        new PhoneBookBetter().processQueries();

        // end the timer and print the result
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime)/1000F + "seconds.");
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    private void processQuery(Query query){
        if (query.type.equals("add")){
           String old = contacts.get(query.number);
            if(old != null){
                contacts.replace(query.number,old,query.name);
            }else{
                contacts.put(query.number, query.name);
            }
        }else if (query.type.equals("del")){
            contacts.remove(query.number);
        }else{
            String response = contacts.get(query.number);
            if (response == null){
                response = "not found";
            }
            writeResponse(response);
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number){
            this.type = type;
            this.number = number;
        }
    }

    private void writeResponse(String response) {
        System.out.println(response);
    }

    public void processQueries(){
        int queryCount = in.nextInt();
        for (int i = 0; i< queryCount; ++i){
             //   System.out.println(i);
                processQuery(readQuery()); }
    }


    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
}
