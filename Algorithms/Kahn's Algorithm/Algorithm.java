import java.util.*;

public class Algorithm {
    public List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        // Step 1: Calculate in-degrees
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Step 2: Add all vertices with in-degree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process queue
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            // Reduce in-degree of neighbors
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Check for cycle (if topoOrder doesn't contain all vertices)
        if (topoOrder.size() != V) {
            throw new RuntimeException("Graph has a cycle, topological sort not possible!");
        }

        return topoOrder;
    }

}
