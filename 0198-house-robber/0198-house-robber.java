class Solution {

    Integer cache[];
    public int rob(int[] nums) {
        cache = new Integer[nums.length];
        return solve(nums, 0);
    }

    public int solve(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if(cache[i]!=null) return cache[i];

        int take = nums[i] + solve(nums, i + 2);
        int skip = 0 + solve(nums, i + 1);

        return cache[i]= Math.max(take, skip);
    }
}
