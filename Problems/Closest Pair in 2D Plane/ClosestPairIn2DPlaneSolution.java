import java.util.*;

public class ClosestPairIn2DPlaneSolution {

    // A simple class to represent a point in 2D space
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Calculate Euclidean distance between two points
    static double distance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Brute-force method for small arrays (≤ 3 points)
    static double bruteForce(Point[] points, int left, int right) {
        double min_dist = Double.MAX_VALUE;
        // Compare every pair
        for (int i = left; i <= right; ++i) {
            for (int j = i + 1; j <= right; ++j) {
                min_dist = Math.min(min_dist, distance(points[i], points[j]));
            }
        }
        return min_dist;
    }

    // Check the closest distance in the strip around the dividing line
    static double stripClosest(List<Point> strip, double d) {
        // Sort points in the strip by y-coordinate
        Collections.sort(strip, (p1, p2) -> Integer.compare(p1.y, p2.y));

        double min = d;
        // Compare each point with the next few points in y-order
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++) {
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
            }
        }
        return min;
    }

    // Recursive Divide and Conquer function
    static double findClosestUtil(Point[] points, int left, int right) {
        // Base case: If 3 or fewer points, solve by brute force
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        // Find the midpoint
        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        // Recursively find the smallest distances in left and right halves
        double dLeft = findClosestUtil(points, left, mid);
        double dRight = findClosestUtil(points, mid + 1, right);
        double d = Math.min(dLeft, dRight);

        // Build a strip of points near the dividing line (within distance d)
        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < d) {
                strip.add(points[i]);
            }
        }

        // Find closest pair in the strip and return the minimum overall
        return Math.min(d, stripClosest(strip, d));
    }

    // Main method to find the closest pair distance
    static double findClosest(Point[] points, int n) {
        // Step 1: Sort points by x-coordinate
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1.x, p2.x));
        // Step 2: Run recursive divide and conquer
        return findClosestUtil(points, 0, n - 1);
    }

}
