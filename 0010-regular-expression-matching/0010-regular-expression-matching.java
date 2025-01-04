class Solution {

    public boolean isMatch(String s, String p) {
        return solve(0, 0, s, p);
    }

    public boolean solve(int i, int j, String s, String p) {
        if (j == p.length()) return i == s.length();

        boolean firstCharMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            boolean take = firstCharMatch && solve(i + 1, j, s, p);

            boolean skip = solve(i, j + 2, s, p);

            return take || skip;
        } else {
            return firstCharMatch && solve(i + 1, j + 1, s, p);
        }
    }
}
