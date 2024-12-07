class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();

        int i = 0, j = 0, n = s.length(), res = 0;

        while (j < n) {
            char curr = s.charAt(j);
            if (map.containsKey(curr)) {
                i = Math.max(map.get(curr) + 1, i);
            }
            map.put(curr, j);
            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
