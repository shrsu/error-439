import java.util.*;

// Item class for value and weight
class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsackProblemSolution {

    // Function to get maximum value in the knapsack
    public static double fractionalKnapsack(int W, Item arr[], int n) {
        // Step 1: Sort items by value-to-weight ratio in descending order
        Arrays.sort(arr, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1); // descending
        });

        double maxValue = 0.0; // Result
        int currentWeight = 0; // Current weight in knapsack

        // Step 2: Pick items one by one
        for (int i = 0; i < n; i++) {
            if (currentWeight + arr[i].weight <= W) {
                // Item can be taken completely
                currentWeight += arr[i].weight;
                maxValue += arr[i].value;
            } else {
                // Take the fraction of the remaining capacity
                int remain = W - currentWeight;
                maxValue += (arr[i].value / (double) arr[i].weight) * remain;
                break; // Knapsack is full
            }
        }
        return maxValue;
    }

    // Driver code to test the function
    public static void main(String[] args) {
        int W = 50; // Knapsack capacity
        Item[] arr = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        int n = arr.length;

        double result = fractionalKnapsack(W, arr, n);
        System.out.printf("%.6f\n", result); // Expected: 240.000000
    }
}
