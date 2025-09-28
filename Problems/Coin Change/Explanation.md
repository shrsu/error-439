## Steps / Approach

1. **Dynamic Programming Idea**
    - Let `dp[i]` = minimum number of coins required to make amount `i`.
    - Initialize `dp[0] = 0` (0 coins needed for amount 0).
    - For all other values, initialize `dp[i] = ∞` (large value, meaning "not possible yet").
2. **Transition Relation**
    - For each amount `i` from `1` to `amount`:
        - For each coin `c` in `coins`:
            - If `i - c >= 0` → we can use this coin.
            - Update:
                
                ```
                dp[i] = min(dp[i], dp[i - c] + 1)
                
                ```
                
    - This ensures we always pick the minimum number of coins.
3. **Final Answer**
    - After filling the DP table, if `dp[amount]` is still ∞, return `1`.
    - Otherwise, return `dp[amount]`.

---