public class SudokuSolverSolution {

    private static final int N = 9; // size of Sudoku grid

    public static void main(String[] args) {
        int[][] board = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        if (solveSudoku(board, 0, 0)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }
    }

    // Recursive solver
    private static boolean solveSudoku(int[][] board, int row, int col) {
        // If reached beyond last row → puzzle solved
        if (row == N) {
            return true;
        }

        // Compute next cell coordinates
        int nextRow = (col == N - 1) ? row + 1 : row;
        int nextCol = (col == N - 1) ? 0 : col + 1;

        // If cell already filled → move to next cell
        if (board[row][col] != 0) {
            return solveSudoku(board, nextRow, nextCol);
        }

        // Try placing numbers 1–9
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num; // place number

                if (solveSudoku(board, nextRow, nextCol)) {
                    return true; // solution found
                }

                board[row][col] = 0; // backtrack
            }
        }

        return false; // no number works here
    }

    // Check if placing num at (row, col) is valid
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int j = 0; j < N; j++) {
            if (board[row][j] == num)
                return false;
        }

        // Check column
        for (int i = 0; i < N; i++) {
            if (board[i][col] == num)
                return false;
        }

        // Check 3x3 block
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num)
                    return false;
            }
        }

        return true;
    }

    // Utility function to print Sudoku
    private static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < N; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
