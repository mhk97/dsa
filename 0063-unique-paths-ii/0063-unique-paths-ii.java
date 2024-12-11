class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };

    Integer cache[][];

    public int uniquePathsWithObstacles(int[][] og) {
        cache = new Integer[og.length + 1][og[0].length + 1];
        return solve(og, 0, 0);
    }

    public int solve(int[][] og, int r, int c) {
        if (r >= og.length || c >= og[0].length || r < 0 || c < 0 || og[r][c] == 1) return 0;
        if (r == og.length - 1 && c == og[0].length - 1) return 1;

        if (cache[r][c] != null) return cache[r][c];

        int res = 0;
        for (int d[] : dirs) {
            int nr = d[0] + r, nc = d[1] + c;
            res += solve(og, nr, nc);
        }

        return cache[r][c] = res;
    }
}
