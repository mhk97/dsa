class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0, j = 0, n = nums.length, res = 0;
        long sum = 0, expected = 0, temp = 0;

        while (j < n) {
            temp = nums[j];
            sum += nums[j];

            while (((j - i + 1) * temp) - sum > k) {
                sum -= nums[i++];
            }

            res = Math.max(res, j - i + 1);

            j++;
        }

        return res;
    }
}
