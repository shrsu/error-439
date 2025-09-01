import java.util.*;

class Edge {
    int dest, weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    int vertex, key;

    public Node(int vertex, int key) {
        this.vertex = vertex;
        this.key = key;
    }

    @Override
    public int compareTo(Node other) {
        return this.key - other.key; // sort by key (edge weight)
    }
}

public class Algorithm {

    public static void primMST(int V, List<List<Edge>> adjList) {
        // Array to store constructed MST
        int[] parent = new int[V];
        // Key values used to pick minimum weight edge
        int[] key = new int[V];
        // To keep track of vertices included in MST
        boolean[] inMST = new boolean[V];

        // Initialize all keys as infinite
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Min-heap priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Node(0, key[0]));

        while (!pq.isEmpty()) {
            // Extract the vertex with min key value
            int u = pq.poll().vertex;
            inMST[u] = true;

            // Traverse all adjacent vertices of u
            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // If v is not in MST and weight < key[v]
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        // Print MST
        int mstCost = 0;
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " : " + key[i]);
            mstCost += key[i];
        }
        System.out.println("Total Cost of MST = " + mstCost);
    }

}
