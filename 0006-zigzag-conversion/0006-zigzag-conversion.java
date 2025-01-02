class Solution {

    public static String convert(String s, int n) {
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder();
        int diff = (n - 1) * 2;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < s.length(); j += diff) {
                sb.append(s.charAt(j));
                int k = (j + diff) - (2 * i);
                if (i > 0 && i < n - 1 && k < s.length()) {
                    sb.append(s.charAt(k));
                }
            }
        }

        return sb.toString();
    }
}
