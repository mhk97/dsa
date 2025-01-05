class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int row, col;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        int res = 0;

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
        if (r >= row || c >= col || r < 0 || c < 0 || grid[r][c] == 0) return 0;
        grid[r][c] = 0;

        int temp = 1;
        for (int i[] : dirs) {
            int nr = i[0] + r, nc = i[1] + c;
            temp += dfs(nr, nc, grid);
        }

        return temp;
    }
}
