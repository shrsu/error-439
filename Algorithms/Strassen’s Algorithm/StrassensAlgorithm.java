import java.util.Arrays;

public class StrassensAlgorithm {

    // Tune this. 64 is a good starting point.
    private static final int CUTOFF = 64;

    /**
     * Public method: multiply A (m x k) by B (k x n).
     * Handles non-square and non-power-of-two by padding, then crops the result.
     */
    public static double[][] multiply(double[][] A, double[][] B) {
        if (A.length == 0 || B.length == 0)
            throw new IllegalArgumentException("Empty matrices.");
        int m = A.length;
        int kA = A[0].length;
        int kB = B.length;
        int n = B[0].length;

        if (kA != kB)
            throw new IllegalArgumentException("Inner dimensions must match: A is m x k, B is k x n.");

        // Determine target square size (next power of two covering all dims)
        int size = Math.max(Math.max(m, kA), n);
        int s = nextPowerOfTwo(size);

        // Pad A and B to s x s
        double[][] Aprep = new double[s][s];
        double[][] Bprep = new double[s][s];
        copyInto(A, Aprep, 0, 0);
        copyInto(B, Bprep, 0, 0);

        double[][] Cprep = strassen(Aprep, Bprep, s);

        // Crop result back to m x n
        double[][] C = new double[m][n];
        copyOut(Cprep, C, 0, 0);
        return C;
    }

    // Core Strassen recursion on square s x s matrices
    private static double[][] strassen(double[][] A, double[][] B, int s) {
        if (s <= CUTOFF) {
            return naiveMultiply(A, B, s);
        }

        int half = s / 2;

        // Split into quadrants
        double[][] A11 = submatrix(A, 0, 0, half);
        double[][] A12 = submatrix(A, 0, half, half);
        double[][] A21 = submatrix(A, half, 0, half);
        double[][] A22 = submatrix(A, half, half, half);

        double[][] B11 = submatrix(B, 0, 0, half);
        double[][] B12 = submatrix(B, 0, half, half);
        double[][] B21 = submatrix(B, half, 0, half);
        double[][] B22 = submatrix(B, half, half, half);

        // M1..M7
        double[][] M1 = strassen(add(A11, A22), add(B11, B22), half);
        double[][] M2 = strassen(add(A21, A22), B11, half);
        double[][] M3 = strassen(A11, sub(B12, B22), half);
        double[][] M4 = strassen(A22, sub(B21, B11), half);
        double[][] M5 = strassen(add(A11, A12), B22, half);
        double[][] M6 = strassen(sub(A21, A11), add(B11, B12), half);
        double[][] M7 = strassen(sub(A12, A22), add(B21, B22), half);

        // C blocks
        double[][] C11 = add(sub(add(M1, M4), M5), M7);
        double[][] C12 = add(M3, M5);
        double[][] C21 = add(M2, M4);
        double[][] C22 = add(sub(add(M1, M3), M2), M6);

        // Join quadrants
        double[][] C = new double[s][s];
        paste(C11, C, 0, 0);
        paste(C12, C, 0, half);
        paste(C21, C, half, 0);
        paste(C22, C, half, half);

        return C;
    }

    // Naive O(n^3) multiply on s x s (used at cutoff)
    private static double[][] naiveMultiply(double[][] A, double[][] B, int s) {
        double[][] C = new double[s][s];
        for (int i = 0; i < s; i++) {
            double[] Ai = A[i];
            double[] Ci = C[i];
            for (int k = 0; k < s; k++) {
                double aik = Ai[k];
                double[] Bk = B[k];
                for (int j = 0; j < s; j++) {
                    Ci[j] += aik * Bk[j];
                }
            }
        }
        return C;
    }

    // Matrix helpers: add/sub on equal-size square blocks
    private static double[][] add(double[][] X, double[][] Y) {
        int n = X.length;
        double[][] R = new double[n][n];
        for (int i = 0; i < n; i++) {
            double[] Xi = X[i], Yi = Y[i], Ri = R[i];
            for (int j = 0; j < n; j++)
                Ri[j] = Xi[j] + Yi[j];
        }
        return R;
    }

    private static double[][] sub(double[][] X, double[][] Y) {
        int n = X.length;
        double[][] R = new double[n][n];
        for (int i = 0; i < n; i++) {
            double[] Xi = X[i], Yi = Y[i], Ri = R[i];
            for (int j = 0; j < n; j++)
                Ri[j] = Xi[j] - Yi[j];
        }
        return R;
    }

    // Extract an n x n submatrix starting at (row, col)
    private static double[][] submatrix(double[][] M, int row, int col, int n) {
        double[][] R = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(M[row + i], col, R[i], 0, n);
        }
        return R;
    }

    // Paste block S into destination D at (row, col)
    private static void paste(double[][] S, double[][] D, int row, int col) {
        int n = S.length;
        for (int i = 0; i < n; i++) {
            System.arraycopy(S[i], 0, D[row + i], col, n);
        }
    }

    // Copy possibly-rectangular src into top-left of dst
    private static void copyInto(double[][] src, double[][] dst, int row, int col) {
        int r = src.length, c = src[0].length;
        for (int i = 0; i < r; i++) {
            System.arraycopy(src[i], 0, dst[row + i], col, c);
        }
    }

    // Crop top-left of src into dst (dst defines the target shape)
    private static void copyOut(double[][] src, double[][] dst, int row, int col) {
        int r = dst.length, c = dst[0].length;
        for (int i = 0; i < r; i++) {
            System.arraycopy(src[row + i], col, dst[i], 0, c);
        }
    }

    private static int nextPowerOfTwo(int n) {
        int p = 1;
        while (p < n)
            p <<= 1;
        return p;
    }

    // Demo
    public static void main(String[] args) {
        double[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        }; // 2x3

        double[][] B = {
                { 7, 8 },
                { 9, 10 },
                { 11, 12 }
        }; // 3x2

        double[][] C = multiply(A, B); // 2x2 result
        for (double[] row : C) {
            System.out.println(Arrays.toString(row));
        }
        // Expected: [[58.0, 64.0], [139.0, 154.0]]
    }
}
