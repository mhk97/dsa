class Solution {
    Boolean cache[][];

    public String longestPalindrome(String s) {
        String res = "";

        cache = new Boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;
        if (cache[i][j] != null) return cache[i][j];
        if (s.charAt(i) != s.charAt(j)) return cache[i][j] = false;

        return cache[i][j] = isPalindrome(s, i + 1, j - 1);
    }
}
