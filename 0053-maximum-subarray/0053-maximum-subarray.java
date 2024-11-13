class Solution {

    public int maxSubArray(int[] nums) {
        int res = nums[0], currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currSum < 0) currSum = 0;
            currSum += nums[i];
            res = Math.max(res, currSum);
        }

        return res;
    }
}
