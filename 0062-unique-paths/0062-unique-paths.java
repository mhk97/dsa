class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 } };
    Integer[][] cache;

    public int uniquePaths(int m, int n) {
        cache = new Integer[m + 1][n + 1];
        return solve(m, n, 0, 0);
    }

    public int solve(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i < 0 || i >= m || j < 0 || j >= n) return 0;

        if (cache[i][j] != null) return cache[i][j];
        
        int curr = 0;
        for (int d[] : dirs) {
            int nr = d[0] + i, nc = d[1] + j;
            curr += solve(m, n, nr, nc);
        }

        return cache[i][j] = curr;
    }
}
