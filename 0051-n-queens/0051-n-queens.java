class Solution {
    List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        //create an empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, new int[n], new int[2 * n - 1], new int[2 * n - 1], 0);
        return res;
    }

    public void addRes(char[][] board) {
        List<String> temp = new ArrayList();
        for (char r[] : board) {
            temp.add(new String(r));
        }
        res.add(temp);
    }

    public void solve(char[][] board, int[] left, int[] upper, int[] lower, int col) {
        if (col == board.length) {
            addRes(board);
            return;
        }

        for (int r = 0; r < board.length; r++) {
            int ud = r + col;
            int ld = (board.length - 1) + col - r;
            if (upper[ud] == 1 || lower[ld] == 1 || left[r] == 1) continue; // not placable

            upper[ud] = 1;
            lower[ld] = 1;
            left[r] = 1;
            board[r][col] = 'Q';

            solve(board, left, upper, lower, col + 1);

            upper[ud] = 0;
            lower[ld] = 0;
            left[r] = 0;
            board[r][col] = '.';
        }
    }
}
