## 1. Problem Reminder

- We are given:
    - `n` items, each with a **profit (value)** and **weight**.
    - A knapsack with **capacity W**.
- Goal:
    
    Maximize total profit without exceeding the knapsack’s capacity.
    

This is an **optimization problem**.

---

## 2. Why Recursion?

- Knapsack can be solved with **Dynamic Programming (DP)**.
- But DP always **starts from recursion**:
    - First: think recursively.
    - Then: observe **overlapping subproblems** → introduce **memoization** (Top-Down DP).
    - Finally: convert to **tabulation** (Bottom-Up DP).

This **pattern** is followed for many DP problems.

---

## 3. Recursive Intuition

Each object has **two choices**:

1. **Not include** the object.
    
    → Capacity remains the same.
    
2. **Include** the object (only if its weight ≤ remaining capacity).
    
    → Capacity decreases.
    
    → Profit of that object is added.
    

So recursion tries **all possibilities**:

For `n` objects, that’s `2^n` subsets.

---

## 4. Base Cases

The recursion should stop when:

1. No objects left (`n == 0`).
    
    → Profit = `0`.
    
2. No remaining capacity (`W == 0`).
    
    → Profit = `0`.
    

---

## 5. Recursive Relation

Let:

- `knapsack(n, W)` = maximum profit using first `n` items with capacity `W`.

Then:

```
if (weight[n] > W):
    return knapsack(n-1, W)       // cannot include item n
else:
    return max(
        knapsack(n-1, W),         // not included
        profit[n] + knapsack(n-1, W - weight[n])   // included
    )

```

---

## 6. Recursive Algorithm (Pseudocode)

```java
int knapsack(int n, int W, int[] profit, int[] weight) {
    // Base case
    if (n == 0 || W == 0) return 0;

    // If item cannot be included
    if (weight[n-1] > W) {
        return knapsack(n-1, W, profit, weight);
    }

    // Two possibilities: include or not include
    int notInclude = knapsack(n-1, W, profit, weight);
    int include = profit[n-1] + knapsack(n-1, W - weight[n-1], profit, weight);

    return Math.max(notInclude, include);
}

```

---

## 7. Example Walkthrough

Given:

- Profits = `[6, 5, 3, 8]`
- Weights = `[1, 2, 1, 2]`
- Capacity = `5`

Steps:

1. Start with 4th item (`profit=8`, `weight=2`).
    - Case 1: Exclude → call `knapsack(3, 5)`.
    - Case 2: Include → profit `8 + knapsack(3, 3)`.
2. Each call branches again (include/exclude).
    
    Eventually, recursion explores all **16 possible combinations (2⁴)**.
    
3. Final Answer = **19**, obtained by including:
    - Item 1 (`profit=6, weight=1`)
    - Item 2 (`profit=5, weight=2`)
    - Item 4 (`profit=8, weight=2`)

---

## 8. Key Observations

- Recursion tries all `2^n` possibilities → exponential time.
- Many **subproblems repeat** (e.g., `(n=3, W=3)` appears multiple times).
- This motivates the next step: **Memoization (Top-Down DP)** to avoid recomputation.

---