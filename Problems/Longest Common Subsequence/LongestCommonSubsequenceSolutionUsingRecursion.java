class LongestCommonSubsequenceSolutionUsingRecursion {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length(), text2.length());
    }

    private int lcs(String text1, String text2, int i, int j) {
        // Base case: if either string is empty
        if (i == 0 || j == 0) {
            return 0;
        }

        // If last characters match
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            return 1 + lcs(text1, text2, i - 1, j - 1);
        }

        // If last characters don’t match
        return Math.max(
                lcs(text1, text2, i - 1, j), // skip one char from text1
                lcs(text1, text2, i, j - 1) // skip one char from text2
        );
    }
}
