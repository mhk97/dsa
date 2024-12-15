class Solution {
    List<String> res = new ArrayList();
    Map<Integer, String> map = new HashMap();

    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0) return res;

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

    public void solve(String d, int i, StringBuilder sb) {
        if (i >= d.length()) {
            res.add(sb.toString());
            return;
        }

        String curr = map.get(d.charAt(i)-'0');

        for (int k = 0; k < curr.length(); k++) {
            sb.append(curr.charAt(k));
            solve(d, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
