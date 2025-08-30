# Insertion Sort Algorithm

## Concept

Insertion Sort builds the sorted array one element at a time.
It works like sorting playing cards in your hand:

* Start with the first card (already sorted).
* Pick the next card and insert it into its correct place among the already sorted cards.
* Repeat until all cards are sorted.

---

## Steps of the Algorithm

1. Assume the first element is sorted.
2. Take the next element (called `key`).
3. Compare `key` with elements in the sorted portion (left side).
4. Shift elements one position to the right until you find the correct position for `key`.
5. Insert `key` at that position.
6. Repeat for all elements.

---

## Example Walkthrough

For input:

```
[5, 1, 4, 2, 8]
```

* **Step 1:** Key = 1 → Insert before 5 → \[1, 5, 4, 2, 8]
* **Step 2:** Key = 4 → Insert between 1 and 5 → \[1, 4, 5, 2, 8]
* **Step 3:** Key = 2 → Insert between 1 and 4 → \[1, 2, 4, 5, 8]
* **Step 4:** Key = 8 → Already in place → \[1, 2, 4, 5, 8]

---

## Time Complexity

* **Worst case (reversed array):** O(n²)
* **Best case (already sorted):** O(n) (just comparisons, no shifts)
* **Space Complexity:** O(1) → in-place sorting

---

Only Bubble sort and Insertion sort are adaptive. These two, along with merge sort are stable.
