public class Algorithm {

    // Function to perform quicksort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right parts
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition using median-of-three
    private static int partition(int[] arr, int low, int high) {
        // Choose pivot using median-of-three
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        int pivot = arr[pivotIndex];

        // Move pivot to the end (swap with high)
        swap(arr, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // place pivot correctly
        return i + 1;
    }

    // Find median of arr[a], arr[b], arr[c] and return its index
    private static int medianOfThree(int[] arr, int a, int b, int c) {
        if ((arr[a] > arr[b]) != (arr[a] > arr[c]))
            return a;
        else if ((arr[b] > arr[a]) != (arr[b] > arr[c]))
            return b;
        else
            return c;
    }

    // Swap helper
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
