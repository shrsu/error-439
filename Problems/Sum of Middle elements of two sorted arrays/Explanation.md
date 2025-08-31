### **Algorithm (Binary Search on Partitions)**

### **Step 1: Binary search setup**

- We perform **binary search only on array A[]** (since arrays are equal in size, we can partition them).
- Variables:
    - `cut1`: partition index in A[]
    - `cut2 = n - cut1`: partition index in B[]

### **Step 2: Get boundary values**

- Four key variables:
    - `l1` = last element of left part from A[]
    - `l2` = last element of left part from B[]
    - `r1` = first element of right part from A[]
    - `r2` = first element of right part from B[]
- Use `Integer.MIN_VALUE` and `Integer.MAX_VALUE` to handle edges (like if partition is at 0 or n).

### **Step 3: Check valid partition**

- A partition is valid if:
    
    ```
    l1 <= r2 && l2 <= r1
    ```
    
- Meaning:
    
    → Left side’s maximum ≤ Right side’s minimum.
    

### **Step 4: Result calculation**

- Once a valid partition is found:
    
    ```
    result = max(l1, l2) + min(r1, r2)
    
    ```
    
- This gives the **two middle elements** in the combined sorted array.

### **Step 5: Adjust partitions**

- If partition is invalid:
    - If `l1 > r2`: move left → `high = cut1 - 1`
    - If `l2 > r1`: move right → `low = cut1 + 1`

---

## Complexity

- **Time Complexity**: `O(log n)` (binary search)
- **Space Complexity**: `O(1)` (no extra space used)

---