class Solution {
    Boolean cache[][];

    public String longestPalindrome(String s) {
        String res = "";
        cache = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (palindrome(s, i, j) && (j - i + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public boolean palindrome(String s, int i, int j) {
        if (i > j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        if (cache[i][j] != null) return cache[i][j];

        return cache[i][j] = palindrome(s, i + 1, j - 1);
    }
}
