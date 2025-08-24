# QuickSort

QuickSort is a **divide and conquer** algorithm:

1. **Partition** the array around a pivot (so all elements ≤ pivot go left, > pivot go right).
2. **Recurse** on the left and right parts.
3. **Base case**: subarray size ≤ 1 (already sorted).

---

# 🔹 Code Explanation

### `quickSort(int[] arr, int low, int high)`

```java
if (low < high) {
    int pivotIndex = partition(arr, low, high);   // Step 1: partition
    quickSort(arr, low, pivotIndex - 1);          // Step 2: sort left half
    quickSort(arr, pivotIndex + 1, high);         // Step 3: sort right half
}
```

* Recursive function.
* Keeps dividing the array into **smaller subarrays** around pivots.

---

### `partition(int[] arr, int low, int high)`

```java
int mid = low + (high - low) / 2;
int pivotIndex = medianOfThree(arr, low, mid, high);
int pivot = arr[pivotIndex];
```

* Picks **three candidates** for pivot:

  * `arr[low]` (first),
  * `arr[mid]` (middle),
  * `arr[high]` (last).
* Uses `medianOfThree()` to choose the **median value** (best balance).

```java
swap(arr, pivotIndex, high);  // move pivot to the end
```

* Temporarily moves pivot to the **last position** (common trick for Lomuto partitioning).

```java
int i = low - 1;
for (int j = low; j < high; j++) {
    if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
    }
}
```

* Standard **Lomuto partition scheme**:

  * `i` tracks the **boundary of smaller elements**.
  * Scan with `j` from `low` to `high-1`.
  * Whenever we see something `<= pivot`, move it into the “small” section by swapping.

```java
swap(arr, i + 1, high);   // put pivot in its final place
return i + 1;
```

* After loop, pivot is put between small and large values.
* Returns pivot’s **final index**, so recursion can sort left and right parts separately.

---

### `medianOfThree(int[] arr, int a, int b, int c)`

```java
if ((arr[a] > arr[b]) != (arr[a] > arr[c]))
    return a;
else if ((arr[b] > arr[a]) != (arr[b] > arr[c]))
    return b;
else
    return c;
```

* This logic says:

  * If `arr[a]` lies **between** `arr[b]` and `arr[c]`, return `a`.
  * Else if `arr[b]` lies between, return `b`.
  * Else `arr[c]` must be the median.

Effectively finds the **middle value** among the three numbers.

---


# Why Median-of-Three?

* If pivot is chosen poorly (like always picking last element), sorted arrays give **worst-case O(n²)**.
* Median-of-three picks a more “central” pivot → partitions are more balanced → QuickSort is much closer to **O(n log n)** in practice.

---
