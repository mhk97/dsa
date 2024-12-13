class Solution {
    Integer[][] cache;

    public int minimumTotal(List<List<Integer>> t) {
        cache = new Integer[201][201];
        return solve(t, 0, 0);
    }

    public int solve(List<List<Integer>> t, int i, int j) {
        if (cache[i][j] != null) return cache[i][j];
        int k = t.get(i).get(j);

        if (i < t.size() - 1) k += Math.min(solve(t, i + 1, j), solve(t, i + 1, j + 1));

        return cache[i][j] = k;
    }
}
