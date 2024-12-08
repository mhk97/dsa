class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean cache[][] = new Boolean[n + 1][n + 1];
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, cache) == true && res.length() < (j - i + 1)) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s, int i, int j, Boolean cache[][]) {
        if (i > j) return true;

        if (cache[i][j] != null) return cache[i][j];
        if (s.charAt(i) != s.charAt(j)) return false;

        return cache[i][j] = isPalindrome(s, i + 1, j - 1, cache);
    }
}
