class Solution {
    int r, c;

    public void solveSudoku(char[][] board) {
        r = board.length;
        c = board[0].length;

        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (canPlace(board, i, j, num) == true) {
                            board[i][j] = num;
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

    public boolean canPlace(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            //col
            if (board[row][i] == num) return false;

            //row
            if (board[i][col] == num) return false;

            //9*9
            int r_ = 3 * (row / 3) + i / 3;
            int c_ = 3 * (col / 3) + i % 3;

            if (board[r_][c_] == num) return false;
        }

        return true;
    }
}
