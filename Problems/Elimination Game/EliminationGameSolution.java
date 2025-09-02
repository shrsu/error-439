public class EliminationGameSolution {
    public static int lastRemaining(int n) {
        boolean left = true; // elimination starts from left
        int head = 1; // first element of sequence
        int step = 1; // gap between surviving numbers

        while (n > 1) { // repeat until only one element remains
            // If eliminating from left OR n is odd when eliminating from right,
            // the head moves forward
            if (left || n % 2 == 1) {
                head += step;
            }

            n /= 2; // half of the numbers are eliminated
            step *= 2; // gap doubles after each round
            left = !left; // switch direction (left <-> right)
        }

        return head; // last remaining number
    }
}
