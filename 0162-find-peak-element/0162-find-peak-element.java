class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int l = 1, h = nums.length - 2;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int p = nums[mid - 1], n = nums[mid + 1], mv = nums[mid];
            if (mv > p && mv > n) return mid; else if (mv < p && mv < n) l = mid + 1; else if (mv > p && mv < n) l = mid + 1; else h = mid - 1;
        }

        return -1;
    }
}
