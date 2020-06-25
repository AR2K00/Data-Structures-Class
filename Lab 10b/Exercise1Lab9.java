// Exercise 1: You are given two sorted arrays, a and b. In general, when you concatenate two sorted arrays, the
// resulting array is not sorted. For example a = [1, 3] and b = [2, 4] are both sorted, but ab = [1, 3, 2, 4] is not.
// Your job in this exercise is to count the number of inversions in the concatenated array.
// In this example, the number of inversions is 1 (3 comes before 2 in ab, but 3 > 2).
// Modify the merge() method below so that it counts and returns the number of inversions in the concatenated array.
// Print the number of inversions for the example shown in main().

import java.util.Arrays;

public class Exercise1Lab9 {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};                   // sorted array a
        int[] b = {2, 4, 6, 8, 9, 10, 11};        // sorted array b
        int[] ab = new int[a.length + b.length];  // allocate space for a new array whose length = a.length + b.length
        concatenate(a, b, ab);                    // fill ab. ab's elements are elements of a followed by elements of b

        System.out.println("Array a  (sorted):                   " + Arrays.toString(a));
        System.out.println("Array b  (sorted):                   " + Arrays.toString(b));
        System.out.println("Array ab (a followed b, not sorted): " + Arrays.toString(ab));

        // Because a and b are sorted, "merging" a and b will result in a sorted array.
        // The merge() method (see below) receives as an argument an array ab (a followed by b),
        // where a and b are sorted arrays. merge() then rearranges ab into a sorted order.

        int[] aux = new int[ab.length];   // allocate space for an auxiliary (helper) array
        int lo  = 0;             // start  index of array ab (sub-array a starts at lo)
        int mid = a.length - 1;  // middle index of array ab (sub-array a ends at mid; sub-array b starts at mid+1)
        int hi  = ab.length - 1; // end    index of array ab (sub-array b ends at hi)

        merge(ab, aux, lo, mid, hi);

        System.out.print("Sorted array ab (merged a and b):    " + Arrays.toString(ab));
        // YOUR CODE HERE
        // System.out.println("The number of inversions in the concatenated array is ...");
    }

    //////////// Understand how merge() works and modify it as required ///////////
    // Method merge() merges two sorted sub-arrays of array a[].
    // The first  sub-array starts at index lo    and ends at index mid of a[];
    // The second sub-array starts at index mid+1 and ends at index hi  of a[].
    // The method rearranges the elements of a[], using an auxiliary array aux[].
    // The rearranged array a[] (the merged array) is going to be sorted.
    // Example: Suppose a[] = [1, 3, 5, 2, 4], and lo = 0, mid = 2, hi = 4.
    //          Then the two sorted sub-arrays are [1, 3, 5] and [2, 4].
    //          The merged array (rearranged a[]) is then = [1, 2, 3, 4, 5].
    ///////////////////////////////////////////////////////////////////////////////
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int count = 0;
        // copy a[] to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid) {             a[k] = aux[j++];}
            else if (j > hi){               a[k] = aux[i++];}
            else if (aux[j] < aux[i]){
                count= count +(mid-i)+1;
                  a[k] = aux[j++];
                   }
            else                           a[k] = aux[i++];
        }
        System.out.println("The number of inversions is: "+ count);
    }

    ///////////// No need to modify the following concatenate() method ////////////
    // Concatenates arrays a and b. Puts all elements into array ab.
    // example: a = [1, 5], b = [2, 3, 8, 9] -> ab = [1, 5, 2, 3, 8, 9]
    ///////////////////////////////////////////////////////////////////////////////
    public static void concatenate(int[] a, int[] b, int[] ab) {
        assert ab.length == a.length + b.length;
        for (int i = 0; i < ab.length; i++) {
            if (i < a.length) ab[i] = a[i];
            else              ab[i] = b[i - a.length];
        }
    }
}