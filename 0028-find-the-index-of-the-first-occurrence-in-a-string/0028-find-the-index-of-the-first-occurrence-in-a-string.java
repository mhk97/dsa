class Solution {

    public int[] lps(String p) {
        int n = p.length(), i = 1, len = 0;
        int[] lps = new int[n];

        lps[0] = 0;

        while (i < n) {
            if (p.charAt(len) == p.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public int strStr(String s, String p) {
        int lps[] = lps(p);
        System.out.println(Arrays.toString(lps(p)));

        int i = 0, j = 0, slen = s.length(), plen = p.length();

        while (i < slen) {
            if (j < plen && s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }

            if (j >= plen) return i - j; else if (i < slen && (s.charAt(i) != p.charAt(j))) {
                if (j > 0) j = lps[j - 1]; else i++;
            }
        }

        return -1;
    }
}
