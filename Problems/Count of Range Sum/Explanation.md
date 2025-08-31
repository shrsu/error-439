# Approach (Prefix Sum + Divide and Conquer)

### 1. Prefix Sum

Instead of recalculating sums for every range, use a prefix sum array:

$$
prefix[k] = nums[0] + nums[1] + ... + nums[k-1]
$$

Then:

$$
S(i, j) = prefix[j+1] - prefix[i]
$$

So, the problem becomes:
Count pairs `(i, j)` with `i < j` such that:

$$
lower \leq prefix[j] - prefix[i] \leq upper
$$

---

### 2. Divide and Conquer (similar to Merge Sort)

We recursively split the prefix array into halves:

- Count valid pairs **entirely in the left half**
- Count valid pairs **entirely in the right half**
- Count valid pairs **spanning both halves**

Then merge the halves (just like merge sort).

---

### 3. Cross Pair Counting

For every prefix in the left half, we want to count how many prefix values in the right half fall within `[prefix[i] + lower, prefix[i] + upper]`.
This is done with two sliding pointers (`l` and `r`) over the sorted right half.

---

# Dry Run Example

Input: `nums = [-2,5,-1], lower = -2, upper = 2`

- Prefix sums = `[0, -2, 3, 2]`
- We want to count pairs `(i, j)` where:
  `lower ≤ prefix[j] - prefix[i] ≤ upper`

Checking manually:

- `prefix[1]-prefix[0] = -2`
- `prefix[2]-prefix[2] = -1`
- `prefix[3]-prefix[0] = 2`

So total = **3**

---

# Complexity

- **Time:** `O(n log n)` (divide and conquer + merge)
- **Space:** `O(n)` (temporary array during merge)

---

This is basically a **merge sort with a counting twist** (similar to “reverse pairs” problem).
