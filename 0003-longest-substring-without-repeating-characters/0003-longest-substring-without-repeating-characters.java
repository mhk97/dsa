class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();

        int i = 0, j = 0, n = s.length(), res = 0;

        while (j < n) {
            char curr = s.charAt(j);
            if (!set.contains(curr)) {
                set.add(curr);
                res = Math.max(set.size(), res);
            } else {
                while (set.contains(curr)) {
                    char temp = s.charAt(i++);
                    set.remove(temp);
                }

                set.add(curr);
            }
            j++;
        }

        return res;
    }
}
