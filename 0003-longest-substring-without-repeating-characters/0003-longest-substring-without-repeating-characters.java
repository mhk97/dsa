class Solution {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, res = 0, n = s.length();

        HashSet<Character> set = new HashSet();

        while (j < n) {
            char curr = s.charAt(j);
            if (!set.contains(curr)) {
                set.add(curr);
                res = Math.max(res, j - i + 1);
            } else {
                while (i<=j && set.contains(curr)) {
                    char icurr = s.charAt(i++);
                    set.remove(icurr);
                }
                set.add(curr);
            }
            j++;
        }

        return res;
    }
}
