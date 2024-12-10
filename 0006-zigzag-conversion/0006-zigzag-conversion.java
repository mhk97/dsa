class Solution {

    public String convert(String s, int n) {
        if (n == 1) return s;

        StringBuilder sb = new StringBuilder();
        int diff = (n - 1) * 2;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < s.length(); j += diff) {
                sb.append(s.charAt(j));
                if (i > 0 && i < n - 1 && (j + diff - 2 * i) < s.length()) sb.append(s.charAt(j + diff - 2 * i));
            }
        }

        return sb.toString();
    }
}
