You are given an **undirected connected graph** with **V** vertices, represented using an adjacency list **adj**. Your task is to find all the **articulation points** in the graph.

An **articulation point** (or cut vertex) is a vertex that, if removed along with its connected edges, increases the number of connected components in the graph. In simpler terms, removing this vertex will break the graph into two or more disconnected parts.

You must return a **sorted list** of all such vertices. If there are **no articulation points**, return a list containing only **-1**.

**Input Format**

- **First line:** Two integers V and E, the number of vertices and number of edges.
- **Next E lines:** Two integers u and v denoting an undirected edge between vertex u and v.

**Output Format**

- Return a sorted list of all articulation points.
- If none exist, return **[-1]**.

**Example 1**

```
Input:
5 5
0 1
1 2
0 2
2 3
3 4

Output:
1 4

```

**Explanation:**

- Removing vertex 1 disconnects node 0 from the rest of the graph.
- Removing vertex 4 isolates it and cuts off part of the graph.

**Your Task**

You need to implement the following function:

**def articulationPoints(V: int, adj: List[List[int]]) -> List[int]:**

This function should return a sorted list of articulation points in the graph. If there are none, return **[-1]**.

**Constraints**

- 1 ≤ V ≤ 10^5
- The graph is **connected**
- The graph may contain **loops** or **multiple edges**

---
