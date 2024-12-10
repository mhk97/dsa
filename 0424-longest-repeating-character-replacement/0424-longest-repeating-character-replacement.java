class Solution {

    public int characterReplacement(String s, int k) {
        int n = s.length(), i = 0, j = 0, max = 0, res = 0;

        Map<Character, Integer> map = new HashMap();

        while (j < n) {
            char temp = s.charAt(j);

            int f = map.getOrDefault(temp, 0) + 1;
            map.put(temp, f);
            max = Math.max(max, f);

            if ((j - i + 1 - max) <= k) {
                res = Math.max(res, j - i + 1);
            }

            while ((j - i + 1 - max) > k) {
                char it = s.charAt(i++);
                int fi = map.getOrDefault(it, 0) - 1;
                if (fi <= 0) map.remove(it);
                map.put(it, fi);
                max = findMax(map);
            }

            j++;
        }
        return res;
    }

    public int findMax(Map<Character, Integer> map) {
        int res = 0;
        for (int i : map.values()) res = Math.max(i, res);
        return res;
    }
}
