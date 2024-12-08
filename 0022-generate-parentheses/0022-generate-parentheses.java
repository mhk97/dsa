class Solution {
    List<String> res = new ArrayList();

    public List<String> generateParenthesis(int n) {
        solve(new StringBuilder(), n, n);
        return res;
    }

    public void solve(StringBuilder sb, int o, int c) {
        if (o == 0 && c == 0) {
            res.add(sb.toString());
        }

        if (o != 0) {
            sb.append('(');
            solve(sb, o - 1, c);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (o < c) {
            sb.append(')');
            solve(sb, o, c - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
