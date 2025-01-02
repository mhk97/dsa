class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i : nums) set.add(i);

        int max = 0;

        for (int k : set) {
            if (!set.contains(k - 1)) {
                int res = 0;
                while (set.contains(k)) {
                    res += 1;
                    k += 1;
                }

                max = Math.max(max, res);
            }
        }

        return max;
    }
}
