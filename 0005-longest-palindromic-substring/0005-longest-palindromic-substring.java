class Solution {

    public String longestPalindrome(String s) {
        int len = 0, n = s.length(), startIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s) && j - i + 1 > len) {
                    startIndex = i;
                    len = Math.max(len, j - i + 1);
                }
            }
        }

        return s.substring(startIndex, startIndex + len);
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
