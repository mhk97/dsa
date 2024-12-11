class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 } };
    Integer cache[][];
    public int minPathSum(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length];
        return solve(grid, 0, 0);
    }

    public int solve(int[][] grid, int r, int c) {
        if (r == grid.length - 1 && c == grid[0].length - 1) return grid[r][c];
        if (r >= grid.length || r < 0 || c < 0 || c >= grid[0].length) return (int) 1e9;
        if(cache[r][c]!= null) return cache[r][c];
        int res = Integer.MAX_VALUE;
        for (int i[] : dirs) {
            int nr = i[0] + r, nc = i[1] + c;
            res = Math.min(res, grid[r][c] + solve(grid, nr, nc));
        }

        return cache[r][c] = res;
    }
}
