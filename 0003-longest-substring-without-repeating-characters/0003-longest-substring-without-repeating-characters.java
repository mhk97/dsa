class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        
        int i = 0, j = 0, n = s.length(), res = 0;

        while (j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                res = Math.max(res, j - i + 1);
            } else {
                while (set.contains(c)) {
                    set.remove(s.charAt(i++));
                }

                set.add(c);
            }

            j++;
        }

        return res;
    }
}
