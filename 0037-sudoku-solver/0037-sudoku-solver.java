class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == '.') {
                    for (char i = '1'; i <= '9'; i++) {
                        if (isValid(r, c, i, board)) {
                            board[r][c] = i;
                            if (solve(board)) return true; else board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int r, int c, char v, char[][] board) {
        for (int i = 0; i < 9; i++) {
            //check row
            if (board[i][c] == v) return false;

            //check col
            if (board[r][i] == v) return false;

            //check box
            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if (board[row][col] == v) return false;
        }

        return true;
    }
}
