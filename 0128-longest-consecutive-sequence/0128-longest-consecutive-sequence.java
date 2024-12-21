class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i : nums) set.add(i);

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (set.contains(k - 1)) continue;
            int res = 0;
            while (set.contains(k)) {
                res += 1;
                k += 1;
            }

            max = Math.max(max, res);
        }

        return max;
    }
}
