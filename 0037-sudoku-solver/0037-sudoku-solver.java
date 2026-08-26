class Solution {

    public boolean isSafe(char[][] board, int row, int col, int num) {

        // Check row and column
        for (int i = 0; i < board.length; i++) {

            if (board[i][col] == (char)(num + '0')) {
                return false;
            }

            if (board[row][i] == (char)(num + '0')) {
                return false;
            }
        }

        // Check 3 x 3 grid
        int sc = (col / 3) * 3;
        int sr = (row / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {

                if (board[i][j] == (char)(num + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(char[][] board, int row, int col) {

        // All rows completed
        if (row == board.length) {
            return true;
        }

        int nrow;
        int ncol;

        // Move to next cell
        if (col != board.length - 1) {
            nrow = row;
            ncol = col + 1;   // ✅ FIX
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        // Already filled
        if (board[row][col] != '.') {

            if (solve(board, nrow, ncol)) {
                return true;
            }

        } else {

            // Try numbers 1 to 9
            for (int i = 1; i <= 9; i++) {

                if (isSafe(board, row, col, i)) {

                    board[row][col] = (char)(i + '0');

                    if (solve(board, nrow, ncol)) {
                        return true;
                    }

                    // Backtrack
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}