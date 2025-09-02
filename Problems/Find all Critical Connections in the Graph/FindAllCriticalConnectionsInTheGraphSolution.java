import java.util.*;

public class FindAllCriticalConnectionsInTheGraphSolution {
    public static int count = 0;

    public static void dfs(int v, int[] disc, int[] min, int[] parent,
            ArrayList<ArrayList<Integer>> ans, ArrayList<ArrayList<Integer>> adj) {
        disc[v] = min[v] = count++;

        for (int neighbour : adj.get(v)) {
            if (disc[neighbour] == -1) {
                parent[neighbour] = v;
                dfs(neighbour, disc, min, parent, ans, adj);
                min[v] = Math.min(min[v], min[neighbour]);

                if (disc[v] < min[neighbour]) {
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(Math.min(v, neighbour));
                    bridge.add(Math.max(v, neighbour));
                    ans.add(bridge);
                }
            } else if (neighbour != parent[v]) {
                min[v] = Math.min(min[v], disc[neighbour]);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int[] disc = new int[v];
        int[] min = new int[v];
        int[] parent = new int[v];

        Arrays.fill(disc, -1);
        Arrays.fill(min, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < v; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, min, parent, ans, adj);
            }
        }

        ans.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0)))
                return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        return ans;
    }

}