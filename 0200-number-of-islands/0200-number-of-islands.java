class Solution {
    int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length, res = 0;

        int visited[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    res++;
                    markIsland(grid, i, j, visited);
                }
            }
        }

        return res;
    }

    private void markIsland(char[][] grid, int r, int c, int[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0' || visited[r][c] == 1) return;

        visited[r][c] = 1;

        for (int[] d : dirs) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            markIsland(grid, nr, nc, visited);
        }
    }
}
