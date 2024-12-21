class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };

    Integer cache[][];

    public int minPathSum(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length];
        return solve(grid, 0, 0);
    }

    public int solve(int[][] grid, int i, int j) {
        int r = grid.length, c = grid[0].length;

        if (i == r - 1 && j == c - 1) {
            return grid[i][j];
        }

        if (i >= r || j >= c) return (int) 1e8;

        if (cache[i][j] != null) return cache[i][j];

        int min = Integer.MAX_VALUE;

        for (int d[] : dirs) {
            int nr = d[0] + i, nc = d[1] + j;
            int temp = grid[i][j] + solve(grid, nr, nc);
            min = Math.min(min, temp);
        }

        return cache[i][j] = min;
    }
}
