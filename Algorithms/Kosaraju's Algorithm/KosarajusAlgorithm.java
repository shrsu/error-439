import java.util.*;

public class KosarajusAlgorithm {

    // Step 1: Standard DFS to fill stack by finish time
    private void dfsFillOrder(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited,
            Stack<Integer> stack) {
        visited.add(node);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsFillOrder(neighbor, adjList, visited, stack);
            }
        }
        stack.push(node); // push after exploring all neighbors
    }

    // Step 2: DFS on transposed graph
    private void dfsOnTranspose(int node, Map<Integer, List<Integer>> transpose, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " "); // process node

        for (int neighbor : transpose.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsOnTranspose(neighbor, transpose, visited);
            }
        }
    }

    // Main function to find SCCs
    public void findSCCs(Map<Integer, List<Integer>> adjList) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // Step 1: Fill vertices in stack according to finishing times
        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfsFillOrder(node, adjList, visited, stack);
            }
        }

        // Step 2: Create transpose graph
        Map<Integer, List<Integer>> transpose = new HashMap<>();
        for (int u : adjList.keySet()) {
            for (int v : adjList.get(u)) {
                transpose.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }
        }

        // Step 3: Do DFS on transposed graph in order of stack
        visited.clear();
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                System.out.print("SCC: ");
                dfsOnTranspose(node, transpose, visited);
                System.out.println();
            }
        }
    }
}
