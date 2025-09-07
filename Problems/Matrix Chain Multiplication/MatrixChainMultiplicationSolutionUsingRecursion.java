public class MatrixChainMultiplicationSolutionUsingRecursion {

    // Recursive function to find min cost of multiplying matrices i..j
    static int mcm(int[] d, int i, int j) {
        // Base case: one matrix only
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        // Try all possible splits
        for (int k = i; k < j; k++) {
            int cost = mcm(d, i, k) // cost of left subchain
                    + mcm(d, k + 1, j) // cost of right subchain
                    + d[i - 1] * d[k] * d[j]; // cost of multiplying the two results

            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        // Example: Matrices A(3x2), B(2x4), C(4x2), D(2x5)
        int[] d = { 3, 2, 4, 2, 5 }; // dimensions array

        int n = d.length;
        int result = mcm(d, 1, n - 1); // Find min cost from A1 to A(n-1)

        System.out.println("Minimum cost of multiplication: " + result);
    }
}
