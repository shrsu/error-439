import java.util.*;

public class UnionFindAlgorithm {

    // Disjoint Set (Union-Find) with path compression + union by size
    static class DSU {
        private final int[] parent;
        private final int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // each node is its own parent initially
                size[i] = 1; // each set has size 1
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb)
                return false; // already connected → cycle
            if (size[ra] < size[rb]) { // union by size
                int tmp = ra;
                ra = rb;
                rb = tmp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }
    }

    // Detect cycle in undirected graph using adjacency list
    public static boolean hasCycle(Map<Integer, List<Integer>> adj, int n) {
        DSU dsu = new DSU(n);

        // To avoid processing the same undirected edge twice
        Set<String> seenEdges = new HashSet<>();

        for (int u : adj.keySet()) {
            for (int v : adj.get(u)) {
                // create a unique key for edge (min, max)
                String key = Math.min(u, v) + "-" + Math.max(u, v);
                if (seenEdges.contains(key))
                    continue;
                seenEdges.add(key);

                if (!dsu.union(u, v))
                    return true; // cycle detected
            }
        }
        return false;
    }

    // Demo
    public static void main(String[] args) {
        int n = 5; // vertices 0..4

        // Build adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        // Example 1: no cycle (0-1-2-3-4)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        System.out.println("Graph 1 has cycle? " + hasCycle(adj, n)); // false

        // Example 2: cycle (0-1-2-0)
        Map<Integer, List<Integer>> adj2 = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj2.put(i, new ArrayList<>());
        adj2.get(0).add(1);
        adj2.get(1).add(0);
        adj2.get(1).add(2);
        adj2.get(2).add(1);
        adj2.get(2).add(0);
        adj2.get(0).add(2);
        System.out.println("Graph 2 has cycle? " + hasCycle(adj2, n)); // true
    }

}
