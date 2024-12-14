class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, count = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j])
                j++;
            else {
                nums[++i] = nums[j++];
                count++;
            }
        }

        return count;
    }
}
