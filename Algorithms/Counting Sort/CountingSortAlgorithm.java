public class CountingSortAlgorithm {
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
        int range = max - min + 1;
        int[] count = new int[range];
        for (int num : arr) {
            count[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}
