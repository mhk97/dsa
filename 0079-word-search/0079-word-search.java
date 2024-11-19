class Solution {

    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0) == true)
                        return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int ind) {
        if (ind >= word.length())
            return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(ind))
            return false;

        board[r][c] = '#';
        for(int d[] : dirs){
            int nr = d[0]+r, nc = d[1]+c;
            if(dfs(board, nr, nc, word, ind+1) == true) return true;
        }
        board[r][c] = word.charAt(ind);
        return false;
    }
}