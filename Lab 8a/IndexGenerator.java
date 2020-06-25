import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IndexGenerator {

    // Tree that stores the index
    private final TreeSet<String> index;

    // Constructor
    public IndexGenerator() { index = new TreeSet<>(); }

    // Reads each word in the input file and store it
    // in an index along with its line number.
    public void buildTree(Scanner scanner) {
        int lineNum = 0;  // line number
        StringTokenizer st;
        String token;

        while(scanner.hasNextLine()){
            lineNum++;
            st = new StringTokenizer(scanner.nextLine());
            while(st.hasMoreTokens()){
                token = st.nextToken();
                index.add( token.concat(String.format("%-17s %s",token, lineNum)));
            }

        }

        // Here is what this method should do:
        // Keep reading the lines of the input file util the end of the file.
        // For each line of the input text, insert each word
        // of that line into the binary search tree.
        // index refers to a TreeSet from Java's API. A TreeSet
        // is backed by a binary search tree. The documentation
        // says that you insert a node into this tree by calling
        // index.add("some string you want to insert into the tree")

        // Here is how this method can do this:
        // while scanner still has another line to read,
        //   increment the line number;
        //   create a StringTokenizer object with the current line as input
        //   while the StringTokenizer still has more tokens to process,
        //      get that token
        //      add that token concatenated with the current line number to index
    }

    // Perform an inorder traversal of the tree
    // and display its nodes to the standard output
    public void showIndex() {
        // by default a TreeSet will be inorder traversed,
        // so simply use the enhanced for loop here to
        // loop through the index tree and print each element.
        Iterator iterator = index.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    public static void main(String[] args) throws FileNotFoundException {

        //Scanner scanner = new Scanner(new FileInputStream("tinyTale.txt"));
        // uncomment the following line when you are ready to read the larger file
         Scanner scanner = new Scanner(new FileInputStream("tale.txt"));

        // The following while loop simply reads the input file and
        // displays each line of the file on your screen. Once you've
        // ensured that this program can read the input correctly, you
        // can DELETE OR COMMENT OUT the while loop on the next line.
        while (scanner.hasNextLine()) System.out.println(scanner.nextLine());


        // Once you've implemented and tested the methods in IndexGenerator,
        // the following lines will produce output (initially they don't do anything).
        Scanner scan = new Scanner(new FileInputStream("tale.txt"));
        IndexGenerator index = new IndexGenerator(); // a new IndexGenerator instance
        index.buildTree(scan);                       // build a binary search tree
        index.showIndex();                           // display the tree nodes
    }
}