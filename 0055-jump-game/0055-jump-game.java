class Solution {

    public boolean canJump(int[] nums) {
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxSoFar < i) return false;
            maxSoFar = Math.max(maxSoFar, i + nums[i]);
            if (maxSoFar >= nums.length - 1) return true;
        }

        return true;
    }
}
