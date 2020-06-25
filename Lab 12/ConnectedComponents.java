import java.util.ArrayList;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {

        // YOUR CODE HERE
        boolean [] marked = new boolean[adj.length];
        int count =0;
        for (int x = 0; x<adj.length; x++){
            if(!marked[x]){
                DFS(x, marked, adj);
                count++;
            }
        }
        return count; // <- change this line to return the correct result
    }

    // feel free to add a helper method to make your code cleaner & modular.
    private static void DFS(int x, boolean[] marked, ArrayList<Integer>[] adj){
        marked[x] = true;
        for (int y : adj[x]){
            if(!marked[y]){
                DFS(y,marked, adj);
            }
        }
    }

    public static void main(String[] args) {
        In in = new In("mediumG.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}
