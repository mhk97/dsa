class Solution {
    Boolean cache[];

    public boolean canJump(int[] nums) {
        cache = new Boolean[nums.length + 1];
        return solve(nums, 0);
    }

    public boolean solve(int[] nums, int ind) {
        if (ind >= nums.length - 1) return true;
        if (cache[ind] != null) return cache[ind];

        for (int i = 1; i <= nums[ind]; i++) {
            if (solve(nums, ind + i) == true) return cache[ind] = true;
        }

        return cache[ind] = false;
    }
}
