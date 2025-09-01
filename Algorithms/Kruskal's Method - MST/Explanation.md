# Background

- **Minimum Spanning Tree (MST)**: For a connected, undirected, weighted graph, an MST is a subset of edges that connects all vertices with **no cycles** and **minimum total weight**.
- **Kruskal’s algorithm**: A classic greedy method that:
    1. sorts all edges by weight (lightest first),
    2. keeps adding the next lightest edge **that doesn’t form a cycle**,
    3. stops when you’ve added **V−1** edges.
- **How to detect cycles fast?** Use **Disjoint Set Union (DSU / Union–Find)** with **path compression** and **union by rank**.

---

# Steps:

1. **Graph input (adjacency list of an undirected graph).**
    
    Store each undirected edge twice (u→v and v→u).
    
2. **Convert adjacency list → edge list (dedup).**
    
    ```java
    boolean[][] visited = new boolean[V][V];
    for (int u = 0; u < V; u++) {
      for (Edge e : adjList.get(u)) {
        if (!visited[u][e.dest]) {
          edges.add(new Edge(u, e.dest, e.weight));
          visited[u][e.dest] = visited[e.dest][u] = true;
        }
      }
    }
    ```
    
    This ensures each undirected edge appears exactly once in `edges`.
    
3. **Sort edges by weight (ascending).**
    
    ```java
    Collections.sort(edges);
    
    ```
    
    (Greedy order.)
    
4. **Initialize DSU.**
    
    Each vertex starts in its own set: `parent[i] = i`.
    
    - `find(x)` uses **path compression** so future finds are faster.
    - `union(x, y)` uses **union by rank** to keep trees shallow.
5. **Build the MST.**
    
    Iterate edges in increasing weight:
    
    - If `find(src) != find(dest)`, they’re in different components → **add the edge** to MST, **union** the two sets, **accumulate cost**.
    - Otherwise, **skip** (it would make a cycle).
6. **Output result.**
    
    Prints the MST edges and total cost.
    
---

# Complexity

- Sorting edges: **O(E log E)**
- DSU operations across all edges: ~**O(E α(V))** (α is the inverse Ackermann function, basically constant)
- Overall: **O(E log E)**

---