## Recap

- **Recursive method** → Works but exponential.
- **Memoization** → Top-down DP, avoids recomputation using recursion + DP table.
- **Tabulation** → Bottom-up DP, avoids recursion completely.

In tabulation, we fill the DP table **iteratively**, diagonal by diagonal.

---

## Key Observations

1. **Base Case (Diagonal = 0)**
    - `M[i][i] = 0` (multiplying one matrix costs nothing).
2. **Filling Order**
    - Fill **diagonal by diagonal**:
        - 1st diagonal → length 2 (cost of multiplying 2 matrices).
        - 2nd diagonal → length 3.
        - Continue until length = `n`.
3. **Transition Formula**
    
    For any chain `(i, j)`:
    

```
M[i][j] = min(
   M[i][k] + M[k+1][j] + d[i-1] * d[k] * d[j]
)  for all k = i..(j-1)

```

- Also store the `k` giving the minimum in `K[i][j]` (for parenthesization).

---

## Time & Space Complexity

- **Time**: O(n³) (since for each `(i, j)` we check all `k`).
- **Space**: O(n²) for `M` and `K` tables.
- Same complexity as memoization, but **no recursion / stack usage**.

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

- **Time Complexity**:
    - Fill DP table of size `n²`.
    - For each `(i, j)`, try `k = i..(j-1)` → O(n).
    - Total = **O(n³)**.
- **Space Complexity**:
    - Two DP tables (`M`, `K`) = **O(n²)**.
    - No recursion stack.
    - **Overall Space = O(n²)**.