class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    int row, col;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int temp = dfs(i, j, grid);
                    res = Math.max(res, temp);
                }
            }
        }

        return res;
    }

    public int dfs(int r, int c, int[][] grid) {
        int res = 1;
        grid[r][c] = 0;
        for (int[] d : dirs) {
            int nr = d[0] + r, nc = d[1] + c;
            if (nr < row && nr >= 0 && nc < col && nc >= 0 && grid[nr][nc] == 1) {
                res += dfs(nr, nc, grid);
            }
        }

        return res;
    }
}
