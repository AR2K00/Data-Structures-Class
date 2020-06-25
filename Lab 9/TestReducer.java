import java.util.HashMap;

public class TestReducer {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("foo", 2); map1.put("hello", 5); map1.put("world", 10);
        System.out.println(map1);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("hello", 1); map2.put("foo", 5); map2.put("bar", 99);
        System.out.println(map2);

        System.out.print("\n\"Reducing\" the two maps:");
        System.out.println("\n... reducer not yet implemented ...");

        // After you've implemented the reducer in Reducer.java, uncomment
        // the following line which should print {bar=99, world=10, foo=7, hello=6}
        System.out.println(new Reducer().reduce(map1, map2));
    }
}