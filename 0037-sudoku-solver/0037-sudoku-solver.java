class Solution {
    int row, col;

    public void solveSudoku(char[][] board) {
        row = board.length;
        col = board[0].length;

        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (canPlace(i, j, k, board) == true) {
                            board[i][j] = k;
                            if (solve(board) == true) return true;
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean canPlace(int i, int j, char k, char[][] board) {
        for (int m = 0; m < 9; m++) {
            //row const -- check for col
            if (board[i][m] == k) return false;

            //col const -- check for row
            if (board[m][j] == k) return false;

            int r_ = 3 * (i / 3) + m / 3;
            int c_ = 3 * (j / 3) + m % 3;

            if (board[r_][c_] == k) return false;
        }

        return true;
    }
}
