class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        // int max = Integer.MIN_VALUE;

        // for (int i = 1; i <= nums.length; i++) {
        //     rotateArray(nums, 1);
        //     max = Math.max(kadanesMax(nums), max);
        // }

        int sum = 0;
        for (int i : nums) sum += i;

        int max = kadanesMax(nums);
        int min = kadanesMin(nums);

        if (max > 0) return Math.max(max, sum - min);

        return max;
    }

    public void rotateArray(int nums[], int k) {
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    public void reverseArray(int nums[], int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int kadanesMax(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i];
            res = Math.max(sum, res);
        }
        return res;
    }

    public int kadanesMin(int[] nums) {
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) sum = 0;
            sum += nums[i];
            res = Math.min(sum, res);
        }
        return res;
    }
}
