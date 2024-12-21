class Solution {

    public String smallestBeautifulString(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = sb.length() - 1; i >= 0; i--) {
            for (char c = (char) (sb.charAt(i) + 1); c < 'a' + k; c++) {
                if (check(sb, i, c)) {
                    sb.setCharAt(i, c);

                    for (int next = i + 1; next < s.length(); next++) {
                        for (char m = 'a'; m <= 'a' + k; m++) {
                            if (check(sb, next, m)) {
                                sb.setCharAt(next, m);
                                break;
                            }
                        }
                    }

                    return sb.toString();
                }
            }
        }

        return "";
    }

    public boolean check(StringBuilder sb, int i, char c) {
        if (i > 0 && sb.charAt(i - 1) == c) return false;
        if (i > 1 && sb.charAt(i - 2) == c) return false;
        return true;
    }
}
