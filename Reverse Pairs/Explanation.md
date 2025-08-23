# Problem Restatement

We are asked to count the number of **reverse pairs** in an array:

A reverse pair is a pair of indices $(i, j)$ such that:

* $0 \leq i < j < n$, and
* $nums[i] > 2 \times nums[j]$.

---

# Naive Approach (Brute Force)

We could try:

```java
int count = 0;
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (nums[i] > 2L * nums[j]) count++;
    }
}
```

* **Time complexity:** $O(n^2)$.
* Works for small arrays, but too slow for $n$ up to $10^5$.

So, we need something faster.

---

# Key Intuition

This is **similar to "count inversions"** — but instead of checking $nums[i] > nums[j]$, we check $nums[i] > 2 \times nums[j]$.
The trick is to use **merge sort**:

1. During merge sort, each recursive call splits the array into two sorted halves.
2. Since the halves are **individually sorted**, we can efficiently count cross-pairs (where $i$ is in the left half and $j$ in the right half).
3. After counting, we merge the halves back (just like normal merge sort).

---

# Step-by-Step Algorithm

### 1. Recursive Split

We keep dividing the array into halves until we reach single elements.

### 2. Count Reverse Pairs in Left and Right

We recursively count reverse pairs in:

* Left half (`mergeSort(nums, left, mid)`)
* Right half (`mergeSort(nums, mid+1, right)`)

### 3. Count Cross Reverse Pairs

Now, we need pairs where:

* $i$ is in `[left, mid]`
* $j$ is in `[mid+1, right]`
* $nums[i] > 2 \times nums[j]$

Since both halves are sorted:

* For each `i` in the left half, we move `j` forward in the right half until the condition fails.
* The number of valid `j`s for that `i` is `(j - (mid + 1))`.

This makes counting efficient:
Instead of $O(n^2)$, the counting step is **linear** relative to the merge size.

### 4. Merge

Finally, we merge the two sorted halves into one sorted array (like normal merge sort).

---

# Example Walkthrough

Suppose:

```
nums = [1, 3, 2, 3, 1]
```

### Step 1: Split

Left = `[1, 3, 2]`, Right = `[3, 1]`

### Step 2: Process `[1,3,2]`

* Split into `[1,3]` and `[2]`
* Count inside `[1,3]`: 0
* Count inside `[2]`: 0
* Cross pairs between `[1,3]` and `[2]` → only check `(3,2)` but `3 > 2*2`? No → 0
* Merge gives `[1,2,3]`

### Step 3: Process `[3,1]`

* Split into `[3]` and `[1]`
* Cross pairs: `(3,1)` → `3 > 2*1` → Yes → 1
* Merge gives `[1,3]`

### Step 4: Combine `[1,2,3]` and `[1,3]`

* For `i=1`: no pairs
* For `i=2`: no pairs
* For `i=3`: compare with right-half

  * `(3,1)` → valid
  * `(3,3)` → not valid
* So we add 1
* Merge gives `[1,1,2,3,3]`

### Total Count = 2

---

# Complexity Analysis

* Each level of recursion: **O(n)** work (counting + merging).
* Recursion depth: **O(log n)**.
* **Time complexity:** $O(n \log n)$
* **Space complexity:** $O(n)$ (temporary array during merge).

---

# Intuition Summary

* Normal merge sort counts inversions (`nums[i] > nums[j]`).
* Here we tweak it to check `nums[i] > 2 * nums[j]`.
* Because both halves are sorted, we can count efficiently by **sliding pointer j forward without resetting** for each i.
* This transforms a quadratic problem into an $O(n \log n)$ one.