class Solution {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int i = 0, res = 0, n = s.length();

        while (i < n) {
            int first = values.get(String.valueOf(s.charAt(i)));
            int second = (i + 1 < n) ? values.get(String.valueOf(s.charAt(i + 1))) : Integer.MIN_VALUE;

            if (first < second) {
                res += (second - first);
                i += 2;
            } else {
                res += first;
                i += 1;
            }
        }

        return res;
    }
}
