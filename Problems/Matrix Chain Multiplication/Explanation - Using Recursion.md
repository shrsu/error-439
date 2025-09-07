# Matrix Chain Multiplication (Recursive Approach)

## Intuition

1. **Problem**: Given a chain of matrices, find the **minimum number of scalar multiplications** required to multiply them.
    - Multiplication is **associative** → result is same, but cost differs.
    - Goal: Decide the **best parenthesization order**.
2. **Dimensions Setup**:
    - If there are `n` matrices, we need **n+1 dimensions**.
    - Example:
        - A (3×2), B (2×4), C (4×2), D (2×5)
        - Dimensions array `d = [3,2,4,2,5]`
3. **Recursive Thinking**:
    - Suppose we want the cost of multiplying matrices from `i` to `j`.
    - Try **all possible splits** `k` between `i` and `j`.
    - For each split:
        - Cost =(Cost of multiplying from `i` to `k`)  +  (Cost of multiplying from `k+1` to `j`) + (Cost of multiplying the two results together).
    - The multiplication cost = `d[i-1] * d[k] * d[j]`.
4. **Base Case**:
    - If `i == j` → only one matrix → cost = 0.

---

## Steps

1. Define recursive function `m(i, j)` = min cost to multiply matrices from `i` to `j`.
2. Base condition: if `i == j` return `0`.
3. Otherwise, try all possible splits `k` between `i` and `j-1`.
4. For each split:
    
    ```
    cost = m(i, k) + m(k+1, j) + d[i-1] * d[k] * d[j]
    
    ```
    
5. Take the **minimum** cost among all splits.
6. Return this minimum.