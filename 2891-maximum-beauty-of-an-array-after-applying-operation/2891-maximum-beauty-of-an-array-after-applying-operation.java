class Solution {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, n = nums.length, res = Integer.MIN_VALUE;

        while (j < n) {
            while (j < n && nums[j] <= (nums[i] + 2 * k)) j++;

            res = Math.max(res, j - i);
            i++;
        }

        return res;
    }
}
