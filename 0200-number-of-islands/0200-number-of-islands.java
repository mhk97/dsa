class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    res++;
                    markVisited(grid, i, j);
                }
            }
        }

        return res;
    }

    private void markVisited(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;

        grid[r][c] = '0';

        for (int d[] : dirs) {
            int nr = d[0] + r, nc = d[1] + c;
            markVisited(grid, nr, nc);
        }
    }
}
