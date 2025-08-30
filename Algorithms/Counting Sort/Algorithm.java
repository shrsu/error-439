public class Algorithm {

    // Counting Sort function
    public static void countingSort(int[] arr) {
        if (arr.length == 0)
            return; // Edge case

        // Step 1: Find the maximum and minimum values
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }

        // Step 2: Create count array
        int range = max - min + 1; // size of count array
        int[] count = new int[range];

        // Step 3: Store frequencies
        for (int num : arr) {
            count[num - min]++; // shift by 'min'
        }

        // Step 4: Rebuild the sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min; // shift back to original value
                count[i]--;
            }
        }
    }
}
