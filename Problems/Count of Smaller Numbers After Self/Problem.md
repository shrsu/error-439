# Problem Statement

You are given an integer array `nums`. For each element `nums[i]`, count the number of smaller elements to its **right side**, and return the result as an array.

### Input:

- An integer array `nums` of size `n`.

### Output:

- An array `result` where `result[i]` is the count of numbers smaller than `nums[i]` that appear to its right.

### Example 1:

```
Input:  nums = [5, 2, 6, 1]
Output: [2, 1, 1, 0]

```

**Explanation:**

- For `5`: smaller numbers to the right = `[2,1]` → count = 2
- For `2`: smaller numbers to the right = `[1]` → count = 1
- For `6`: smaller numbers to the right = `[1]` → count = 1
- For `1`: smaller numbers to the right = `[]` → count = 0