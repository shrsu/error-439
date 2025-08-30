public class RadixSort {

    // Function to get maximum value in the array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        return max;
    }

    // Counting sort based on digit represented by exp (1 = units, 10 = tens, etc.)
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits (0-9)

        // Count occurrences of digits
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Convert count[] to prefix sum (for stable sort)
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (traverse from end to maintain stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy back to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Radix Sort function
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Do counting sort for each digit (exp = 1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
}
