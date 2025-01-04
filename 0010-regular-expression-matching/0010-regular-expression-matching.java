class Solution {
    Boolean cache[][];

    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p);
    }

    public boolean solve(int i, int j, String s, String p) {
        if (j == p.length()) return i == s.length();

        if (cache[i][j] != null) return cache[i][j];

        boolean firstCharMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            boolean take = firstCharMatch && solve(i + 1, j, s, p);

            boolean skip = solve(i, j + 2, s, p);

            return cache[i][j] = take || skip;
        } else {
            return cache[i][j] = firstCharMatch && solve(i + 1, j + 1, s, p);
        }
    }
}
