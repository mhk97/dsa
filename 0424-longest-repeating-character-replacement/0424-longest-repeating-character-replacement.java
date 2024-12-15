class Solution {

    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, res = 0, max = 0, n = s.length();
        Map<Character, Integer> map = new HashMap();

        while (j < n) {
            char curr = s.charAt(j);

            int count = map.getOrDefault(curr, 0) + 1;
            map.put(curr, count);

            max = Math.max(max, count);

            if (j - i + 1 - max <= k) {
                res = Math.max(res, j - i + 1);
            } else {
                while (j - i + 1 - max > k) {
                    char icurr = s.charAt(i++);
                    int icount = map.getOrDefault(icurr, 0) - 1;
                    if (icount <= 0) map.remove(icurr); else map.put(icurr, icount);
                    max = findMax(map);
                }
            }

            j++;
        }

        return res;
    }

    public int findMax(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int i : map.values()) max = Math.max(i, max);
        return max;
    }
}
