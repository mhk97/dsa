class Solution {

    public void sortColors(int[] nums) {
        int n = nums.length, t = n - 1, z = 0, curr = 0;

        while (curr <= t) {
            if (nums[curr] == 0) {
                swap(nums, curr, z);
                z++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, t);
                t--;
            } else curr++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
