import java.util.*;

public class Algorithm {
    private int time = 0; // global timer for discovery time
    private Map<Integer, List<Integer>> adjList;
    private int[] disc, low; // discovery and low-link arrays
    private boolean[] inStack;
    private Stack<Integer> stack;

    public Algorithm(Map<Integer, List<Integer>> adjList, int n) {
        this.adjList = adjList;
        disc = new int[n];
        low = new int[n];
        inStack = new boolean[n];
        stack = new Stack<>();

        Arrays.fill(disc, -1); // -1 means unvisited
        Arrays.fill(low, -1);

        // Run DFS for each node (handle disconnected graphs too)
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i);
            }
        }
    }

    private void dfs(int u) {
        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;

        // Explore neighbors
        for (int v : adjList.getOrDefault(u, new ArrayList<>())) {
            if (disc[v] == -1) {
                // Tree edge
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is head node of SCC
        if (low[u] == disc[u]) {
            System.out.print("SCC: ");
            while (true) {
                int v = stack.pop();
                inStack[v] = false;
                System.out.print(v + " ");
                if (v == u)
                    break;
            }
            System.out.println();
        }
    }

}
