## Intuition

We define a recursive function `LCS(i, j)` → the LCS length of the prefixes `text1[0..i-1]` and `text2[0..j-1]`.

- **Base case**: If either `i == 0` or `j == 0`, return `0` (empty string case).
- **If last characters match**:
    
    `1 + LCS(i-1, j-1)`
    
- **If last characters don’t match**:
    
    `max(LCS(i-1, j), LCS(i, j-1))`
    

This will branch into a recursion tree.

Drawback: Exponential time complexity **O(2^(m+n))** due to repeated subproblems.

---
