## 1. Recap of Previous Approaches

- **Recursion:** Explored all subsets → exponential `O(2^n)`.
- **Memoization:** Saved overlapping subproblems in a 2D table → `O(n*W)`.
- **Tabulation:** Instead of recursion, we **directly fill the DP table iteratively**.

Tabulation is the **bottom-up** version of dynamic programming.

---

## 2. Idea Behind Tabulation

- We already saw that recursion + memoization fills a table (`dp[n][W]`).
- In memoization, the table was filled **on-demand** (when recursion needed it).
- In tabulation, we **systematically fill the entire table row by row** using loops.

This avoids recursion entirely.

---

## 3. DP Table Setup

- Let `n` = number of items.
- Let `W` = capacity of knapsack.
- Create a table `dp[n+1][W+1]`.

### Meaning:

- `dp[i][j]` = maximum profit when using **first i items** with **capacity j**.

---

## 4. Base Cases

- First row (`i=0`) → 0 (no items → 0 profit).
- First column (`j=0`) → 0 (capacity 0 → 0 profit).

---

## 5. Transition Formula

For each item `i` (1..n) and capacity `j` (1..W):

1. If the item’s weight is more than capacity:
    
    ```
    dp[i][j] = dp[i-1][j]
    
    ```
    
    (skip the item).
    
2. Otherwise:
    
    ```
    dp[i][j] = max(
        dp[i-1][j],                          // exclude item i
        profit[i-1] + dp[i-1][j - weight[i-1]] // include item i
    )
    
    ```

---

## Example Run (Profits `{6,5,3,8}`, Weights `{1,2,1,2}`, Capacity `5`)

- DP Table filled iteratively (values match memoization).
- Output:

```
Maximum profit = 19
Items included (0-indexed): Item1 Item2 Item4

```

---

## Key Observations

- **Tabulation = Bottom-Up DP**:
    - Start with smaller subproblems → build up to final solution.
- **Time complexity:** `O(n*W)`.
- **Space complexity:** `O(n*W)` (can be optimized to `O(W)`).
- We can also **trace back** the chosen items directly from the table.

---