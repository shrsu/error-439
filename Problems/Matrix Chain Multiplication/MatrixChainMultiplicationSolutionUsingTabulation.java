public class MatrixChainMultiplicationSolutionUsingTabulation {

    public static void matrixChainOrder(int[] d, int n) {
        int[][] M = new int[n + 1][n + 1]; // cost table
        int[][] K = new int[n + 1][n + 1]; // split table

        // Step 1: Base case (single matrix = 0 cost)
        for (int i = 1; i <= n; i++) {
            M[i][i] = 0;
        }

        // Step 2: Fill table diagonal by diagonal
        for (int diff = 1; diff < n; diff++) { // chain length difference
            for (int i = 1; i <= n - diff; i++) {
                int j = i + diff;
                M[i][j] = Integer.MAX_VALUE;

                // Try all possible splits
                for (int k = i; k < j; k++) {
                    int cost = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if (cost < M[i][j]) {
                        M[i][j] = cost;
                        K[i][j] = k; // store split point
                    }
                }
            }
        }

        // Final result
        System.out.println("Minimum cost of multiplication: " + M[1][n]);
        System.out.print("Optimal Parenthesization: ");
        printOptimalParenthesis(K, 1, n, 'A');
        System.out.println();
    }

    // Helper function to print parenthesization
    private static void printOptimalParenthesis(int[][] K, int i, int j, char name) {
        if (i == j) {
            System.out.print(name);
            return;
        }
        System.out.print("(");
        printOptimalParenthesis(K, i, K[i][j], name);
        printOptimalParenthesis(K, K[i][j] + 1, j, (char) (name + (K[i][j] - i + 1)));
        System.out.print(")");
    }

    public static void main(String[] args) {
        // Example: A(3x2), B(2x4), C(4x2), D(2x5)
        int[] d = { 3, 2, 4, 2, 5 };
        int n = d.length - 1; // number of matrices

        matrixChainOrder(d, n);
    }
}
