class Solution {

    public void sortColors(int[] nums) {
        int z = 0, t = nums.length - 1;

        for (int i = 0; i < nums.length && i<=t;) {
            int curr = nums[i];

            if (curr == 0) {
                swap(z, i, nums);
                i++;
                z++;
            } else if (curr == 1) {
                i++;
            } else {
                swap(t, i, nums);
                t--;
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
