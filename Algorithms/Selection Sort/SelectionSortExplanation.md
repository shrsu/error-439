# Selection Sort Algorithm

## Concept

Selection Sort repeatedly **selects the smallest (or largest) element** from the unsorted portion of the array and swaps it with the first unsorted element.
After each pass, one more element is placed in its correct position.

Think of it as:

* Finding the "minimum element" and placing it at the front.
* Shrinking the unsorted part step by step.

---

## Steps of the Algorithm

1. Start from the beginning of the array.
2. Find the **minimum element** in the unsorted part.
3. Swap it with the first unsorted element.
4. Move the boundary of the sorted part one step forward.
5. Repeat until the array is sorted.

---

## Example Walkthrough

For input:

```
[5, 1, 4, 2, 8]
```

* **Pass 1:** Find min = 1 → swap with 5 → \[1, 5, 4, 2, 8]
* **Pass 2:** Find min = 2 → swap with 5 → \[1, 2, 4, 5, 8]
* **Pass 3:** Find min = 4 → already in place → \[1, 2, 4, 5, 8]
* **Pass 4:** Find min = 5 → already in place → \[1, 2, 4, 5, 8]

---

## Time Complexity

* **Worst case:** O(n²)
* **Best case:** O(n²) (still scans entire array for min each pass)
* **Space Complexity:** O(1) (in-place sorting)

---

## Comparison with Bubble & Insertion Sort

| Algorithm      | Best Case | Worst Case | Swaps | Notes                                   |
| -------------- | --------- | ---------- | ----- | --------------------------------------- |
| Bubble Sort    | O(n)      | O(n²)      | Many  | Good for nearly sorted arrays           |
| Insertion Sort | O(n)      | O(n²)      | Few   | Best for small/narrowly unsorted arrays |
| Selection Sort | O(n²)     | O(n²)      | Few   | Always scans full array; fewer swaps    |

---

Selection Sort is **not efficient for large arrays** but useful when **swap operations are expensive** (since it does at most *n swaps*).
