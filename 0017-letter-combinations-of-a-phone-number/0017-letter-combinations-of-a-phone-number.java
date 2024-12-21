class Solution {
    List<String> res = new ArrayList();
    Map<Integer, String> map = new HashMap();

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return res;

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        solve(digits, 0, new StringBuilder());
        return res;
    }

    public void solve(String digits, int idx, StringBuilder sb) {
        if (idx >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(idx) - '0');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            solve(digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
