import java.util.Arrays;

public class KnapsackProblemSolutionUsingMemoization {

    // DP table
    static int[][] dp;

    // Recursive function with memoization
    public static int knapsack(int n, int W, int[] profit, int[] weight) {
        // Base case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If value already computed, return it
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // If item cannot be included
        if (weight[n - 1] > W) {
            dp[n][W] = knapsack(n - 1, W, profit, weight);
        } else {
            int notInclude = knapsack(n - 1, W, profit, weight);
            int include = profit[n - 1] + knapsack(n - 1, W - weight[n - 1], profit, weight);
            dp[n][W] = Math.max(notInclude, include);
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] profit = { 6, 5, 3, 8 };
        int[] weight = { 1, 2, 1, 2 };
        int W = 5;
        int n = profit.length;

        // Initialize dp with -1
        dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxProfit = knapsack(n, W, profit, weight);

        System.out.println("Maximum profit = " + maxProfit);

        // To see the dp table
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
