import java.util.*;
public class BreadthFirstSearchAlgorithm {
    // BFS traversal covering all disconnected components
    public void bfs(Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>(); // keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // queue for BFS
        // Loop through all nodes in the graph
        for (int startNode : adjList.keySet()) {
            if (!visited.contains(startNode)) {
                // Begin BFS from this unvisited node
                queue.offer(startNode);
                visited.add(startNode);
                while (!queue.isEmpty()) {
                    int node = queue.poll(); // dequeue current node
                    System.out.print(node + " "); // process (print) the node
                    // Enqueue all unvisited neighbors
                    for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
    }
}
