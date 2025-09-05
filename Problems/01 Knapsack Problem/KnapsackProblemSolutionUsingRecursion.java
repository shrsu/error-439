import java.util.ArrayList;
import java.util.List;

public class KnapsackProblemSolutionUsingRecursion {

    // Recursive function that also tracks items
    public static int knapsack(int n, int W, int[] profit, int[] weight, List<Integer> chosenItems) {
        // Base case
        if (n == 0 || W == 0) {
            return 0;
        }

        // If nth item can't be included
        if (weight[n - 1] > W) {
            return knapsack(n - 1, W, profit, weight, chosenItems);
        }

        // Case 1: exclude nth item
        List<Integer> excludeList = new ArrayList<>();
        int exclude = knapsack(n - 1, W, profit, weight, excludeList);

        // Case 2: include nth item
        List<Integer> includeList = new ArrayList<>();
        int include = profit[n - 1] + knapsack(n - 1, W - weight[n - 1], profit, weight, includeList);

        // Pick better option
        if (include > exclude) {
            includeList.add(n - 1); // add current item index
            chosenItems.addAll(includeList);
            return include;
        } else {
            chosenItems.addAll(excludeList);
            return exclude;
        }
    }

    public static void main(String[] args) {
        int[] profit = { 6, 5, 3, 8 };
        int[] weight = { 1, 2, 1, 2 };
        int W = 5;
        int n = profit.length;

        List<Integer> chosenItems = new ArrayList<>();
        int maxProfit = knapsack(n, W, profit, weight, chosenItems);

        System.out.println("Maximum profit = " + maxProfit);
        System.out.print("Items included (0-indexed): ");
        for (int idx : chosenItems) {
            System.out.print("Item" + (idx + 1) + " ");
        }
    }
}
