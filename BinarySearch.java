public class BinarySearch {
    public static int indexOf(int[] a, int key) {
        // array must be sorted
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // key is within a[lo...hi] or not present
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }

    // test client
    public static void main(String[] args) {
        int[] a = {11, 13, 17, 19, 21, 23, 29, 37, 43, 51, 57, 68, 73, 89, 91};
        int x = 23;
        System.out.println(indexOf(a, x)); // prints 5

        x = 50;
        System.out.println(indexOf(a, x)); // prints -1
    }
}