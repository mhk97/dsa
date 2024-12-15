class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };

    int row, col;
    Integer[][] cache;

    public int uniquePathsWithObstacles(int[][] og) {
        row = og.length;
        col = og[0].length;
        cache = new Integer[row + 1][col + 1];

        return solve(og, 0, 0);
    }

    public int solve(int[][] og, int r, int c) {
        if (r >= row || c >= col || og[r][c] == 1) return 0;
        if (r == row - 1 && c == col - 1) return 1;
        if (cache[r][c] != null) return cache[r][c];

        int res = 0;

        for (int d[] : dirs) {
            int nr = r + d[0], nc = d[1] + c;
            res += solve(og, nr, nc);
        }

        return cache[r][c] = res;
    }
}
