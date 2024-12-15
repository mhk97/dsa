class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length, res = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, char[][] grid) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        for (int[] d : dirs) {
            int nr = d[0] + r, nc = d[1] + c;
            dfs(nr, nc, grid);
        }
    }
}
