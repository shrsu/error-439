## 1. Recap of Recursion

- The recursive solution explores all `2^n` subsets → very **slow**.
- We noticed **repeated subproblems**:
    - Example: Calls like `(n=1, W=3)` or `(n=1, W=2)` appear **multiple times**.
    - These are called **overlapping subproblems**.
- Therefore, recursion wastes effort recomputing the same results.

---

## 2. Why Memoization?

- Idea: **Save results** of recursive calls in a table.
- Before making a recursive call:
    - Check if the result is already stored.
    - If yes → **reuse it** (skip recalculation).
- This avoids **excessive calls** and improves efficiency.

---

## 3. What is Memoization?

- **Memoization** = “marking/storing values” of solved subproblems.
- In programming:
    - Store results of function calls in a table (cache).
    - Next time the same call is needed, just **return stored value**.
- Knapsack depends on two parameters:
    - `n` (number of items considered so far).
    - `W` (remaining capacity).
- So we need a **2D table** → `dp[n+1][W+1]`.

---

## 4. Steps of Memoization

1. Create a `dp` table of size `[n+1][W+1]`, initialized to `1`.
    
    (Means "not yet computed").
    
2. In recursion:
    - **Base case**: if `n==0` or `W==0` → return 0.
    - **Check memo table**: if `dp[n][W] != -1`, return it.
    - Otherwise:
        - Compute recursively.
        - Store the result in `dp[n][W]`.
        - Return it.
3. Final answer = `dp[n][W]`.

---

## 5. Recursive Relation (with Memoization)

```
if (weight[n] > W):
    dp[n][W] = knapsack(n-1, W)
else:
    dp[n][W] = max(
        knapsack(n-1, W),
        profit[n] + knapsack(n-1, W - weight[n])
    )

```

---

## Example Run (Profits `{6,5,3,8}`, Weights `{1,2,1,2}`, Capacity `5`)

- Without memoization → ~31 calls.
- With memoization → saves ~12 calls (about **⅓ fewer calls**).
- Output:

```
Maximum profit = 19
DP Table:
-1  0  0  0  0  0
-1  6  6  6  6  6
-1  6  6  11 11 11
-1  6  9  11 14 14
-1  6  9  14 17 19

```

---

## Recovering Included Items

- Look at the last cell `dp[n][W]`.
- Compare with the value above:
    - If `dp[n][W] == dp[n-1][W]` → item `n` **not included**.
    - Else → item `n` **included**. Subtract its profit, reduce capacity, and move up.
- Example result:
    - Items included = {1, 2, 4} → profit 19.

---

## Key Observations

- **Recursion → exponential time (O(2^n))**.
- **Memoization → O(n*W)** time, O(n*W) space.
- Memoization = **Top-Down Dynamic Programming**.
- Still uses recursion, but avoids **excessive overlapping calls**.

---