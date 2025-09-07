public class MatrixChainMultiplicationSolutionUsingMemoization {

    static int[][] M; // DP table for min cost
    static int[][] K; // DP table for parenthesization
    static int[] d; // dimensions array

    // Recursive function with memoization
    static int mcm(int i, int j) {
        // Base case: single matrix
        if (i == j) {
            return M[i][j] = 0;
        }

        // If already computed
        if (M[i][j] != -1) {
            return M[i][j];
        }

        int minCost = Integer.MAX_VALUE;
        int bestK = -1;

        // Try all possible splits
        for (int k = i; k < j; k++) {
            int cost = mcm(i, k) + mcm(k + 1, j) + d[i - 1] * d[k] * d[j];

            if (cost < minCost) {
                minCost = cost;
                bestK = k; // store the k giving min cost
            }
        }

        // Store results in tables
        M[i][j] = minCost;
        K[i][j] = bestK;

        return minCost;
    }

    // Function to print optimal parenthesization
    static String getOptimalParenthesis(int i, int j, char name) {
        if (i == j) {
            return Character.toString(name); // single matrix
        }
        int k = K[i][j];
        String left = getOptimalParenthesis(i, k, name);
        String right = getOptimalParenthesis(k + 1, j, (char) (name + (k - i + 1)));
        return "(" + left + right + ")";
    }

    public static void main(String[] args) {
        // Example: A(3x2), B(2x4), C(4x2), D(2x5)
        d = new int[] { 3, 2, 4, 2, 5 };
        int n = d.length - 1; // number of matrices

        M = new int[n + 1][n + 1];
        K = new int[n + 1][n + 1];

        // Initialize with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                M[i][j] = -1;
                K[i][j] = -1;
            }
        }

        int result = mcm(1, n);

        System.out.println("Minimum cost of multiplication: " + result);
        System.out.println("Optimal Parenthesization: " + getOptimalParenthesis(1, n, 'A'));
    }
}
