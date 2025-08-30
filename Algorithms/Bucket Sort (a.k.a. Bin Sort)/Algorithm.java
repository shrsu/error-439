import java.util.*;

public class Algorithm {

    // Function to sort array using Bucket Sort
    public static void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;

        // Step 1: Create empty buckets
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2: Put array elements into buckets
        for (float value : arr) {
            int bucketIndex = (int) (value * n); // index calculation
            buckets[bucketIndex].add(value);
        }

        // Step 3: Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Step 4: Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        float[] arr = { 0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f };
        int n = arr.length;

        System.out.println("Original Array: " + Arrays.toString(arr));
        bucketSort(arr, n);
        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
