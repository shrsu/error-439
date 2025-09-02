# Dijkstra's Algorithm

- **Problem**: Given a weighted graph and a **source** vertex *s*, find the **minimum-distance** (shortest) path from *s* to **every** other vertex.
- **Objective**: Minimize distance from *s* to all vertices (optimization / minimization).
- **Constraint**: Paths must follow existing edges; if a vertex is unreachable → distance = **∞**.
- **Graph types**: Works on **undirected** and **directed** graphs. Handles **disconnected** graphs (unreachable nodes remain ∞).
- **Key caveat**: **Dijkstra requires non-negative edge weights**. If any negative weight exists, use **Bellman–Ford** instead.
- **Greedy idea**:
    1. Maintain a set of **finalized** vertices whose shortest distances are known.
    2. Repeatedly pick the **not-yet-finalized** vertex with the **smallest tentative distance**.
    3. **Relaxation**: For each neighbor `v` of the chosen `u`, if `dist[u] + w(u,v) < dist[v]`, update `dist[v]` and set `parent[v] = u`.
- **Data structures**:
    - `dist[]`: best-known distances (initialize `dist[source]=0`, others `∞`).
    - `parent[]`: to reconstruct paths.
    - `visited[]` **or** a min-priority queue to choose the current minimum quickly.
- **Complexity**:
    - With adjacency list + binary heap (`PriorityQueue`): **O((V+E) log V)**.
    - With adjacency matrix: **O(V²)**.
- **Outputs you typically want**:
    - `dist[]` (final shortest distances)
    - `parent[]` (tree of shortest paths) → reconstruct any path by backtracking from target to source.

---
