## **Idea**

- Instead of DFS, we use **BFS** with an **in-degree array**.
- **In-degree** = number of incoming edges to a node.
- Steps:
    1. Compute in-degree for all vertices.
    2. Push all vertices with **in-degree = 0** into a queue (these have no dependencies).
    3. Repeatedly remove a node from the queue:
        - Add it to the topological order.
        - Decrease in-degree of all its neighbors.
        - If any neighbor’s in-degree becomes 0, push it into the queue.
    4. Continue until the queue is empty.
- Works only on **DAGs**.
    
    If the graph has a cycle → not all nodes will be included.

---

## **Explanation of Example**

Graph edges:

```
5 → 2, 5 → 0
4 → 0, 4 → 1
2 → 3
3 → 1

```

- Initial in-degree:
    
    ```
    0: 2, 1: 2, 2: 1, 3: 1, 4: 0, 5: 0
    
    ```
    
- Start with `[4, 5]` in queue (both have in-degree 0).
- Process → order can be:
    
    ```
    4, 5, 2, 0, 3, 1
    
    ```
    

This is a valid **topological order**.