class Solution {

    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap();

        int n = s.length(), res = -1;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (sb.isEmpty() || sb.charAt(sb.length() - 1) == s.charAt(j)) {
                    sb.append(s.charAt(j));
                    String key = sb.toString();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                } else {
                    break;
                }
            }
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() >= 3 && e.getKey().length() > res) {
                res = e.getKey().length();
            }
        }

        return res;
    }
}
