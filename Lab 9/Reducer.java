import java.util.HashMap;
import java.util.Map;

public class Reducer {

    public HashMap<String, Integer> reduce(HashMap<String, Integer> A, HashMap<String, Integer> B) {
        HashMap<String, Integer> both =  new HashMap<String, Integer>();
        for(Map.Entry<String, Integer> key : A.entrySet()){
            if(B.containsKey(key.getKey())==true){
                Integer total = key.getValue() + B.get(key.getKey());
                both.put(key.getKey(), total);
            }else{
                both.put(key.getKey(), key.getValue());
            }}
        for(Map.Entry<String,Integer> key: B.entrySet()){
            if(A.containsKey(key.getKey())==false){
                both.put(key.getKey(),key.getValue());
            }}

        return both;
    }

    public static void main(String[] args) {

        Mapper mapper1 = new Mapper("tiny1.txt");
        HashMap<String, Integer> map1 = mapper1.getWordcount();
        System.out.println(map1);

        Mapper mapper2 = new Mapper("tiny2.txt");
        HashMap<String, Integer> map2 = mapper2.getWordcount();
        System.out.println(map2);

        HashMap<String, Integer> map = new Reducer().reduce(map1, map2);
        System.out.println(map);
        System.out.println(new Mapper("tinyTale.txt").getWordcount());
    }
}