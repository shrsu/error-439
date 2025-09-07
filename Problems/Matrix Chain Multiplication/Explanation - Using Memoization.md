## Recap

- In recursion, we solved the problem but made **excessive calls**.
- Example: Subproblems like `m(1,2)` or `m(2,3)` were solved multiple times.
- This shows **overlapping subproblems** → a perfect case for **Dynamic Programming (DP)**.

---

## Idea of Memoization

1. Store results of subproblems `(i, j)` in a **2D DP table** `M[i][j]`.
2. If `(i, j)` is already solved, **don’t solve again**, just return the stored result.
3. Initialize table with `1` (unknown values).
4. Each recursive call:
    - If `i == j` → `M[i][j] = 0`.
    - If `M[i][j] != -1` → return stored value.
    - Else → compute minimum cost, store in `M[i][j]`, then return it.

---

## Extra Table for Parenthesization

- Besides cost, we also need **splitting points (`k`)** for optimal order.
- Create another 2D array `K[i][j]` to store the value of `k` that gave the minimum cost.
- Later, use `K` to reconstruct the **optimal parenthesization**.

---

## Time & Space Complexity

- **Time**:
    - Only `(n*(n+1))/2 ≈ O(n²)` subproblems solved.
    - Each requires trying `k` (up to `n`), so total = **O(n³)**.
- **Space**:
    - Two `n×n` tables (`M` and `K`) → **O(n²)**.
- Much better than exponential recursion.

---

## Example Run

For matrices:

- A (3×2), B (2×4), C (4×2), D (2×5)

**Output**:

```
Minimum cost of multiplication: 58
Optimal Parenthesization: ((AB)C)D

```

---