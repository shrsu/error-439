import java.util.*;

public class FindPeakElementSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lo = 0, hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // If mid element is greater than the next element,
            // then the peak lies on the left side (including mid)
            if (arr[mid] > arr[mid + 1]) {
                hi = mid;
            } else {
                // Else, the peak lies on the right side
                lo = mid + 1;
            }
        }

        // At the end, lo == hi == index of a peak
        System.out.println(lo);
        sc.close();
    }
}
