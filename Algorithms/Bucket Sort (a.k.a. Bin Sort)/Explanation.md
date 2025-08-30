### Bucket Sort

Bucket Sort works well when:

- Input is **uniformly distributed** over a range.
- We can divide the range into **buckets (bins)**, place elements into these buckets, and then sort each bucket individually (often with Insertion Sort or any other simple sort).
- Finally, concatenate the buckets.

It’s not a **comparison sort** → can achieve **O(n)** average time complexity (but worst-case can be **O(n²)** if all elements fall into one bucket).

---

### Algorithm Steps

1. **Find the range** of input values (min and max).
2. **Create buckets** (number of buckets depends on input size or range).
3. **Distribute elements** into respective buckets.
4. **Sort each bucket individually** (commonly using insertion sort because buckets are small).
5. **Concatenate all buckets** in order.

---

# Example Run

**Input**:

`[0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68]`

**Buckets**:

- bucket[1] → [0.17, 0.12]
- bucket[2] → [0.26, 0.21, 0.23]
- bucket[3] → [0.39]
- bucket[6] → [0.68]
- bucket[7] → [0.78, 0.72]
- bucket[9] → [0.94]

**Final Sorted Array**:

`[0.12, 0.17, 0.21, 0.23, 0.26, 0.39, 0.68, 0.72, 0.78, 0.94]`

---

# Time Complexity

- **Best / Average case**: O(n + k) where `k` = number of buckets.
- **Worst case**: O(n²) if all elements go to the same bucket.
- **Space complexity**: O(n + k).

---

**Bucket sort is not limited to floats** — but the **classic textbook version** is usually shown with floats in the range `[0, 1)`, because it’s easier to demonstrate bucket distribution (multiplying by `n` gives a neat bucket index).

---

# Generalization

### For **floats in [0,1)**

- Index = `(value * n)`

### For **integers in a known range [min, max]**

- Index = `(value - min) / bucketSize`
- Here, `bucketSize` is chosen based on range & distribution.

So, **integers and other numeric types** are also supported. You just need a mapping function to decide which bucket an element goes into.

---

# Example Run

**Input**: `[42, 32, 33, 52, 37, 47, 51]`

- min = 32, max = 52
- bucketSize = 5 → buckets = `(52-32)/5 + 1 = 5`

Buckets after distribution:

- Bucket[0]: [32, 33, 37]
- Bucket[1]: [42]
- Bucket[2]: [47]
- Bucket[3]: [51, 52]

Final sorted array → `[32, 33, 37, 42, 47, 51, 52]`

---