import java.util.*;

public class Dijkstra {

    private static final int inf = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node> {
        int index;
        long distance;

        public Node(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance > o.distance) return 1;
            else if (this.distance < o.distance) return -1;
            else return 0;
        }
    }

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        //write your code here
        int[] dist = new int[adj.length];
        for (int i = 0;i < dist.length;i++) {
            dist[i] = inf;
        }
        dist[s] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(s, dist[s]));
        while(!queue.isEmpty()){
            Node u = queue.remove();
            int u_index = u.index;
            for (int v : adj[u_index]) {
                int v_index = adj[u_index].indexOf(v);
                if (dist[v] > dist[u_index] + cost[u_index].get(v_index)) {
                    dist[v] = dist[u_index] + cost[u_index].get(v_index);
                    queue.add(new Node(v, dist[v]));
                }
            }
        }
        if(dist[t] == inf)
            return -1;
        return dist[t];
    }
    public static void main(String[] args) {
        In in = new In("G4-1.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}