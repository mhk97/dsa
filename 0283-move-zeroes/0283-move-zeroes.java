class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) j++; else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
