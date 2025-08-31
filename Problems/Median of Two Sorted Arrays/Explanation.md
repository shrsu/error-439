# **Algorithm:**

## **Step 1: Ensure smaller array**

- Always make sure `arr1[]` is the smaller array.
- If not, swap `arr1[]` and `arr2[]`.

---

## **Step 2: Find partition length**

- Calculate:
    
    ```
    left = (n1 + n2 + 1) / 2
    
    ```
    
- This gives the total length of the left partition.

---

## **Step 3: Initialize pointers**

- `low = 0`
- `high = n1` (size of `arr1[]`)

---

## **Step 4: Partitioning inside loop**

- While `low <= high`:
    - Calculate partition indices:
        
        ```
        mid1 = (low + high) // 2
        mid2 = left - mid1
        
        ```
        

---

## **Step 5: Handle edge cases**

- Define:
    
    ```
    l1 = (mid1 > 0) ? arr1[mid1 - 1] : -∞
    l2 = (mid2 > 0) ? arr2[mid2 - 1] : -∞
    r1 = (mid1 < n1) ? arr1[mid1] : +∞
    r2 = (mid2 < n2) ? arr2[mid2] : +∞
    
    ```
    

---

## **Step 6: Check conditions**

- **Case 1: Valid partition**
    - If `(l1 <= r2) && (l2 <= r1)`:
        - If `(n1 + n2)` is **odd** →
            
            ```
            median = max(l1, l2)
            
            ```
            
        - Else (even total length) →
            
            ```
            median = (max(l1, l2) + min(r1, r2)) / 2.0
            
            ```
            
- **Case 2: Too many from arr1[]**
    - If `l1 > r2` → shift left:
        
        ```
        high = mid1 - 1
        
        ```
        
- **Case 3: Too many from arr2[]**
    - If `l2 > r1` → shift right:
        
        ```
        low = mid1 + 1
        
        ```
        

---

## **Step 7: Dummy return**

- Add a fallback return statement outside the loop to handle warnings/errors.

---

This is the **binary search algorithm to find the median of two sorted arrays in O(log(min(n1, n2))) time**.

---