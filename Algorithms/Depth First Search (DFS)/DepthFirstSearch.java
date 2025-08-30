import java.util.*;

public class DepthFirstSearch {
    private void dfsHelper(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        // Mark current node as visited
        visited.add(node);
        System.out.print(node + " "); // Process (print) the node

        // Explore all unvisited neighbors
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, adjList, visited); // recursive call
            }
        }
    }

    // DFS traversal covering all disconnected components
    public void dfs(Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>(); // keep track of visited nodes

        // Loop through all nodes in the graph
        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfsHelper(node, adjList, visited);
            }
        }
    }
}
