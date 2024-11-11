class Solution {

    public boolean canJump(int[] nums) {
        //standing at index where can you reach max == nums[i] + i

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            } else return false;
        }

        return true;
    }
}
