
# Bubble Sort Algorithm

## Concept

Bubble Sort is one of the simplest **sorting algorithms**.
It works by **repeatedly swapping adjacent elements** if they are in the wrong order.
After each pass:

* The largest element "bubbles up" to the end of the array.
* The process repeats until no swaps are needed.

---

## Steps of the Algorithm

1. Start with the first element of the array.
2. Compare it with the next element:

   * If the current element is greater, **swap** them.
   * Otherwise, do nothing.
3. Move to the next pair and repeat until the end of the array.
4. After the first pass, the **largest element is at the end**.
5. Repeat the process for the remaining elements (excluding the last sorted ones).
6. Stop when no swaps are made in a pass → the array is sorted.

Only Bubble sort and Insertion sort are adaptive. These two, along with merge sort are stable.
