import java.util.*;

public class Solution {

    static int time = 0;

    public static void dfs(int u, int parent, int[] disc, int[] low, boolean[] visited,
            List<List<Integer>> adj, boolean[] isAP) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent)
                continue;

            if (!visited[v]) {
                children++;
                dfs(v, u, disc, low, visited, adj, isAP);

                // After visiting v
                low[u] = Math.min(low[u], low[v]);

                // Articulation point check
                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // Root node special case
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }

    public static List<Integer> articulationPoints(int V, List<List<Integer>> adj) {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, disc, low, visited, adj, isAP);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i])
                result.add(i);
        }

        if (result.isEmpty())
            result.add(-1);
        Collections.sort(result);
        return result;
    }
    
}