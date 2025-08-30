# Counting Sort

### What is Counting Sort?

Counting Sort is a **non-comparison-based sorting algorithm**.
It works by:

1. Finding the **range of input values** (min and max).
2. Counting the frequency of each element.
3. Computing prefix sums to determine **positions**.
4. Placing elements into their **sorted position**.

It is efficient when:

* The range of numbers (`max - min`) is not much larger than the number of elements.
* Input elements are integers (or can be mapped to integers).

---

### Explanation of Steps

#### Input:

```
arr = [4, 2, 2, 8, 3, 3, 1]
```

#### Step 1 → Find min and max

```
min = 1, max = 8
range = 8 - 1 + 1 = 8
```

#### Step 2 → Create count array

```
count[] size = 8
Initial count = [0,0,0,0,0,0,0,0]
```

#### Step 3 → Store frequencies

```
arr = [4,2,2,8,3,3,1]
count = [1,2,2,1,0,0,0,1]
(index 0 -> number 1, index 1 -> number 2, etc.)
```

#### Step 4 → Rebuild sorted array

```
[1,2,2,3,3,4,8]
```

---

### Time & Space Complexity

* **Time Complexity:**

  * O(n + k), where
    n = number of elements,
    k = range of numbers (`max - min`)
* **Space Complexity:** O(k) for count array
