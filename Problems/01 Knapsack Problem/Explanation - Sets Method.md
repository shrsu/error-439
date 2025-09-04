# Intuition Behind the Sets Method

1. **Problem Reminder**
    
    We are given `n` items, each with a profit and weight, and a knapsack with max capacity `W`.
    
    We must choose items to maximize profit without exceeding capacity.
    
2. **Naive Approach**
    - Try all subsets of items (there are `2^n` of them).
    - Compute weight and profit of each subset.
    - Pick the best valid one.
        
        But this is **too expensive** for large `n`.
        
3. **Sets Method Idea**
    - Instead of brute force, **we iteratively build sets of possible (profit, weight) pairs**.
    - Start with `{(0,0)}` (no items chosen).
    - For each item `(p, w)`, generate new states by **including the item** into existing states.
    - Merge them, discarding:
        - Infeasible pairs (`weight > W`).
        - Dominated pairs (if another pair has ≤ weight and ≥ profit).
    
    This way, we still explore subsets but avoid keeping useless states.
    

---

# Step-by-Step Explanation

### 1. Representing States

Each state is represented as:

```
(profit, weight, items)

```

- `(0,0,{})` = nothing included.
- New states are formed by including the next item.
- Example: if you have `(2,3,{2})` and add item3 `(profit=5, weight=4)`, new state is `(7,7,{2,3})`.

---

### 2. Iterating Items

For each item `(profit[i], weight[i])`:

- Generate new states by adding the item to all existing states.
- Carry forward the **list of chosen items**.

---

### 3. Merging and Pruning

- Merge new states with old states.
- Apply **dominance rule**:
    - If `(profit1 ≥ profit2 && weight1 ≤ weight2)` → then `(profit2, weight2)` is useless.
    - Keep only the **best states**.

This avoids exponential growth.

---

### 4. Result Extraction

- After all items are processed, the state with the **maximum profit** is the final answer.
- That state’s `items` list tells **which objects were chosen**.

---

# Example Walkthrough

Given:

- Profits = `[1, 2, 5, 6]`
- Weights = `[2, 3, 4, 5]`
- Capacity = `8`

Steps:

1. **Start**

```
{ (0,0,{}) }

```

1. **Add item1 (profit=1, weight=2)**

```
{ (0,0,{}), (1,2,{1}) }

```

1. **Add item2 (profit=2, weight=3)**

```
{ (0,0,{}), (1,2,{1}), (2,3,{2}), (3,5,{1,2}) }

```

1. **Add item3 (profit=5, weight=4)**

```
{ (0,0,{}), (1,2,{1}), (2,3,{2}), (3,5,{1,2}),
  (5,4,{3}), (6,6,{1,3}), (7,7,{2,3}) }

```

1. **Add item4 (profit=6, weight=5)**

```
{ (0,0,{}), (1,2,{1}), (2,3,{2}), (3,5,{1,2}),
  (5,4,{3}), (6,6,{1,3}), (7,7,{2,3}), (8,8,{2,4}) }

```

---