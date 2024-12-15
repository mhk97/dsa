class Solution {

    public int[] findLps(String p) {
        int[] lps = new int[p.length()];
        int i = 1, n = p.length(), len = 0;
        lps[0] = 0;

        while (i < n) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1]; else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public int strStr(String a, String b) {
        // System.out.println(Arrays.toString(findLps(b)));
        int[] lps = findLps(b);

        int i = 0, j = 0, m = b.length(), n = a.length();

        while (i < n) {
            if (j < m && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }

            if (j >= m) return i - j; else if (i < n && (j == 0 || a.charAt(i) != b.charAt(j))) {
                if (j != 0) j = lps[j - 1]; else i++;
            }
        }

        return -1;
    }
}
