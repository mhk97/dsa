class Solution {

    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();

        for (int i = Math.min(l1, l2); i >= 1; i--) {
            if (valid(str1, str2, i) == true) return str1.substring(0, i);
        }

        return "";
    }

    public boolean valid(String s1, String s2, int len) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 % len != 0 || l2 % len != 0) return false; else {
            String temp = s1.substring(0, len);
            return s1.replace(temp, "").isEmpty() && s2.replace(temp, "").isEmpty();
        }
    }
}
