# **Problem Statement**

You are given an integer array **`coins`** representing coins of different denominations and an integer **`amount`** representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

**Example 1:**

**Input:**

3 11

1 2 5

**Output:**

3

**Explanation:**

11 = 5 + 5 + 1.

**Example 2:**

**Input:**

1 3

2

**Output:**

- 1

**Explanation:**

We cannot make amount of 3 by any combination of given coins.

**Constraints:**

- **`1 <= coins.length <= 12`**
- **`1 <= coins[i] <= 2^31 - 1`**
- **`0 <= amount <= 10^4`**

---