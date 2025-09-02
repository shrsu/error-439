public class KaratsubaAlgorithm {

    // Main karatsuba function
    public static long karatsuba(long x, long y) {
        // Base case: when numbers are small, just multiply directly
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Find the size of the numbers
        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int m = n / 2; // split position (half length)

        // Split the digits into high and low parts
        long high1 = x / (long)Math.pow(10, m);
        long low1 = x % (long)Math.pow(10, m);
        long high2 = y / (long)Math.pow(10, m);
        long low2 = y % (long)Math.pow(10, m);

        // 3 recursive multiplications
        long z0 = karatsuba(low1, low2);                 // low * low
        long z2 = karatsuba(high1, high2);               // high * high
        long z1 = karatsuba((high1 + low1), (high2 + low2)) - z2 - z0;

        // Combine the results
        return (z2 * (long)Math.pow(10, 2 * m)) + (z1 * (long)Math.pow(10, m)) + z0;
    }

    public static void main(String[] args) {
        long x = 1234;
        long y = 5678;
        System.out.println("Multiplying " + x + " * " + y);
        System.out.println("Result = " + karatsuba(x, y));
    }
}
