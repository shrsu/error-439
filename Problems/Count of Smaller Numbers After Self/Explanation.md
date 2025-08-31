# Step-by-Step Approach (Binary Search + Sorted List)

We want better than `O(n²)` brute force.

1. **Initialize:**
    - `sortedList = []` → maintains elements we’ve seen so far (to the right) in sorted order.
    - `result = new int[n]` → stores counts for each index.
2. **Iterate from right to left:**
    - For each `nums[i]`, find the index (`pos`) where it would be inserted in `sortedList` to keep it sorted.
    - This `pos` directly equals the number of elements smaller than `nums[i]`.
    - Insert `nums[i]` at that position.
3. **Binary Search (for insertion index):**
    - Use `Collections.binarySearch` (Java) or `bisect` (Python) to find position in `O(log n)`.
    - Insertion in `ArrayList` is `O(n)` worst case, so complexity is `O(n²)` worst case but works for moderate constraints.

A more optimal solution uses **Balanced BST / Fenwick Tree / Merge Sort** (`O(n log n)`), but this binary search + list approach is simple and intuitive.

---

# Merge Sort Based Approach (`O(n log n)`)

The trick is to **count during merge**:

1. Treat it like **merge sort** (divide & conquer).
2. Keep track of **original indices** because we must update counts in the correct positions.
3. When merging:
    - If an element from the left half is greater than an element from the right half, then that left element is **bigger than all remaining elements in the right half**.
    - Increment the count for that left element accordingly.

---

# Dry Run (with `[5,2,6,1]`)

- Divide into halves until single elements.
- Merge `[5,2]` → while merging:
    - `2` < `5`, so `count[5]++` → count becomes `[1,0,...]`
- Merge `[6,1]` → while merging:
    - `1` < `6`, so `count[6]++` → count becomes `[1,0,1,0]`
- Merge `[2,5]` and `[1,6]`:
    - While merging, `1` < `2`, so `count[2]++` and `count[5]++`.
- Final count = `[2,1,1,0]`.

---

# Complexity

- **Time:** `O(n log n)` (merge sort dominates)
- **Space:** `O(n)` for temporary storage

---