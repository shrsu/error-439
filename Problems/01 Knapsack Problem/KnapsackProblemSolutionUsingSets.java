import java.util.*;

public class KnapsackProblemSolutionUsingSets {

    static class State {
        int profit;
        int weight;
        List<Integer> items; // store which items are included

        State(int profit, int weight, List<Integer> items) {
            this.profit = profit;
            this.weight = weight;
            this.items = new ArrayList<>(items);
        }
    }

    public static State knapsack(int[] profits, int[] weights, int capacity) {
        // Set of states
        List<State> states = new ArrayList<>();
        states.add(new State(0, 0, new ArrayList<>())); // Start with empty knapsack

        // Process each item
        for (int i = 0; i < profits.length; i++) {
            List<State> newStates = new ArrayList<>();

            for (State state : states) {
                int newProfit = state.profit + profits[i];
                int newWeight = state.weight + weights[i];

                if (newWeight <= capacity) {
                    List<Integer> newItems = new ArrayList<>(state.items);
                    newItems.add(i + 1); // store item index (1-based)
                    newStates.add(new State(newProfit, newWeight, newItems));
                }
            }

            // Merge old states + new states
            states.addAll(newStates);

            // Apply dominance rule → prune bad states
            states = prune(states);
        }

        // Find state with maximum profit
        State best = states.get(0);
        for (State state : states) {
            if (state.profit > best.profit) {
                best = state;
            }
        }
        return best;
    }

    // Removes dominated states
    private static List<State> prune(List<State> states) {
        // Sort by weight, then by profit
        states.sort((a, b) -> a.weight != b.weight ? a.weight - b.weight : b.profit - a.profit);

        List<State> pruned = new ArrayList<>();
        int maxProfitSoFar = -1;

        for (State state : states) {
            if (state.profit > maxProfitSoFar) {
                pruned.add(state);
                maxProfitSoFar = state.profit;
            }
        }
        return pruned;
    }

    // Example usage
    public static void main(String[] args) {
        int[] profits = { 1, 2, 5, 6 };
        int[] weights = { 2, 3, 4, 5 };
        int capacity = 8;

        State best = knapsack(profits, weights, capacity);

        System.out.println("Maximum Profit = " + best.profit);
        System.out.println("Items chosen (1-based indices): " + best.items);
    }
    
}
