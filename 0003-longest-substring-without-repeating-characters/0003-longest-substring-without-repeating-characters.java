class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();

        int i = 0, j = 0, n = s.length(), res = 0;

        while (j < n) {
            char curr = s.charAt(j);
            if (!set.contains(curr)) {
                set.add(curr);
                res = Math.max(res, j - i + 1);
            } else {
                while (set.contains(curr)) {
                    set.remove(s.charAt(i++));
                }

                set.add(curr);
            }
            j++;
        }

        return res;
    }
}
