import java.util.*;

public class Algorithm {

    // Edge in the adjacency list
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Node wrapper for the priority queue (min-heap by dist)
    static class Node implements Comparable<Node> {
        int vertex, dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }

    /**
     * Dijkstra’s algorithm (with path reconstruction).
     *
     * STEP 0: Setup dist[], parent[], and the min-heap (pq)
     * STEP 1: Initialize dist[source] = 0 and push (0, source) into pq
     * STEP 2: While pq not empty:
     * 2a. Pop the node (u) with smallest dist
     * 2b. For each edge (u -> v, w):
     * - RELAXATION: if dist[u] + w < dist[v], update dist[v] and parent[v] = u, and
     * push (dist[v], v)
     * STEP 3: After loop, dist[] holds final shortest distances; parent[]
     * reconstructs paths
     * STEP 4: Print distances and paths
     */
    public static void dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size();

        // STEP 0: Setup
        int[] dist = new int[V]; // best-known distances
        int[] parent = new int[V]; // to reconstruct paths (shortest path tree)
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // STEP 1: Initialize source
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        // STEP 2: Process vertices in increasing distance order
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;

            // Explore neighbors of u
            for (Edge e : graph.get(u)) {
                int v = e.to;
                int newDist = dist[u] + e.weight;

                // STEP 2b: RELAXATION check
                if (newDist < dist[v]) {
                    dist[v] = newDist; // found a shorter path to v
                    parent[v] = u; // remember how we got to v
                    pq.add(new Node(v, newDist));
                }
            }
        }

        // STEP 4: Print results with paths
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Source -> " + i + " : INF (unreachable)");
            } else {
                System.out.print("Source -> " + i + " : " + dist[i] + " | Path: ");
                printPath(i, parent);
                System.out.println();
            }
        }
    }

    // Utility: print path from source to target using parent[]
    private static void printPath(int v, int[] parent) {
        if (v == -1)
            return;
        List<Integer> path = new ArrayList<>();
        while (v != -1) {
            path.add(v);
            v = parent[v];
        }
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)); // change to (path.get(i) + 1) for 1-based display
            if (i < path.size() - 1)
                System.out.print(" -> ");
        }
    }

    public static void main(String[] args) {
        int V = 6; // vertices 0..5
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        // Build the same undirected graph from your lecture example
        addEdge(graph, 0, 1, 1);
        addEdge(graph, 0, 2, 5);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 10);
        addEdge(graph, 1, 4, 8);
        addEdge(graph, 2, 4, 2);
        addEdge(graph, 4, 3, 3);
        addEdge(graph, 3, 5, 2);
        addEdge(graph, 4, 5, 7);

        int source = 0;
        dijkstra(graph, source);
    }

    // Helper: add undirected edge (u <-> v) with weight w
    private static void addEdge(List<List<Edge>> g, int u, int v, int w) {
        g.get(u).add(new Edge(v, w));
        g.get(v).add(new Edge(u, w));
    }
}
