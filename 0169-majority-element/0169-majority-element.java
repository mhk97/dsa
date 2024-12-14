class Solution {

    public int majorityElement(int[] nums) {
        int streak = 1, curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) streak++; else {
                streak--;
                if (streak == 0) {
                    streak = 1;
                    curr = nums[i];
                }
            }
        }

        return curr;
    }
}
