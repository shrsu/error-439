import java.util.*;

/**
 * Optimal Merge Pattern (Greedy with Min-Heap)
 * - Always merge the two smallest lists first.
 * - Time: O(n log n), Space: O(n)
 */
public class OptimalMergePattern {

    /** Returns minimal total merge cost using sizes[] */
    public static long optimalMergeCost(int[] sizes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int s : sizes)
            pq.add((long) s);

        long total = 0;
        while (pq.size() > 1) {
            long a = pq.poll(); // smallest
            long b = pq.poll(); // second smallest
            long c = a + b; // cost of this merge
            total += c;
            pq.add(c); // push merged size back
        }
        return total;
    }

    /** Returns minimal cost and the actual merge sequence (pattern). */
    public static Result optimalMergePattern(int[] sizes) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.size));
        for (int s : sizes)
            pq.add(new Node(s));

        long total = 0;
        List<long[]> merges = new ArrayList<>(); // each entry: {leftSize, rightSize, mergedSize}

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            long mergedSize = left.size + right.size;
            total += mergedSize;

            Node parent = new Node(mergedSize, left, right);
            pq.add(parent);
            merges.add(new long[] { left.size, right.size, mergedSize });
        }

        Node root = pq.poll(); // final merged list (may be null if sizes empty)
        return new Result(total, merges, root);
    }

    /** Simple binary tree node for the merge tree (optional). */
    static class Node {
        long size;
        Node left, right;

        Node(long size) {
            this.size = size;
        }

        Node(long size, Node left, Node right) {
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

    /** Bundle result */
    static class Result {
        final long cost;
        final List<long[]> merges; // [a, b, a+b] in the order they were merged
        final Node root; // merge tree root (optional visualization)

        Result(long cost, List<long[]> merges, Node root) {
            this.cost = cost;
            this.merges = merges;
            this.root = root;
        }
    }

    // Demo
    public static void main(String[] args) {
        // Example 1 from your lecture: 8, 5, 6, 9 → optimal cost should be 56
        int[] ex1 = { 8, 5, 6, 9 };
        System.out.println("Cost only: " + optimalMergeCost(ex1)); // 56

        Result r1 = optimalMergePattern(ex1);
        System.out.println("Cost with pattern: " + r1.cost);
        printMerges(r1.merges);

        // Example 2 from your lecture: 8, 3, 4, 6, 5 → optimal cost should be 59
        int[] ex2 = { 8, 3, 4, 6, 5 };
        System.out.println("\nCost only: " + optimalMergeCost(ex2)); // 59

        Result r2 = optimalMergePattern(ex2);
        System.out.println("Cost with pattern: " + r2.cost);
        printMerges(r2.merges);
    }

    private static void printMerges(List<long[]> merges) {
        for (int i = 0; i < merges.size(); i++) {
            long[] m = merges.get(i);
            System.out.println("Merge " + (i + 1) + ": " + m[0] + " + " + m[1] + " = " + m[2]);
        }
    }
}
