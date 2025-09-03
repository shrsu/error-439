import java.util.*;

public class NQueensSolution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        findQueen(0, board, ans, n);
        return ans;
    }

    private void findQueen(int row, char[][] board, List<List<String>> ans, int n) {
        // base case: if all queens are placed
        if (row == n) {
            List<String> comb = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                comb.add(new String(board[i])); // <-- make a new string for each row
            }
            ans.add(new ArrayList<>(comb)); // <-- make a new copy for ans
            return;
        }

        // try placing queen in each column
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q'; // place queen
                findQueen(row + 1, board, ans, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // check column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // check upper-right diagonal
        int i = row, j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }

        // check upper-left diagonal
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        return true;
    }

}
