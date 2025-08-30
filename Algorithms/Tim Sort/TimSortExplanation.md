- **TimSort** is a **hybrid stable sorting algorithm**.
- It combines the strengths of:
    - **Insertion Sort** (good for small arrays / partially sorted arrays), and
    - **Merge Sort** (good for large datasets).
- It was invented by **Tim Peters in 2002** for Python, and later adopted in Java and other languages.

It’s the **default sorting algorithm** in:

- **Python** (`list.sort()` and `sorted()`)
- **Java** (`Arrays.sort()` for objects, since Java 7)

---

# How TimSort Works (Steps)

1. **Divide the array into small chunks** called **runs**.
    - A run is either strictly increasing or strictly decreasing.
    - Decreasing runs are reversed to become increasing.
2. **Sort each run using Insertion Sort.**
    - Since runs are small (commonly size 32–64), Insertion Sort is efficient here.
3. **Merge runs using Merge Sort.**
    - Adjacent runs are merged in a way similar to Merge Sort.
    - This gives overall efficiency while keeping the algorithm **stable**.

---

# Complexity of TimSort

- **Best case:** `O(n)` (if data is already sorted or nearly sorted).
- **Average case:** `O(n log n)`.
- **Worst case:** `O(n log n)`.

It’s **adaptive** → meaning it takes advantage of **existing order** in the input array.

---

# Why is TimSort Used?

**Stable** – preserves order of duplicates.

**Adaptive** – faster for real-world partially sorted data.

**Efficient** – combines the best of Insertion and Merge Sort.

**Widely used** – standard in Java, Python, Android, etc.

---

# Example Use Case

Suppose you have employee records:

```
[ (Alice, 25), (Bob, 30), (Charlie, 25) ]

```

Sorting by **age** using TimSort → preserves the order of Alice before Charlie (both age 25).

---