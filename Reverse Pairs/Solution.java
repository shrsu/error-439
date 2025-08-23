class Solution {
    public int reversePairs(int[] nums) {
        // Call merge sort helper to count reverse pairs in the full array
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        // Base case: if only one element (or none), no reverse pairs
        if (left >= right) return 0;

        // Divide array into two halves
        int mid = left + (right - left) / 2;

        // Count reverse pairs in left half + right half
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // --- Count cross pairs (i from left half, j from right half) ---
        int j = mid + 1;  // start pointer for right half
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)nums[i] > 2L * nums[j]) {
                j++; // move j forward while condition holds
            }
            // For nums[i], number of valid js = (j - (mid+1))
            count += (j - (mid + 1));
        }

        // Merge the two halves into sorted order
        merge(nums, left, mid, right);

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // Temporary array to hold sorted values
        int[] temp = new int[right - left + 1];

        int i = left;     // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = 0;        // pointer for temp array

        // Merge two sorted halves
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements from left half (if any)
        while (i <= mid) temp[k++] = nums[i++];

        // Copy remaining elements from right half (if any)
        while (j <= right) temp[k++] = nums[j++];

        // Copy merged values back to original array
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}
