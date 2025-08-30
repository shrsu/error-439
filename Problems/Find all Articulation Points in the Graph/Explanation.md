# Problem Restatement

- You are given a **connected undirected graph** with `V` vertices.
- An **articulation point (AP)** is a vertex whose removal (along with edges) **increases the number of connected components**.
- Return all such vertices in **sorted order**, or `[-1]` if none exist.

---

# Technique Used

This uses **DFS + Discovery Time + Low Link Values** (Tarjan’s algorithm idea, similar to bridges but applied to vertices).

We maintain:

- `disc[u]` → discovery time of vertex `u` (when it was first visited).
- `low[u]` → lowest discovery time reachable from `u` (using tree edges + back edges).
- `children` count → number of DFS children of `u`.
- `isAP[u]` → boolean marker if `u` is an articulation point.

---

# Time Complexity

- Each vertex is visited once → `O(V)`.
- Each edge is explored once → `O(E)`.
- Sorting result → `O(V log V)` in worst case.

**Time Complexity = O(V + E)**

**Space Complexity = O(V + E)** (adjacency list + recursion stack + arrays).

---

# Process (Step by Step)

### **1. DFS Initialization**

- Arrays:
    - `disc[V]` = discovery time.
    - `low[V]` = low-link values.
    - `visited[V]` = track visited nodes.
    - `isAP[V]` = articulation point flags.
- Start DFS from every unvisited vertex (graph is connected, but still robust for general case).

---

### **2. DFS Visit**

When visiting a vertex `u`:

```java
disc[u] = low[u] = ++time;
visited[u] = true;
children = 0;

```

---

### **3. Traverse Neighbors**

For each neighbor `v` of `u`:

- **Case 1: `v` is the parent**
    
    → Skip it (we don’t go back to parent).
    
- **Case 2: `v` is not visited**
    - Increase `children` count.
    - Recurse `dfs(v, u, …)`.
    - After recursion:
        
        `low[u] = min(low[u], low[v])`
        
    - **Articulation point condition for non-root:**
        
        If `(parent != -1 && low[v] >= disc[u])` → mark `u` as AP.
        
- **Case 3: `v` is visited (back edge)**
    - Update:
        
        `low[u] = min(low[u], disc[v])`
        

---

### **4. Root Special Case**

- If `u` is the **root** (`parent == -1`) and has more than one child (`children > 1`), then root is an articulation point.

---

### **5. Collect Results**

- After DFS, collect all vertices marked `isAP[u] == true`.
- If none → return `[-1]`.
- Otherwise return sorted list.

---

# Example Walkthrough

### Input:

```
5 5
0 1
1 2
0 2
2 3
3 4

```

### DFS:

- Start at 0 → children = 2 (through 1, 2) → root 0 is **not AP** (because low[1] and low[2] < disc[0]).
- At 1:
    - DFS to 2, which reaches back to 0 → low[1] = min(1, 0).
    - No AP condition triggered for 1 yet.
- At 2:
    - DFS to 3 → low[3] = 3.
    - Check: `low[3] >= disc[2]` → true → mark 2 as AP.
- At 3:
    - DFS to 4 → low[4] = 4.
    - Check: `low[4] >= disc[3]` → true → mark 3 as AP.

### Result:

```
1 4

```

---

# Summary (TTP)

- **Technique:** DFS + Tarjan’s Algorithm (disc[] & low[]).
- **Time Complexity:** O(V + E).
- **Space Complexity:** O(V + E).
- **Process:**
    - Run DFS.
    - Track discovery & low-link values.
    - Apply conditions:
        - `(parent != -1 && low[v] >= disc[u])` → AP.
        - `(parent == -1 && children > 1)` → AP.
    - Collect and sort articulation points.

---