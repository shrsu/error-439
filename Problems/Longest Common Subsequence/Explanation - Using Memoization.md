## 1. Intuition

The **Longest Common Subsequence (LCS)** problem asks:

Given two strings, what’s the longest sequence that appears in both, maintaining order (but not necessarily contiguous)?

Example:

`text1 = "abcde"`, `text2 = "ace"`

The LCS is `"ace"` with length **3**.

Key Observations:

- If the last characters of both strings match → include it in the LCS and move both indices left.
- If they don’t match → try skipping one character from either string and take the maximum result.
- Eventually, if either string becomes empty → LCS length is 0 (base case).

This leads naturally to **recursion + dynamic programming**:

- **Recursion** explores all possible subsequences.
- **Memoization/Tabulation** optimizes by avoiding repeated subproblems.

---

## 2. Dynamic Programming Approach

Because recursion has overlapping subproblems, we use **DP table**.

- Create a 2D array `dp[m+1][n+1]` where `m = text1.length`, `n = text2.length`.
- `dp[i][j]` → LCS length between `text1[0..i-1]` and `text2[0..j-1]`.
- Fill the table bottom-up using the recurrence rules.

---
