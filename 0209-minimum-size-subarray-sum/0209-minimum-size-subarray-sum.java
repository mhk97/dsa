class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, n = nums.length, res = Integer.MAX_VALUE, sum = 0;

        while (j < n) {
            sum += nums[j];

            while (sum >= target) {
                if (sum >= target) res = Math.min(j - i + 1, res);
                sum -= nums[i++];
            }

            j++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
