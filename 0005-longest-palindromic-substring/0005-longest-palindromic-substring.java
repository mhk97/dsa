class Solution {

    public String longestPalindrome(String s) {
        int len = 0, n = s.length(), startIndex = -1;
        Boolean cache[][] = new Boolean[1001][1001];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s, cache) && j - i + 1 > len) {
                    startIndex = i;
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        return s.substring(startIndex, startIndex + len);
    }

    private boolean isPalindrome(int i, int j, String s, Boolean cache[][]) {
        if (i > j) return true;
        if (cache[i][j] != null) return cache[i][j];
        if (s.charAt(i) != s.charAt(j)) return cache[i][j] = false;
        return cache[i][j] = isPalindrome(i + 1, j - 1, s, cache);
    }
}
