class Solution {

    public boolean canJump(int[] nums) {
        //standing at index where can you reach max == nums[i] + i

        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (i <= max) {
        //         max = Math.max(max, i + nums[i]);
        //     } else return false;
        // }

        // return true;

        // Boolean[] cache = new Boolean[nums.length + 1];
        // return solve(nums, 0, cache);

        boolean dp[] = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int m = 1; m <= nums[i]; m++) {
                if (i + m < nums.length && dp[i + m] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    private boolean solve(int[] nums, int i, Boolean[] cache) {
        if (i >= nums.length - 1) return true;
        if (cache[i] != null) return cache[i];
        for (int m = 1; m <= nums[i]; m++) {
            if (solve(nums, i + m, cache) == true) return cache[i] = true;
        }

        return cache[i] = false;
    }
}
