class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1, cnt = 0;

        while (i <= j) {
            if (nums[j] == val) {
                j--;
                cnt++;
            } else if (nums[i] != val) {
                i++;
            } else {
                swap(nums, i, j);
                i++;
                j--;
                cnt++;
            }
        }

        // System.out.println(Arrays.toString(nums));

        return nums.length - cnt;
    }

    public void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
}
