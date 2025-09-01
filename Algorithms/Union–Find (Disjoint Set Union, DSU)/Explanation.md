# Union–Find (Disjoint Set Union, DSU)

---

## Steps:

### 1. **Disjoint Set Union (DSU) class**

- You created a helper class `DSU` that supports:
    - `find(x)` → finds the representative (root/parent) of the set that `x` belongs to.
        - Uses **path compression**: flattens the structure so future queries are faster.
    - `union(a, b)` → tries to merge two sets containing `a` and `b`.
        - Uses **union by size**: always attach the smaller tree under the larger tree.
        - If `a` and `b` are already in the same set (`find(a) == find(b)`), it returns `false` → meaning **cycle detected**.

---

### 2. **Adjacency List Representation**

- The graph is stored as a **map**:
    
    `Map<Integer, List<Integer>> adj`
    
    - Each key = a vertex.
    - Each value = list of neighbors.
- Example for `Graph 1` (no cycle):
    
    ```
    0 → [1]
    1 → [0,2]
    2 → [1,3]
    3 → [2,4]
    4 → [3]
    
    ```
    

---

### 3. **Avoiding duplicate edges**

- Since the graph is **undirected**, both `(u,v)` and `(v,u)` appear in adjacency list.
- You avoid processing the same edge twice by keeping a `Set<String> seenEdges`.
    - Store each edge as `"min(u,v)-max(u,v)"`.
    - Before processing an edge, check if it’s already seen.

Example: edge `(0,1)` is stored as `"0-1"`.

When `(1,0)` shows up later, `"0-1"` is already in `seenEdges`, so you skip it.

---

### 4. **Cycle Detection Logic**

For each edge `(u,v)`:

1. Call `union(u, v)`.
2. If
    - `union` returns **true** → sets were merged successfully (no cycle yet).
    - `union` returns **false** → `u` and `v` were already connected → adding this edge would form a cycle → return `true`.

---

## Recap of Steps

1. **Build adjacency list** for the graph.
2. **Initialize DSU** with all vertices in their own sets.
3. **Iterate over all edges**, skipping duplicates.
4. Use **union–find**:
    - If two vertices belong to different sets → merge.
    - If they belong to the same set → **cycle found**.
5. Print result.

---