import java.math.BigInteger;
import java.util.Scanner;

public class AlgorithmV2 {

    // Karatsuba algorithm for BigInteger
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        // Base case: if x or y is small, just multiply directly
        int N = Math.max(x.toString().length(), y.toString().length());
        if (N <= 10) { // for small numbers, direct multiply
            return x.multiply(y);
        }

        // Split the digit length in half
        int m = N / 2;

        // 10^m
        BigInteger pow10m = BigInteger.TEN.pow(m);

        // Split x into high and low
        BigInteger high1 = x.divide(pow10m);
        BigInteger low1  = x.mod(pow10m);

        // Split y into high and low
        BigInteger high2 = y.divide(pow10m);
        BigInteger low2  = y.mod(pow10m);

        // 3 recursive calls
        BigInteger z0 = karatsuba(low1, low2);
        BigInteger z2 = karatsuba(high1, high2);
        BigInteger z1 = karatsuba(high1.add(low1), high2.add(low2)).subtract(z2).subtract(z0);

        // result = z2 * 10^(2m) + z1 * 10^m + z0
        return z2.multiply(BigInteger.TEN.pow(2 * m))
                .add(z1.multiply(pow10m))
                .add(z0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take inputs as BigInteger
        BigInteger x = sc.nextBigInteger();
        BigInteger y = sc.nextBigInteger();

        // Multiply using Karatsuba
        BigInteger result = karatsuba(x, y);

        System.out.println(result);
        sc.close();
    }
    
}
