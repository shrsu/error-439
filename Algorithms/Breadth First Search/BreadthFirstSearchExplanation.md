# **Breadth-First Search (BFS)**

## **Intro**

* BFS is a graph traversal algorithm that explores a graph **level by level**.
* It uses a **queue** (FIFO structure) to keep track of which nodes to visit next.
* Unlike DFS (which goes deep into one path), BFS visits all neighbors first, then their neighbors, and so on.
* Useful for **shortest path in unweighted graphs**, **finding connected components**, etc.

---
## **Step-by-Step Explanation**

### **1. Setup**

* Use a `visited` set to avoid revisiting nodes.
* Use a `queue` to store nodes that need to be explored.

---

### **2. Loop through all nodes**

* Just like DFS, BFS here also ensures **all components** are visited by looping through every node in the adjacency list.
* If a node is unvisited, start BFS from it.

---

### **3. BFS Process (inside the while-loop)**

1. **Enqueue the starting node** and mark it visited.
2. While the queue is not empty:

   * Dequeue a node (`poll()`).
   * Process it (print).
   * Check all its neighbors:

     * If a neighbor is **unvisited**, mark it visited and enqueue it.
3. Repeat until the queue is empty.

---

### **4. Traversal Behavior**

* BFS visits **all neighbors** of the current node before moving deeper.
* This makes BFS a **level-order traversal** of the graph.

---

## **Example Run**

Graph:

```
0 -- 1
|    |
2    3

4 -- 5
```

Adjacency List:

```java
{
  0 -> [1, 2],
  1 -> [0, 3],
  2 -> [0],
  3 -> [1],
  4 -> [5],
  5 -> [4]
}
```

### **Step Flow**

1. Start with `0` → visited = {0}, queue = \[0].
2. Dequeue `0`, print `0`. Neighbors = \[1, 2] → enqueue both → visited = {0,1,2}, queue = \[1,2].
3. Dequeue `1`, print `1`. Neighbor = \[0,3] → 0 already visited, enqueue `3` → visited = {0,1,2,3}, queue = \[2,3].
4. Dequeue `2`, print `2`. Neighbor = \[0] (already visited).
5. Dequeue `3`, print `3`. Neighbor = \[1] (already visited).
6. First component done → output so far: `0 1 2 3`.
7. Next unvisited node = `4`. Start BFS → queue = \[4], visited = {0,1,2,3,4}.
8. Dequeue `4`, print `4`. Neighbor = \[5] → enqueue `5`.
9. Dequeue `5`, print `5`. Neighbor = \[4] (visited).
10. Second component done.

**Final Output:**

```
0 1 2 3 4 5
```

---
