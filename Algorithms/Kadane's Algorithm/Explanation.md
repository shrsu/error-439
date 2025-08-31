# Problem Statement

Given an integer array `nums`, find the **maximum subarray sum** (the largest possible sum of a contiguous subarray).

### Input:

* An integer array `nums` of size `n`.

### Output:

* A single integer → the maximum possible subarray sum.

---

# Kadane’s Algorithm – Step by Step

Kadane’s Algorithm is a **Dynamic Programming** based approach with **O(n)** time.

1. **Initialize:**

   * `maxSoFar = nums[0]` → stores the global maximum subarray sum.
   * `currentSum = nums[0]` → stores the sum of the current subarray.

2. **Iterate through the array (from index 1 to n-1):**

   * At each step, decide:

     * Extend the current subarray by adding `nums[i]`, OR
     * Start a new subarray at `nums[i]`.
   * `currentSum = Math.max(nums[i], currentSum + nums[i])`

3. **Update global maximum:**

   * `maxSoFar = Math.max(maxSoFar, currentSum)`

4. **Final Answer:**

   * After processing all elements, `maxSoFar` is the maximum subarray sum.

---

# Dry Run Example

Input: `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`

* Start:
  `maxSoFar = -2`, `currentSum = -2`

* i = 1 → num = 1
  `currentSum = max(1, -2+1) = 1`
  `maxSoFar = max(-2, 1) = 1`

* i = 2 → num = -3
  `currentSum = max(-3, 1+(-3)) = -2`
  `maxSoFar = max(1, -2) = 1`

* i = 3 → num = 4
  `currentSum = max(4, -2+4) = 4`
  `maxSoFar = max(1, 4) = 4`

* i = 4 → num = -1
  `currentSum = max(-1, 4+(-1)) = 3`
  `maxSoFar = max(4, 3) = 4`

* i = 5 → num = 2
  `currentSum = max(2, 3+2) = 5`
  `maxSoFar = max(4, 5) = 5`

* i = 6 → num = 1
  `currentSum = max(1, 5+1) = 6`
  `maxSoFar = max(5, 6) = 6`

* i = 7 → num = -5
  `currentSum = max(-5, 6+(-5)) = 1`
  `maxSoFar = max(6, 1) = 6`

* i = 8 → num = 4
  `currentSum = max(4, 1+4) = 5`
  `maxSoFar = max(6, 5) = 6`

Final Answer: `6` (subarray `[4, -1, 2, 1]`)

---

# Complexity

* **Time:** `O(n)` (single pass)
* **Space:** `O(1)` (constant extra space)
