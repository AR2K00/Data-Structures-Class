import java.util.Random;

// DoublingTest class provides a client for measuring
// the running time of a method using a doubling test.
public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private DoublingTest() { }

    // Returns the amount of time (in seconds) to call
    // ThreeSum.count() with n random 6-digit integers.
    public static double timeTrial(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = -MAXIMUM_INTEGER + 1 + new Random().nextInt(2* MAXIMUM_INTEGER - 1) ;
        }
        long startTime = System.currentTimeMillis();
        ThreeSum.count(a);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime)/1000;
    }

    // Prints table of running times to call ThreeSum.count()
    // for arrays of size 250, 500, 1000, 2000, and so forth.
    public static void main(String[] args) {
        for (int n = 250; n <= 64*250; n += n) {
            double time = timeTrial(n);
            System.out.printf("%7d %7.2f\n", n, time);
        }
    }
}