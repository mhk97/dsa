class Solution {
    Integer[][] cache;

    public int longestCommonSubsequence(String s1, String s2) {
        cache = new Integer[s1.length()][s2.length()];
        return solve(s1, s2, 0, 0);
    }

    public int solve(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (cache[i][j] != null) return cache[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = 1 + solve(s1, s2, i + 1, j + 1);
        }

        return cache[i][j] = Math.max(solve(s1, s2, i + 1, j), solve(s1, s2, i, j + 1));
    }
}
