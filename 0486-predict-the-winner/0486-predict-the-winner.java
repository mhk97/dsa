class Solution {

    public boolean predictTheWinner(int[] nums) {
        Integer cache[][] = new Integer[nums.length][nums.length];
        int k = solve(nums, 0, nums.length - 1, cache);
        return k >= 0;
    }

    public int solve(int[] nums, int i, int j, Integer cache[][]) {
        if (i == j) return nums[i];

        if (cache[i][j] != null) return cache[i][j];
        int take_i = nums[i] - solve(nums, i + 1, j, cache);
        int take_j = nums[j] - solve(nums, i, j - 1, cache);

        return cache[i][j] = Math.max(take_i, take_j);
    }
}
