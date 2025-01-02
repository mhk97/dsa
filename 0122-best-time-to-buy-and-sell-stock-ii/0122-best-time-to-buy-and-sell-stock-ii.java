class Solution {
    Integer cache[][];

    public int maxProfit(int[] prices) {
        cache = new Integer[prices.length + 1][2];
        return solve(prices, 0, 1);
    }

    public int solve(int[] nums, int ind, int buy) {
        if (ind >= nums.length) return 0;
        if (cache[ind][buy] != null) return cache[ind][buy];
        int profit = 0;

        if (buy == 1) {
            profit = Math.max(-nums[ind] + solve(nums, ind + 1, 0), 0 + solve(nums, ind + 1, 1));
        } else {
            profit = Math.max(nums[ind] + solve(nums, ind + 1, 1), 0 + solve(nums, ind + 1, 0));
        }

        return cache[ind][buy] = profit;
    }
}
