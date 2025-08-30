# **Intro**

- A **Strongly Connected Component (SCC)** is a maximal group of vertices in a directed graph such that **every vertex is reachable from every other vertex** in that group.
- **Tarjan’s Algorithm** is a **single-pass DFS-based algorithm** for finding SCCs using **discovery time** and **low-link values**.
- Time Complexity: **O(V + E)** (linear in graph size).
- Space Complexity: **O(V)** (for recursion, arrays, and stack).

---

# **Steps of Tarjan’s Algorithm**

1. **Assign discovery time and low-link value**
    - Each node gets a unique **discovery time** when it’s first visited.
    - Its **low-link value** represents the earliest discovered node reachable from it (including itself, descendants, and back edges).
2. **DFS traversal**
    - Push node onto a stack (mark it as “in stack”).
    - Recursively DFS on unvisited neighbors.
    - If neighbor is in stack, update current node’s low-link value.
3. **Check for SCC root**
    - If for node `u`, `disc[u] == low[u]`, then `u` is the **head of an SCC**.
    - Pop nodes from stack until `u` is removed → all these nodes form one SCC.

---

# **Step-by-Step Explanation**

### **Step 1: Discovery Time and Low-Link**

- Each node gets:
    - **disc[u]** = time when `u` is visited.
    - **low[u]** = smallest discovery time reachable from `u`.

---

### **Step 2: DFS**

- Push `u` to stack.
- For each neighbor `v`:
    - If `v` unvisited → DFS on `v` and update `low[u] = min(low[u], low[v])`.
    - If `v` in stack (back edge) → update `low[u] = min(low[u], disc[v])`.

---

### **Step 3: Identify SCC**

- If `disc[u] == low[u]` → `u` is **SCC root**.
- Pop from stack until `u` is popped → all popped nodes form **one SCC**.

---

# **Example Run**

Graph:

```
0 → 1
1 → 2
2 → 0, 3
3 → 4
4 → 5, 7
5 → 6
6 → 4

```

---

### **DFS Execution**

- Start at `0` → visits `1` → `2` → back to `0` forms **SCC = {0,1,2}**.
- From `2` → `3 → 4 → 5 → 6` cycle → **SCC = {4,5,6}**.
- Node `7` is alone → **SCC = {7}**.

---

# **Final SCCs**

```
{0,1,2}
{4,5,6}
{7}

```

---

**Key Difference from Kosaraju:**

- **Kosaraju** needs 2 DFS + transpose graph.
- **Tarjan** finds SCCs in **1 DFS**, using **low-link values**.

---