class Solution {

    //kadanes
    public int maxSubArray(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            res = Math.max(res, sum);
        }

        return res;
    }
}
