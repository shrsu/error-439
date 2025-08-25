public class BinarySearch {

    // Function to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // To avoid overflow
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Found, return index
            } else if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; // Base case: not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, mid + 1, high, target);
        } else {
            return binarySearchRecursive(arr, low, mid - 1, target);
        }
    }

}
