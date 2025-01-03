class Solution {

    public String smallestBeautifulString(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char curr = (char) (s.charAt(i) + 1);
            boolean flag = false;
            for (char next = curr; next < 'a' + k; next++) {
                if (valid(next, i, sb) == true) {
                    sb.setCharAt(i, next);
                    for (int j = i + 1; j < s.length(); j++) {
                        for (char newc = 'a'; newc < 'a' + k; newc++) {
                            if (valid(newc, j, sb) == true) {
                                sb.setCharAt(j, newc);
                                break;
                            }
                        }
                    }
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        return sb.toString().equals(s) ? "" : sb.toString();
    }

    public boolean valid(char newc, int i, StringBuilder sb) {
        if ((i > 0 && sb.charAt(i - 1) == newc) || (i > 1 && sb.charAt(i - 2) == newc)) {
            return false;
        }

        return true;
    }
}
