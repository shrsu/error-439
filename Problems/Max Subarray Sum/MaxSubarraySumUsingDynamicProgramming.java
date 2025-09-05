public class MaxSubarraySumUsingDynamicProgramming {

    public static int maxSubarraySum(int[] A) {
        int n = A.length;
        int[] S = new int[n]; // DP array
        S[0] = A[0];

        int maxSum = S[0];

        for (int i = 1; i < n; i++) {
            S[i] = Math.max(A[i], S[i - 1] + A[i]);
            maxSum = Math.max(maxSum, S[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = { 4, -5, 8, -2, -1, 7, -6 };
        System.out.println("Maximum Subarray Sum = " + maxSubarraySum(A));
    }
}
