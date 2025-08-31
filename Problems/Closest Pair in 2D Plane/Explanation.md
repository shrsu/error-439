## Steps of the Divide and Conquer Algorithm

1. **Sort all points by x-coordinate.**
    - This ensures when we divide, the left and right halves are spatially separated.
2. **Divide:**
    - Split the points into two halves: left and right, using the midpoint in x.
3. **Conquer:**
    - Recursively compute the minimum distance in the left half and right half.
4. **Combine:**
    - The closest pair could also "cross" the dividing line.
    - Collect all points within distance `d` of the dividing line (the "strip").
    - Sort this strip by y-coordinate and compare each point with the next few points (at most 6 comparisons).
    - Return the minimum of:
        - Closest pair in left half
        - Closest pair in right half
        - Closest pair across strip
5. **Base Case (small subproblems):**
    - If ≤ 3 points remain, compute distance by brute-force checking.

---

## Complexity Analysis

- **Sorting:** `O(N log N)`
- **Divide and Conquer Recursion:** `O(N log N)`
- **Strip Check:** `O(N)` (each point compared with at most 6 neighbors)
- **Overall:** `O(N log N)`

---