public class Solution {

    // Function to calculate the sum of the two middle elements
    // from two sorted arrays A[] and B[] of size n each
    public static int getMiddleSum(int[] A, int[] B, int n) {
        int low = 0, high = n; // search space for partitioning A[]

        // Binary search loop
        while (low <= high) {
            // Partition indices
            int cut1 = (low + high) / 2; // cut point in A[]
            int cut2 = n - cut1; // remaining cut point in B[]

            // Handle left boundary values
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B[cut2 - 1];

            // Handle right boundary values
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : A[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : B[cut2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                // Middle two elements = max(left side) + min(right side)
                return Math.max(l1, l2) + Math.min(r1, r2);
            }
            // Too many elements taken from A[]
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            // Too few elements taken from A[]
            else {
                low = cut1 + 1;
            }
        }

        // Should not reach here if input is valid
        return -1;
    }
}
