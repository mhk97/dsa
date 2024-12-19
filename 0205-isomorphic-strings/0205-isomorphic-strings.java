class Solution {

    public boolean isIsomorphic(String s, String t) {
        int sarr[] = new int[256];
        int tarr[] = new int[256];

        Arrays.fill(sarr, -1);
        Arrays.fill(tarr, -1);

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if (sarr[schar] == -1 && tarr[tchar] == -1) {
                sarr[schar] = tchar;
                tarr[tchar] = schar;
            }

            if (sarr[schar] != tchar || tarr[tchar] != schar) return false;
        }

        return true;
    }
}
