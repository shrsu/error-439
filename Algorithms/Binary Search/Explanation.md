# Binary Search

## Idea

Binary search is an efficient algorithm to find the position of a target element in a **sorted array**.
Instead of checking each element one by one (like **linear search**), it divides the search space into **halves** repeatedly.

---

## Steps of the Algorithm

1. Start with two pointers:

   * `low = 0` (beginning of the array)
   * `high = n - 1` (end of the array)
2. While `low <= high`:

   * Find the middle index:

     $$
     mid = low + (high - low) / 2
     $$

     (This avoids overflow compared to `(low + high)/2`.)

   * Compare `arr[mid]` with the target:

     * If `arr[mid] == target` → found → return index.
     * If `arr[mid] < target` → search the **right half** (`low = mid + 1`).
     * If `arr[mid] > target` → search the **left half** (`high = mid - 1`).
3. If the loop ends without finding → target not in array.

---

## Properties

* **Time Complexity:**

  * Best: $O(1)$ (if middle element is target)
  * Worst & Average: $O(\log n)$
* **Space Complexity:** $O(1)$ (iterative), $O(\log n)$ (recursive, due to stack).
* **Requirement:** Array must be **sorted**.

---
