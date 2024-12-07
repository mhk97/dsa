class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public void solve(char[][] b) {
        int r = b.length, c = b[0].length;
        for (int i = 0; i < r; i++) {
            if (b[i][0] == 'O') {
                dfs(b, i, 0);
            }
        }

        for (int i = 0; i < r; i++) {
            if (b[i][c - 1] == 'O') {
                dfs(b, i, c - 1);
            }
        }

        for (int i = 0; i < c; i++) {
            if (b[0][i] == 'O') {
                dfs(b, 0, i);
            }
        }

        for (int i = 0; i < c; i++) {
            if (b[r - 1][i] == 'O') {
                dfs(b, r - 1, i);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (b[i][j] == 'O') b[i][j] = 'X'; else if (b[i][j] == 'M') b[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] b, int i, int j) {
        if (i >= b.length || i < 0 || j >= b[0].length || j < 0 || b[i][j] != 'O') return;

        b[i][j] = 'M';

        for (int d[] : dirs) {
            int nr = d[0] + i, nc = d[1] + j;
            dfs(b, nr, nc);
        }
    }
}
