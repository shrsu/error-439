public class Algorithm {

    public static int maxSubArray(int[] nums) {
        // Step 1: Initialize
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        // Step 2: Traverse the array
        for (int i = 1; i < nums.length; i++) {
            // Either extend current subarray OR start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Step 3: Update global maximum
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

}
