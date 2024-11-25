class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0) == true) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int wi) {
        if (wi >= word.length()) return true;

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(wi)) return false;

        board[r][c] = '#';
        for (int d[] : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (dfs(board, nr, nc, word, wi + 1) == true) return true;
        }
        board[r][c] = word.charAt(wi);
        return false;
    }
}
