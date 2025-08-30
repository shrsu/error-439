## Idea Behind Radix Sort

Radix Sort is a **non-comparative sorting algorithm**.

Instead of comparing numbers directly, it sorts them **digit by digit** (or character by character for strings).

- It starts from the **least significant digit (LSD)** and moves towards the **most significant digit (MSD)**.
- At each digit position, it uses a **stable sorting algorithm** (usually **Counting Sort**) to order the elements.

Example: Sorting `[170, 45, 75, 90, 802, 24, 2, 66]`

1. Sort by 1’s place → `[170, 90, 802, 2, 24, 45, 75, 66]`
2. Sort by 10’s place → `[802, 2, 24, 45, 66, 170, 75, 90]`
3. Sort by 100’s place → `[2, 24, 45, 66, 75, 90, 170, 802]` ✅ (Sorted!)

---

## Key Points

- Works only on **integers** (or strings of uniform length, with some tweaks).
- Time Complexity: **O(d × (n + k))**
  - `d` = number of digits in the max number
  - `n` = number of elements
  - `k` = base of the number system (10 for decimal)
- Space Complexity: **O(n + k)**
