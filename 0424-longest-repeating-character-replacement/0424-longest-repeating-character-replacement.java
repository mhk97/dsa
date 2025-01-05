class Solution {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap();

        int i = 0, j = 0, n = s.length(), res = 0;

        while (j < n) {
            char curr = s.charAt(j);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            if (j - i + 1 - findMax(map) <= k) {
                res = Math.max(res, j - i + 1);
            } else {
                while ((j - i + 1) - findMax(map) > k) {
                    char icurr = s.charAt(i++);
                    map.put(icurr, map.getOrDefault(icurr, 0) - 1);
                }
            }

            j++;
        }

        return res;
    }

    public int findMax(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }

        return max;
    }
}
