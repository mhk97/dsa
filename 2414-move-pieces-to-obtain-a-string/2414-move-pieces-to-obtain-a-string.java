class Solution {

    public boolean canChange(String s, String t) {
        int i = 0, j = 0, slen = s.length(), tlen = t.length();

        while (i < slen || j < tlen) {
            while (i < slen && s.charAt(i) == '_') i++;
            while (j < tlen && t.charAt(j) == '_') j++;

            if (i >= slen && j >= tlen) return true;
            if (i >= slen || j >= tlen) return false;

            if ((s.charAt(i) != t.charAt(j)) || (s.charAt(i) == 'L' && i < j) || (s.charAt(i) == 'R' && i > j)) return false;

            i++;
            j++;
        }

        return true;
    }
}
