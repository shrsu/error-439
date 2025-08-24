**Heap Sort** is a **comparison-based sorting algorithm** that uses a special data structure called a **Heap** (specifically, a **Binary Heap**).

- A **Binary Heap** is a complete binary tree that satisfies the **Heap Property**:
    - **Max-Heap:** Parent ≥ Children
    - **Min-Heap:** Parent ≤ Children

For sorting in ascending order, we use a **Max-Heap**.

---

# Steps of Heap Sort Algorithm

Let’s assume we want ascending order:

1. **Build a Max-Heap** from the input array.
    - Largest element will be at the root (`arr[0]`).
2. **Swap root with last element.**
    - Move the largest element to its correct position at the end.
3. **Reduce heap size by 1** and **heapify** the root again to maintain heap property.
4. **Repeat** until the heap size becomes `1`.

---

# Example Walkthrough

Array: `[4, 10, 3, 5, 1]`

1. Build Max-Heap → `[10, 5, 3, 4, 1]`
2. Swap max (10) with last → `[1, 5, 3, 4, 10]`
    - Heapify → `[5, 4, 3, 1, 10]`
3. Swap max (5) with second-last → `[1, 4, 3, 5, 10]`
    - Heapify → `[4, 1, 3, 5, 10]`
4. Swap max (4) with third-last → `[3, 1, 4, 5, 10]`
    - Heapify → `[3, 1, 4, 5, 10]` (already correct)
5. Swap max (3) with second → `[1, 3, 4, 5, 10]`

Final sorted array: `[1, 3, 4, 5, 10]`

---

# Time Complexity

- **Building heap:** `O(n)`
- **Heapify each element:** `O(log n)`
- **Overall:** `O(n log n)`
- **Space Complexity:** `O(1)` (in-place sorting)

---

# Stability of Heap Sort

**Heap Sort is NOT stable.**

(Like Shell Sort, equal elements can change order because of swaps.)

---
