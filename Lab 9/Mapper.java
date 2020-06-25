import java.util.HashMap;

/* Class Mapper builds a <String, Integer> map from an input text file.
   The String corresponds to a word in the input file, and the Integer
   corresponds to the number of times the word occurred in the file.
   For example,
         an entry {  ..., Snollygoster=7, ...  } in the map means that
         the word" Snollygoster" showed up 7 times in the input file.
*/

public class Mapper {

    private HashMap<String, Integer> wordcount; // the map to build

    // Constructor. Reads text stored in a file and builds a hashmap from the
    // words in the file. The hashmap associates each word with the number of
    // times the word occurs in the file.
    public Mapper(String filename) {
        wordcount = new HashMap<>();
        In in = new In(filename);
        while (!in.isEmpty()) {
            String key = in.readString();
            if (wordcount.containsKey(key)) {
                wordcount.put(key, wordcount.get(key) + 1);
            }
            else {
                wordcount.put(key, 1);
            }
        }
    }


    // returns the hashmap of words and their frequencies
    public HashMap<String, Integer> getWordcount() {
        return wordcount;
    }

    // unit tests the mapper class
    public static void main(String[] args) {
        Mapper mapper = new Mapper("tiny1.txt");
        System.out.println(mapper.getWordcount());
    }
}