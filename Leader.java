//Lab5
import java.util.LinkedList;
import java.util.Queue;

public class Leader {
    public static void main(String[] args) {
        int n = 7; // n: total number of people
        int m = 3; // m-th person is eliminated at each round
        Queue<Integer> lead = new LinkedList<Integer>();
        int i;
        for(i = 1; i<=n;i++){
            lead.add(i);
            ;
        }
        int j;
        while (lead.size() != 1) {
            for (j = 1; j < m; j++){
                lead.add(lead.remove());}
            System.out.println(lead.remove() + " ");
        }
        System.out.println("Leader is: " + lead.remove());
    }
}
// you can write a solution in under 10 lines of code.)

