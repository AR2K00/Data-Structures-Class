import java.util.Arrays;

public class TwoSumFast {
public static int count(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            if (BinarySearch.indexOf(a, -a[i]) > i)
            count ++;
        return count;
        }

        public static void main(String[] args) {
        In in = new In("https://gist.githubusercontent.com/david-dobor/b8548ad959c016b621c1790830de534b/raw/df5ff220f74dad6e803055207121eecc8c01d418/1Mints.txt");
        int[] a = in.readAllInts();
        System.out.println("Count is: " + count(a));
        }
}