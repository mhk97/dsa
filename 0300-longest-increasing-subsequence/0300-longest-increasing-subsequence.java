class Solution {
    Integer cache[][];

    public int lengthOfLIS(int[] nums) {
        cache = new Integer[nums.length + 1][nums.length + 1];
        return solve(nums, 0, -1);
    }

    public int solve(int[] nums, int i, int lastIndex) {
        if (i >= nums.length) return 0;

        if (cache[i][lastIndex + 1] != null) return cache[i][lastIndex + 1];

        int take = (lastIndex == -1 || (lastIndex < nums.length && nums[i] > nums[lastIndex])) ? 1 + solve(nums, i + 1, i) : Integer.MIN_VALUE;
        int skip = solve(nums, i + 1, lastIndex);

        return cache[i][lastIndex + 1] = Math.max(take, skip);
    }
}
