import java.util.PriorityQueue;

public class MinimumCostOfRopesSolution {

    public static long minCost(long[] arr, int n) {
        // Step 1: Put all ropes into a min-heap
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long length : arr) {
            pq.add(length);
        }

        long totalCost = 0;

        // Step 2: Keep combining ropes until only one is left
        while (pq.size() > 1) {
            // Get two smallest ropes
            long first = pq.poll();
            long second = pq.poll();

            // Cost of connecting them
            long cost = first + second;
            totalCost += cost;

            // Push the combined rope back
            pq.add(cost);
        }

        return totalCost;
    }

    // Example run
    public static void main(String[] args) {
        long[] arr1 = {4, 3, 2, 6};
        System.out.println(minCost(arr1, arr1.length)); // Output: 29

        long[] arr2 = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr2, arr2.length)); // Output: 62
    }
}
