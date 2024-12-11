class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 0, i = 0;
        long sum = 0;

        for (int j = 0; j < nums.length; j++) {
            long target = nums[j];
            sum += target;

            while (target * (j - i + 1) - sum > k) {
                sum -= nums[i++];
            }

            res = Math.max(j - i + 1, res);
        }

        return res;
    }
}
