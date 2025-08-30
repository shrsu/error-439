## **Intro**

- A **Strongly Connected Component (SCC)** is a maximal group of vertices in a directed graph such that **every vertex is reachable from every other vertex** in that group.
- **Kosaraju’s Algorithm** is a two-pass DFS-based algorithm for finding SCCs.
- Time Complexity: **O(V + E)** (linear in graph size).

---

## **Steps of Kosaraju’s Algorithm**

1. **Do a DFS on the original graph**
    - Maintain a **stack** to store nodes in order of their finishing times (when DFS completes for a node).
2. **Transpose the graph**
    - Reverse all edges in the graph.
3. **Do DFS on the transposed graph**
    - Pop nodes from the stack (highest finishing time first).
    - Each DFS traversal gives one **Strongly Connected Component**.

---

## **Step-by-Step Explanation**

### **Step 1: First DFS (Fill Stack)**

- Run DFS on original graph.
- After visiting all neighbors of a node, push it onto the stack.
- This ensures nodes are stored in order of **finishing time** (later finished = on top).

---

### **Step 2: Transpose Graph**

- Reverse all edges:
    - If original has edge `u → v`, in transpose it becomes `v → u`.

---

### **Step 3: Second DFS (Using Stack Order)**

- Pop nodes one by one from the stack.
- For each popped node:
    - If it’s unvisited, perform DFS on transpose graph.
    - All nodes visited in this DFS form **one SCC**.
- Print/collect that SCC.

---

## **Example Run**

Graph:

```
1 → 2
2 → 3
3 → 1
3 → 4
4 → 5
5 → 4

```

### **Step 1: DFS order (stack by finishing times)**

- Suppose stack order ends as: `[4, 5, 3, 2, 1]`.

---

### **Step 2: Transpose Graph**

Edges reversed:

```
2 → 1
3 → 2
1 → 3
4 → 3
5 → 4
4 → 5

```

---

### **Step 3: DFS on Transpose (pop from stack)**

1. Pop `4` → visit `{4, 5}` → **SCC = {4,5}**
2. Pop `5` (already visited).
3. Pop `3` → visit `{3,2,1}` → **SCC = {3,2,1}**
4. Pop `2` and `1` (already visited).

**Final SCCs:**

```
{4,5}
{1,2,3}

```

---