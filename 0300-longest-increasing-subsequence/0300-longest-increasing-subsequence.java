class Solution {
    Integer cache[][];

    public int lengthOfLIS(int[] nums) {
        cache = new Integer[nums.length + 1][nums.length + 1];
        return solve(nums, 0, -1);
    }

    public int solve(int nums[], int ind, int prevInd) {
        if (ind >= nums.length) return 0;

        if (cache[ind][prevInd + 1] != null) return cache[ind][prevInd + 1];

        int take = (prevInd == -1 || nums[prevInd] < nums[ind]) ? 1 + solve(nums, ind + 1, ind) : Integer.MIN_VALUE;

        int skip = solve(nums, ind + 1, prevInd);

        return cache[ind][prevInd + 1] = Math.max(take, skip);
    }
}
