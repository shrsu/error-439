## 1. Problem Recap

- **Input:** An array `A` of size `n` (with positive & negative integers).
- **Goal:** Find the maximum sum of any contiguous subarray.

Example:

```
A = [4, -5, 8, -2, -1, 7, -6]
Maximum subarray sum = 12 (from [8, -2, -1, 7])

```

---

## 2. Brute Force Approaches

1. **O(n³):** Try all subarrays, compute sum each time.
2. **O(n²):** Use prefix sums to speed up computation.
    
    Still inefficient for large `n`.
    

---

## 3. Why Dynamic Programming?

- Notice:
    - The sum of subarray `[i..j]` = sum of `[i..j-1]` + `A[j]`.
    - If the previous sum is **negative**, it reduces the total → better to start fresh from `A[j]`.
- This observation gives the **recurrence relation** for DP.

---

## 4. DP Formulation

Let `S[i]` = maximum subarray sum **ending at index i**.

### Recurrence:

```
S[0] = A[0]
S[i] = max(A[i], S[i-1] + A[i])

```

- If `S[i-1]` is negative → start new subarray at `i`.
- Else → extend the previous subarray.

### Final Answer:

```
maxSubarraySum = max(S[0], S[1], …, S[n-1])

```

---

## 5. Algorithm Steps

1. Initialize:
    - `S[0] = A[0]`
    - `maxSum = A[0]`
2. For each index `i` from `1..n-1`:
    - Compute `S[i] = max(A[i], S[i-1] + A[i])`
    - Update `maxSum = max(maxSum, S[i])`
3. Return `maxSum`.

---

## Example Run

```
A = [4, -5, 8, -2, -1, 7, -6]

DP Array S = [4, -1, 8, 6, 5, 12, 6]
Maximum Subarray Sum = 12

```

---

## Complexity

- **Time Complexity:** O(n) (single pass).
- **Space Complexity:** O(n) (array `S`).

---

## Tracking the Subarray (Indices)

To also get the subarray (start & end indices):

- When `currentSum` resets to `A[i]`, mark new `start = i`.
- Keep track of `end = i` whenever `maxSum` updates.

---