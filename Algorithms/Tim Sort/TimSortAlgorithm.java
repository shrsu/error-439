public class TimSortAlgorithm {

    // Run size (commonly between 32–64 in real TimSort)
    private static final int RUN = 32;

    // Insertion Sort for small runs
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge two sorted subarrays
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1, len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        // Copy data
        for (int i = 0; i < len1; i++)
            leftArr[i] = arr[left + i];
        for (int i = 0; i < len2; i++)
            rightArr[i] = arr[mid + 1 + i];

        // Merge step
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < len1)
            arr[k++] = leftArr[i++];
        while (j < len2)
            arr[k++] = rightArr[j++];
    }

    // TimSort implementation
    public static void timSort(int[] arr) {
        int n = arr.length;

        // Step 1: Sort small runs with insertion sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        // Step 2: Merge runs like MergeSort
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

}
