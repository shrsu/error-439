import java.util.Stack;

public class Solution {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // stack to store repeat counts
        Stack<StringBuilder> stringStack = new Stack<>(); // stack to store previous strings
        StringBuilder currentStr = new StringBuilder(); // current string being built
        int k = 0; // number before '[' (may be multiple digits)

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the number (could be >9, e.g., "12[ab]")
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Save the repeat count and current string so far
                countStack.push(k);
                stringStack.push(currentStr);

                // Reset for new substring inside brackets
                currentStr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // End of bracket: pop previous string and repeat count
                StringBuilder decoded = stringStack.pop();
                int repeat = countStack.pop();

                // Repeat the currentStr and append to decoded
                for (int i = 0; i < repeat; i++) {
                    decoded.append(currentStr);
                }

                // This becomes the new current string
                currentStr = decoded;
            } else {
                // Just a normal character, add to current substring
                currentStr.append(ch);
            }
        }

        return currentStr.toString();
    }
}
