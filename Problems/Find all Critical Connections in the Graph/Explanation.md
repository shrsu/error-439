# Steps of the Algorithm

## **1. Background**

- A **bridge** (critical connection) in an undirected graph is an edge whose removal **increases the number of connected components**.
- To find bridges, we use:
    - **Discovery time (`disc[]`)** → when a node is first visited in DFS.
    - **Low time (`min[]`)** → the earliest discovered vertex reachable from a node (using back edges).
- If for an edge `(u, v)`, we see that:
    
    ```
    disc[u] < low[v]
    
    ```
    
    then edge `(u, v)` is a **bridge**.
    

---

## **2. Initialization**

- Arrays created:
    - `disc[v]`: stores discovery times of vertices (initially -1 = unvisited).
    - `min[v]`: stores the lowest discovery time reachable from that vertex.
    - `parent[v]`: stores DFS parent.
- A global counter `count` is used to assign discovery times.

---

## **3. DFS Traversal**

For each unvisited node `v`:

1. Assign:
    
    ```java
    disc[v] = min[v] = count++;
    
    ```
    
    → The node `v` is visited, with discovery time equal to `count`.
    
2. For each neighbor `neighbour` of `v`:
    - If **neighbor not visited** (`disc[neighbour] == -1`):
        - Mark its parent as `v`.
        - Recurse: `dfs(neighbour, ...)`.
        - Update low time:
            
            ```
            min[v] = min(min[v], min[neighbour])
            
            ```
            
        - After returning from DFS, check:
            
            ```
            if (disc[v] < min[neighbour])
                (v, neighbour) is a bridge
            
            ```
            
    - Else if the neighbor is **already visited** and not the parent:
        - Update low time to account for back edge:
            
            ```
            min[v] = min(min[v], disc[neighbour])
            
            ```
            

---

## **4. Bridge Detection Rule**

- After DFS, an edge `(v, neighbour)` is a **bridge** if:
    
    ```
    disc[v] < min[neighbour]
    
    ```
    
    because this means `neighbour` and its subtree **cannot reach back to `v` or any of its ancestors**.
    

---

## **5. Sorting Results**

- Each bridge is stored in `(min(u, v), max(u, v))` form (to maintain order).
- Finally, the list of bridges is **sorted**:
    - First by smaller endpoint.
    - Then by larger endpoint.

---

# Example Walkthrough

### Input:

```
4 4
0 1
0 2
1 2
2 3

```

### Step by Step:

1. Start DFS at `0`.
    - `disc[0] = 0, min[0] = 0`.
2. Visit `1`.
    - `disc[1] = 1, min[1] = 1`.
    - Explore neighbors (0 already visited).
3. Visit `2`.
    - `disc[2] = 2, min[2] = 2`.
    - Neighbor `1` already visited (back edge): `min[2] = min(2, 1) = 1`.
    - Visit `3`.
        - `disc[3] = 3, min[3] = 3`.
        - No more neighbors → return.
        - For `(2,3)`: check `disc[2] < min[3] → 2 < 3` → Bridge found `(2,3)`.
    - Backtrack to `2`: `min[2] = min(1, 3) = 1`.
4. Backtrack to `1`: `min[1] = min(1, 1) = 1`.
5. Backtrack to `0`: `min[0] = min(0, 1) = 0`.

Final answer = `(2,3)`.

---