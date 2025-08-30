# Problem Restatement

* You are given an array of size `N`.
* For each **contiguous subarray of size K**, you need to return the **maximum element**.
* Example:

  ```
  arr = [1, 2, 3, 1, 4, 5, 2, 3, 6], K = 3
  output = [3, 3, 4, 5, 5, 5, 6]
  ```

---

# Technique Used

* **Sliding Window + Deque (Double Ended Queue)**
* Idea:

  * Use a **deque** to keep track of **indices** of useful elements in the current window.
  * Maintain the deque in such a way that:

    * **Front** of deque always has the index of the maximum element for the current window.
    * Elements smaller than the current element are **removed from the back**, since they are useless (a bigger number will dominate them).
    * Remove indices from the **front** if they go out of the current window.

This ensures that deque always contains only candidates for the maximum, and the maximum can be read in **O(1)** time from the front.

---

# Time Complexity

* Each element is **added once** and **removed once** from the deque.
* So total operations = `O(N)`.

**Time Complexity = O(N)**
**Space Complexity = O(K)** (for the deque + result storage).

---

# Process (Step by Step)

### **1. Initialization**

* Create an empty deque `dq` (stores indices, not values).
* Create `ans` list for results.

---

### **2. Iterate Over Array**

For each index `i` from `0` to `n-1`:

#### Step A. Remove out-of-window indices

```java
while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
```

* If the index at the front of deque is outside the window `[i-k+1 … i]`, remove it.

---

#### Step B. Remove smaller elements from back

```java
while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
```

* If the current element is **greater** than elements at the back, remove them (they can never be max in future windows).

---

#### Step C. Add current element index

```java
dq.offerLast(i);
```

---

#### Step D. Add result to `ans`

```java
if (i >= k - 1) ans.add(arr[dq.peekFirst()]);
```

* Once the first `k` elements are processed, the front of deque gives the max of the current window.

---

# Example Walkthrough

### Input:

```
N = 9, K = 3
arr = [1, 2, 3, 1, 4, 5, 2, 3, 6]
```

### Execution:

1. i = 0 → add `1` → dq = \[0]
2. i = 1 → remove 1 (smaller than 2) → dq = \[1]
3. i = 2 → remove 2 (smaller than 3) → dq = \[2] → window max = 3
4. i = 3 → dq = \[2, 3] → window max = 3
5. i = 4 → remove 1 (arr\[3]), remove 3 (arr\[2]), dq = \[4] → max = 4
6. i = 5 → remove 4, dq = \[5] → max = 5
7. i = 6 → dq = \[5, 6] → max = 5
8. i = 7 → dq = \[5, 7] → max = 5
9. i = 8 → remove 7, remove 5, dq = \[8] → max = 6

### Output:

```
[3, 3, 4, 5, 5, 5, 6]
```

---

# Summary of TTP

* **Technique:** Sliding Window + Deque (monotonic queue).
* **Time Complexity:** O(N).
* **Space Complexity:** O(K).
* **Process:** Maintain a deque of useful indices →

  * Pop from front if out of window.
  * Pop from back if smaller than current element.
  * Front always gives max for the current window.

---
