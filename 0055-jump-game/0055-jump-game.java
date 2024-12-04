class Solution {

    public boolean canJump(int[] nums) {
        Boolean cache[] = new Boolean[nums.length];
        return solve(nums, 0, cache);
    }

    public boolean solve(int[] nums, int i, Boolean[] cache) {
        if (i >= nums.length-1) return true;

        if(cache[i]!=null) return cache[i];
        
        for (int k = 1; k <= nums[i]; k++) {
            if (solve(nums, i + k, cache) == true)  return cache[i] = true;
        }

        return cache[i] = false;
    }
}
