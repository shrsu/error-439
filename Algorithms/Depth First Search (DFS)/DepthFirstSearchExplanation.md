## **Step 1: Graph Representation**

* The graph is stored as an **adjacency list** (`Map<Integer, List<Integer>>`).
* Each node (key) maps to a list of its neighbors (value).

---

## **Step 2: dfsHelper (Recursive DFS)**

* This is the core DFS logic.
* When called with a node:

  1. Mark the node as **visited**.
  2. **Process** it (here: print the node).
  3. Look at all neighbors of the node:

     * If a neighbor hasn’t been visited yet, **recursively call** `dfsHelper` on that neighbor.

This explores as far as possible along one path before backtracking.

---

## **Step 3: dfs (Driver for All Components)**

* DFS normally explores **only one connected component** of the graph.
* To make sure **all nodes are covered** (even if the graph is disconnected):

  1. Create an empty `visited` set.
  2. Loop through all nodes in the adjacency list.
  3. If a node hasn’t been visited, start a new DFS from it by calling `dfsHelper`.

---

## **Step 4: Execution Flow**

* Pick a starting node → mark visited → print → explore neighbors.
* Go deeper recursively until no new neighbor is left.
* Backtrack and continue with other neighbors.
* After finishing one component, check for another unvisited node and repeat.

---

## **Step 5: End Result**

* Every node in the graph gets visited **once**.
* The DFS order (the sequence of printed nodes) depends on:

  * The structure of the graph.
  * The order of neighbors in the adjacency list.
