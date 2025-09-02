import java.util.*;

public class CountOfSmallerNumbersAfterSelfSolution {

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            // Find position using binary search
            int pos = Collections.binarySearch(sortedList, num);

            if (pos < 0) {
                // If not found, binarySearch returns (-insertionPoint - 1)
                pos = -pos - 1;
            }

            // Position = count of smaller numbers
            result.add(pos);

            // Insert current number at correct position
            sortedList.add(pos, num);
        }

        // We filled result backwards → reverse it
        Collections.reverse(result);
        return result;
    }

    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    // Merge Sort based approach
    
    public static List<Integer> countSmallerUsingMergeSort(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];

        // Initialize result with 0s
        Arrays.fill(result, 0);

        // Build array of (value, index)
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // Run merge sort
        mergeSort(arr, 0, n - 1, result);

        return Arrays.asList(result);
    }

    // Merge Sort function
    private static void mergeSort(Pair[] arr, int left, int right, Integer[] result) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);

        merge(arr, left, mid, right, result);
    }

    // Merge function that counts
    private static void merge(Pair[] arr, int left, int mid, int right, Integer[] result) {
        List<Pair> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        int rightCounter = 0; // how many numbers from right half are smaller

        while (i <= mid && j <= right) {
            if (arr[i].value <= arr[j].value) {
                // All rightCounter smaller elements have passed
                result[arr[i].index] += rightCounter;
                temp.add(arr[i]);
                i++;
            } else {
                // arr[j] is smaller → contributes to rightCounter
                rightCounter++;
                temp.add(arr[j]);
                j++;
            }
        }

        // Remaining elements in left half
        while (i <= mid) {
            result[arr[i].index] += rightCounter;
            temp.add(arr[i]);
            i++;
        }

        // Remaining elements in right half
        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        // Copy back to arr
        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
