class Solution {

    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1, n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] == res) count++; else {
                count--;
                if (count < 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }

        return res;
    }
}
