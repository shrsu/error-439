# Reverse Pairs (LeetCode 493)

We need to count the number of **reverse pairs** in an array.

A **reverse pair** is defined as:

$$
(i, j) \quad \text{such that } 0 \leq i < j < n \quad \text{and } nums[i] > 2 \cdot nums[j]
$$

---

## Input

* An integer array `nums` of length `n`.

Constraints:

* $1 \leq n \leq 5 \times 10^4$
* $-2^{31} \leq nums[i] \leq 2^{31} - 1$

---

## Output

* Return a single integer: the total number of reverse pairs.

---

## Example 1

**Input:**

```
nums = [1,3,2,3,1]
```

**Explanation:**

* Pair (1,4): nums\[1] = 3, nums\[4] = 1 → 3 > 2\*1
* Pair (3,4): nums\[3] = 3, nums\[4] = 1 → 3 > 2\*1

**Output:**

```
2
```

---

## Example 2

**Input:**

```
nums = [2,4,3,5,1]
```

**Explanation:**

* Pair (1,4): nums\[1] = 4, nums\[4] = 1 → 4 > 2\*1
* Pair (2,4): nums\[2] = 3, nums\[4] = 1 → 3 > 2\*1
* Pair (3,4): nums\[3] = 5, nums\[4] = 1 → 5 > 2\*1

**Output:**

```
3
```
