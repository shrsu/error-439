import java.util.*;

public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        // Step 1: Create DP array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // use amount+1 as "infinity"
        dp[0] = 0;

        // Step 2: Fill DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Step 3: Return result
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amount = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        CoinChangeSolution sol = new CoinChangeSolution();
        System.out.println(sol.coinChange(coins, amount));
        sc.close();
    }
}