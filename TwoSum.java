import java.util.Arrays;

public class TwoSum {
public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0)
                    count++;
                }
            }
        return count;
        }
        public static void main(String[] args) {
        In in = new In("16Kints.txt");
        int[] a = in.readAllInts();

        System.out.println("The original array of ints: " + Arrays.toString(a));
        System.out.println("Count is: " + TwoSum.count(a));
        }
}
