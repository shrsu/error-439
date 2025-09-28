Given weights and values of **`n`** items, we need to put these items in a knapsack of capacity **`w`** to get the **maximum** total value in the knapsack.

**Note:** Unlike 0/1 knapsack, you are **allowed** to break the item here.

**Your Task :**

Complete the function **`fractionalKnapsack()`** that receives maximum capacity **`w`**, an array of structure/class, and size **`n`** and returns a double value representing the maximum value in knapsack.

**Note:** The details of structure/class is defined in the comments above the given function.

**Example 1:**

```
Input:
3 50
60 10
100 20
120 30

Output:
240.000000

```

**Explanation:**

Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0

Thus, total maximum value of item we can have is 240.00 from the given capacity of sack.

**Example 2:**

```
Input:
2 50
60 10
100 20

Output:
160.000000

```

**Explanation:**

Take both the items completely, without breaking. Total maximum value of item we can have is 160.00 from the given capacity of sack.

**Constraints:**

- **`1 <= n <= 10^5`**
- **`1 ≤ w ≤ 10^9`**