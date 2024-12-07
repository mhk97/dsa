class Solution {

    public int rob(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        return solve(nums, 0, cache);
    }

    public int solve(int[] nums, int i, Integer[] cache) {
        if (i >= nums.length) return 0;

        if (cache[i] != null) return cache[i];

        int take = nums[i] + solve(nums, i + 2, cache);
        int skip = 0 + solve(nums, i + 1, cache);

        return cache[i] = Math.max(take, skip);
    }
}
