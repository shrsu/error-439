## Steps and Explanations

### Step 1: Understand the Problem

- You are given `n` items, each with a **value** and a **weight**.
- You need to maximize the **total value** you can carry in a knapsack of capacity `w`.
- Unlike 0/1 Knapsack, here you can take **fractions** of items.

### Step 2: Key Idea (Greedy Choice)

- Compute the **value-to-weight ratio** (`value/weight`) for each item.
- Sort all items in **descending order of ratio**.
- Pick items one by one:
    - If the whole item fits, take it completely.
    - If it doesn’t fit, take only the fraction that fits.
- Stop when the knapsack is full.

### Step 3: Time Complexity Analysis

- Sorting items: `O(n log n)`
- Iterating through items: `O(n)`
- Overall: `O(n log n)` (efficient for large `n`).

---