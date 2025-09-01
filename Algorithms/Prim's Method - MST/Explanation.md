## 1. Background

- **Goal**: Find a minimum cost spanning tree (MST) of a weighted, connected, undirected graph.
- Unlike Kruskal’s (which is **edge-based**), **Prim’s is vertex-based**.
- It starts from one vertex and grows the MST one edge at a time, always choosing the minimum-weight edge that connects the tree to a new vertex.

---

## 2. Steps of Prim’s Algorithm

1. **Start with any vertex** (say, vertex 0).
2. Keep two sets of vertices:
    - Vertices already included in the MST.
    - TVertices not yet included.
3. At each step:
    - From all edges that connect the two sets, pick the **minimum-weight edge**.
    - Add the new vertex to the MST.
4. Repeat until all vertices are included.

---

## 3. Key Points

- Uses a **priority queue (min-heap)** to efficiently get the minimum edge at each step.
- Works directly with **adjacency list** — no need to flatten into edge list.
- Complexity:
    - With adjacency matrix: `O(V^2)`
    - With adjacency list + min-heap: `O(E log V)`

---

### `int[] parent = new int[V];`

- **Meaning**: Stores the parent of each vertex in the MST.
- **Why**: This helps reconstruct the MST edges.
- **How it works**:
    - If `parent[v] = u`, it means the edge `(u, v)` is part of the MST.
    - Initially, all set to `1` because no parent is assigned.
    - Gets updated when we pick a new edge for the MST.

Example:

If `parent[3] = 0`, then the MST includes the edge `0 — 3`.

---

### `int[] key = new int[V];`

- **Meaning**: Holds the **minimum weight edge** that connects each vertex to the growing MST.
- **Why**: Prim’s algorithm always picks the vertex with the smallest `key` value that’s not yet included.
- **How it works**:
    - Initialize with infinity (`Integer.MAX_VALUE`) because initially, no vertex is reachable.
    - For the start vertex (say 0), set `key[0] = 0` (so we pick it first).
    - Whenever a better (smaller weight) edge to a vertex is found, update `key[v]`.

Example:

If `key[2] = 6`, it means the **best edge found so far** to bring vertex `2` into MST has weight `6`.

---

### `boolean[] inMST = new boolean[V];`

- **Meaning**: Tracks whether a vertex is already included in the MST.
- **Why**: Ensures we don’t add the same vertex again and avoid cycles.
- **How it works**:
    - Initially, all `false`.
    - When a vertex is extracted from the priority queue (selected into MST), mark it as `true`.

Example:

If `inMST[1] = true`, vertex `1` is already part of the MST and won’t be considered again.

---

# How They Work Together

- `key[]` chooses which vertex to add next (by min edge).
- `parent[]` records which edge brought that vertex into the MST.
- `inMST[]` makes sure we don’t revisit vertices.

---

## 4. Sample Output

```
Edges in the Minimum Spanning Tree:
0 - 3 : 5
3 - 2 : 4
0 - 1 : 10
Total Cost of MST = 19

```

---

## 5. Comparison with Kruskal

| Feature | Kruskal | Prim |
| --- | --- | --- |
| Nature | Edge-based | Vertex-based |
| Needs edge list | Yes | No, works directly on adj list |
| Best for | Sparse graphs | Dense graphs |
| Complexity | O(E log E) | O(E log V) |
