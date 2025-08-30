## **What is Topological Sort?**

- **Definition**: Topological Sorting of a **Directed Acyclic Graph (DAG)** is a **linear ordering** of its vertices such that for every directed edge `u → v`, **vertex `u` comes before `v`** in the ordering.
- Works only on **DAGs** (Directed Acyclic Graphs).
- Applications:
    - Task scheduling
    - Course prerequisite ordering
    - Dependency resolution (like in compilers or build systems)

---

## **Approaches**

1. **DFS-based approach** (recursive, uses stack).
2. **Kahn’s Algorithm** (BFS, uses in-degree).

I’ll explain **DFS approach** first since it’s easier to visualize.

---

## **DFS-based Topological Sort**

### **Steps**

1. Keep a `visited` array to mark visited nodes.
2. Perform DFS traversal:
    - Visit a node’s neighbors recursively.
    - After exploring all neighbors, **push the node into a stack**.
3. After DFS finishes for all nodes, the **stack contains the topological order** (reverse of finishing times).

---

## **Explanation of Example**

Graph edges:

```
5 → 2, 5 → 0
4 → 0, 4 → 1
2 → 3
3 → 1

```

One possible **Topological Order**:

`5, 4, 2, 3, 1, 0`

✔ Notice:

- `5` comes before `2` and `0`.
- `2` comes before `3`.
- `3` comes before `1`.
- `4` comes before `0` and `1`.

---