public class MaxSubarraySumSolutionUsingDivideAndConquer {

    // Function to find maximum crossing subarray sum
    private static int maxCrossingSum(int[] arr, int low, int mid, int high) {
        // Left sum
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        // Right sum
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    // Main recursive function
    public static int maxSubarraySum(int[] arr, int low, int high) {
        // Base case: only one element
        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;

        int leftMax = maxSubarraySum(arr, low, mid);
        int rightMax = maxSubarraySum(arr, mid + 1, high);
        int crossMax = maxCrossingSum(arr, low, mid, high);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    public static void main(String[] args) {
        int[] arr = { 3, -7, 10, 2, 7, -11, -5, 9, 3 };
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, 0, n - 1);
        System.out.println("Maximum Subarray Sum = " + maxSum);
    }
}
