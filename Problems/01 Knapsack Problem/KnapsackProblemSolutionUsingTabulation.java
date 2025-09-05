import java.util.ArrayList;
import java.util.List;

public class KnapsackProblemSolutionUsingTabulation {

    public static int knapsack(int[] profit, int[] weight, int W, List<Integer> chosenItems) {
        int n = profit.length;
        int[][] dp = new int[n + 1][W + 1];

        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            profit[i - 1] + dp[i - 1][w - weight[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Recover included items
        int res = dp[n][W];
        int w = W;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                // Item i-1 is included
                chosenItems.add(i - 1);
                res -= profit[i - 1];
                w -= weight[i - 1];
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] profit = { 6, 5, 3, 8 };
        int[] weight = { 1, 2, 1, 2 };
        int W = 5;

        List<Integer> chosenItems = new ArrayList<>();
        int maxProfit = knapsack(profit, weight, W, chosenItems);

        System.out.println("Maximum profit = " + maxProfit);
        System.out.print("Items included (0-indexed): ");
        for (int idx : chosenItems) {
            System.out.print("Item" + (idx + 1) + " ");
        }
    }
}
