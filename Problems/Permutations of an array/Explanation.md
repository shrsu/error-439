# Explanation of the Solution

We use **backtracking**:

1. **Base case**:
    - If the current `path` has the same length as `nums`, we found a permutation → add a copy to `ans`.
2. **Recursive step**:
    - For each number in `nums`:
        - If it’s not already used in the current permutation, add it.
        - Recurse with the updated path.
        - Backtrack by removing it.

---

# Complexity Analysis

- **Time Complexity:**
    - There are `n!` permutations for `n` numbers.
    - Each permutation requires `O(n)` work (to build/copy the list).
    - Overall: **O(n × n!)**.
- **Space Complexity:**
    - Recursion stack: `O(n)`
    - `used[]` array: `O(n)`
    - Output storage: `O(n × n!)`

---