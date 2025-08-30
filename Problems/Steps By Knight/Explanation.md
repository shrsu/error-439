# Technique Used

- **Breadth-First Search (BFS)** on the chessboard.
- BFS is used because:
    - Each move of a knight has the same “cost” (1 step).
    - BFS guarantees the shortest path in an unweighted graph.

---

# Time Complexity

- Each cell `(x, y)` is processed **at most once**.
- At most, there are `N × N` cells.
- For each cell, we check up to **8 knight moves**.

**Time Complexity = O(N²)**

---

# Space Complexity

- We maintain a `visited[N][N]` array → `O(N²)`.
- The BFS queue can store up to `O(N²)` cells in the worst case.

**Space Complexity = O(N²)**

---

# Process (Step-by-Step)

### **1. Input**

- Read:
    - `N` = size of board.
    - Knight position `(KnightPos[0], KnightPos[1])`.
    - Target position `(TargetPos[0], TargetPos[1])`.

### **2. Adjust for 0-based Index**

- Convert given positions from **1-based** (chessboard style) to **0-based** for array access.

### **3. BFS Initialization**

- Create a queue of cells.
- Mark knight’s starting position as visited, push it into the queue with `dist = 0`.

### **4. BFS Traversal**

- While queue not empty:
    - Pop the current cell.
    - For each of the **8 knight moves**:
        - Check if the move is inside the board and not visited.
        - If it’s the target → return current distance + 1.
        - Else → mark visited and push into queue with incremented distance.

### **5. End Condition**

- If BFS finishes without reaching the target → return `1`.

---

# Example Run

### Input:

```
6
4 5
1 1

```

(Board size = 6×6, Knight at (4,5), Target at (1,1))

### BFS Path:

- Start: `(3,4)` in 0-based, distance = 0
- Moves expand outward level by level until `(0,0)` is reached.

### Output:

```
3

```

(Minimum 3 steps required)

---