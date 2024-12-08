class Solution {

    public void sortColors(int[] nums) {
        int z = 0, t = nums.length - 1, i = 0;

        while (i <= t) {
            if (nums[i] == 1) i++; else if (nums[i] == 0) {
                swap(nums, i, z);
                i++;
                z++;
            } else {
                swap(nums, i, t);
                t--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
