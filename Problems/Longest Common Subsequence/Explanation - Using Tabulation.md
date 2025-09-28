---

## Steps for Tabulation Solution

1. Initialize `dp[0][j] = 0` and `dp[i][0] = 0` (base case: empty string).
2. Loop through `i = 1..m`, `j = 1..n`.
    - If `text1[i-1] == text2[j-1]`:
        
        `dp[i][j] = 1 + dp[i-1][j-1]`.
        
    - Else:
        
        `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.
        
3. Final answer = `dp[m][n]`.

Time Complexity: **O(m × n)**

Space Complexity: **O(m × n)** (can be optimized to O(min(m, n))).

---
