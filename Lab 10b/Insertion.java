/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Dependencies: In.java
 *  Data files:   10ints.txt
 *
 *  Sorts a sequence of integers from an input file using mergesort.
 *
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 ******************************************************************************/

// Insertion class provides static methods for sorting an
// array of integers using insertion sort.
public class Insertion {

    // This class should not be instantiated.
    private Insertion() {
    }

    // Rearranges the array in ascending order.
    public static void sort(int[] a) {
        // YOUR CODE HERE
    }


    // exchange a[i] and a[j] -- a helper method
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // Reads in a sequence of integers from a file; insertion sorts them;
    // and prints them to standard output in ascending order.
    public static void main(String[] args) {
        In in = new In("10ints.txt");
        int n = in.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt();
        }
        Insertion.sort(a);
        show(a);
    }
}