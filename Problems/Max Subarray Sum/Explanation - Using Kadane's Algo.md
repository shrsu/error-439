## 1. Problem Statement

- **Input:** An array `A` of `n` integers (can be positive, negative, or zero).
- **Goal:** Find the maximum sum of a contiguous subarray.

Example:

```
A = [4, -5, 8, -2, -1, 7, -6]
Maximum Subarray Sum = 12 (subarray [8, -2, -1, 7])

```

---

## 2. Core Idea

- At each index `i`, we decide:
    - **Start a new subarray** at `A[i]`
    - **Extend the previous subarray** by adding `A[i]`
- If the previous sum is negative, discard it and restart.
- Otherwise, extend it.

---

## 3. Formula

Let:

- `currentSum` = maximum subarray sum **ending at index i**
- `maxSum` = maximum seen so far

Recurrence:

```
currentSum = max(A[i], currentSum + A[i])
maxSum = max(maxSum, currentSum)
```

---

## 4. Algorithm Steps

1. Initialize:
    - `currentSum = A[0]`
    - `maxSum = A[0]`
2. For each index `i = 1..n-1`:
    - Update `currentSum`
    - Update `maxSum`
3. Return `maxSum`.

---

## Example Run

Array: `[4, -5, 8, -2, -1, 7, -6]`

Steps:

```
currentSum → 4, -1, 8, 6, 5, 12, 6
maxSum     → 4,  4, 8, 8, 8, 12, 12

```

Answer = **12**

---

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1) (just two variables).

---

## Tracking Subarray Indices

To also recover the actual subarray:

- Keep variables `start`, `end`, `tempStart`.
- When `currentSum` resets to `A[i]`, update `tempStart = i`.
- When `maxSum` updates, set `start = tempStart` and `end = i`.

---