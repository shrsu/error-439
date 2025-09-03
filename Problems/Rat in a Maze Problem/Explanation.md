# Step-by-Step Explanation

## Step 1: Representation of Maze

- We use a **2D array `maze[n][n]`** where `1` = open cell, `0` = blocked cell.
- Another **2D boolean array `visited[n][n]`** is used to avoid revisiting cells.

---

## Step 2: Base Condition

- If the rat reaches `(n-1, n-1)` and the cell is open, we have found a valid path.
- Save this path and return.

---

## Step 3: Valid Moves

For each cell `(i, j)`:

- Check four possible moves:
    - Right → `(i, j+1)`
    - Down → `(i+1, j)`
    - Left → `(i, j-1)`
    - Up → `(i-1, j)`
- Each move must:
    1. Stay **inside the grid**.
    2. Be an **open cell (`1`)**.
    3. Not be **visited before**.

---

## Step 4: Backtracking

- Mark `(i, j)` as **visited**.
- Add it to the current path.
- Recursively explore all four directions.
- After exploration, **backtrack**:
    - Remove `(i, j)` from path.
    - Mark `(i, j)` as **unvisited**.

---

## Step 5: Collect All Solutions

- Maintain a list `allPaths` to store every successful path.
- If no path exists, print `"No path found!"`.

---

## Time Complexity

- **Worst-case:** `O(4^(n^2))` (since from each cell we can explore up to 4 directions).
- **Best-case:** If there are many blocked cells, pruning reduces search → around `O(n^2)`.

---