class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, char[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') return;

        grid[r][c] = '0'; //visited

        for (int d[] : dirs) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            dfs(nr, nc, grid);
        }
    }
}
