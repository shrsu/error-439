import java.util.*;

public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();

        // Step 1: Convert buildings into "events"
        // Each building creates 2 events:
        //   - (x = left, height = -h) → entering event
        //   - (x = right, height = h) → leaving event
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // start of building
            events.add(new int[]{b[1], b[2]});  // end of building
        }

        // Step 2: Sort events
        // Rules:
        //   1. Sort by x coordinate
        //   2. If same x:
        //      - process start (negative height) before end (positive height)
        //      - higher height before lower (to avoid duplicates)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // Step 3: Max Heap to keep current active heights
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(0); // ground level
        int prevMax = 0;

        // Step 4: Process events
        for (int[] e : events) {
            int x = e[0], h = e[1];

            if (h < 0) { 
                // entering event: add height
                heap.add(-h);
            } else {
                // leaving event: remove height
                heap.remove(h);
            }

            int currMax = heap.peek();
            if (currMax != prevMax) {
                // skyline changes
                result.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }

        return result;
    }
}
