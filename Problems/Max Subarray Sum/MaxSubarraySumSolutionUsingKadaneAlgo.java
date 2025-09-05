public class MaxSubarraySumSolutionUsingKadaneAlgo {

    public static int maxSubarraySum(int[] A) {
        int currentSum = A[0];
        int maxSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currentSum = Math.max(A[i], currentSum + A[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = { 4, -5, 8, -2, -1, 7, -6 };
        System.out.println("Maximum Subarray Sum = " + maxSubarraySum(A));
    }
}
