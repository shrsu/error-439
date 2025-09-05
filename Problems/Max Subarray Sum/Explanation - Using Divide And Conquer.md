## 1. Problem Statement

- **Input:** An array `A` of `n` integers (positive, negative, or zero).
- **Goal:** Find the maximum possible sum of a contiguous subarray.

Example:

```
A = [3, -7, 10, 2, 7, -11, -5, 9, 3]
Maximum Subarray Sum = 14  (subarray [10, 2, 7, -5])

```

---

## 2. Divide and Conquer Idea

- **Divide:** Split the array into two halves (left and right).
- **Conquer:** Recursively find the maximum subarray sum in:
    1. Left half
    2. Right half
    3. A subarray that **crosses the midpoint**
- **Combine:** The final answer is the maximum of these three.

---

## 3. Base Case

- If the array has only **one element** (`low == high`), return that element.

---

## 4. Recurrence Relation

Let `T(n)` = time for solving array of size `n`.

```
T(n) = 2T(n/2) + O(n)

```

- Left recursion: `T(n/2)`
- Right recursion: `T(n/2)`
- Combining (finding crossing subarray): `O(n)`

Using **Master Theorem**:

```
T(n) = O(n log n)

```

---

## 5. Algorithm Steps

1. If `low == high` → return `A[low]`.
2. Find `mid = (low + high) / 2`.
3. Recursively compute:
    - `leftMax = maxSub(A, low, mid)`
    - `rightMax = maxSub(A, mid+1, high)`
4. Compute `crossMax = maxCrossSubarray(A, low, mid, high)`
    - Scan leftwards from `mid` → best sum ending at mid.
    - Scan rightwards from `mid+1` → best sum starting at mid+1.
    - Add them together.
5. Return `max(leftMax, rightMax, crossMax)`

---

## Example Run

For `arr = [3, -7, 10, 2, 7, -11, -5, 9, 3]`:

- Left half max = 12 (`[10, 2]`)
- Right half max = 12 (`[9, 3]`)
- Cross max = 14 (`[10, 2, 7, -5]`)
- Answer = **14**

---

## Complexity

- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(log n)` (recursion stack).

---