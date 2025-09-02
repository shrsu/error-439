import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight; // sort by weight
    }
}

class DisjointSet {
    int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

public class KruskalAlgorithm {

    public static void kruskalMST(int V, List<List<Edge>> adjList) {
        // Step 1: Convert adjacency list to edge list
        List<Edge> edges = new ArrayList<>();
        boolean[][] visited = new boolean[V][V]; // to avoid duplicate edges

        for (int u = 0; u < V; u++) {
            for (Edge e : adjList.get(u)) {
                if (!visited[u][e.dest]) {
                    edges.add(new Edge(u, e.dest, e.weight));
                    visited[u][e.dest] = true;
                    visited[e.dest][u] = true; // mark reverse as visited
                }
            }
        }

        // Step 2: Sort edges by weight
        Collections.sort(edges);

        // Step 3: Disjoint Set
        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();
        int mstCost = 0;

        // Step 4: Pick edges
        for (Edge edge : edges) {
            int srcRoot = ds.find(edge.src);
            int destRoot = ds.find(edge.dest);

            if (srcRoot != destRoot) {
                mst.add(edge);
                mstCost += edge.weight;
                ds.union(srcRoot, destRoot);
            }
        }

        // Step 5: Print MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
        System.out.println("Total Cost of MST = " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        List<List<Edge>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add undirected edges
        adjList.get(0).add(new Edge(0, 1, 10));
        adjList.get(1).add(new Edge(1, 0, 10));

        adjList.get(0).add(new Edge(0, 2, 6));
        adjList.get(2).add(new Edge(2, 0, 6));

        adjList.get(0).add(new Edge(0, 3, 5));
        adjList.get(3).add(new Edge(3, 0, 5));

        adjList.get(1).add(new Edge(1, 3, 15));
        adjList.get(3).add(new Edge(3, 1, 15));

        adjList.get(2).add(new Edge(2, 3, 4));
        adjList.get(3).add(new Edge(3, 2, 4));

        // Run Kruskal using adjacency list
        kruskalMST(V, adjList);
    }
}
