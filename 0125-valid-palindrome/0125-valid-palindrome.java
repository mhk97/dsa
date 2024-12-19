class Solution {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int i = 0, j = s.length() - 1;

        while (i <= j) {
            if (!checkAlphabet(s.charAt(i))) i++; else if (!checkAlphabet(s.charAt(j))) j--; else if (s.charAt(i) != s.charAt(j)) return false; else {
                i++;
                j--;
            }
        }

        return true;
    }

    public boolean checkAlphabet(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }
}
