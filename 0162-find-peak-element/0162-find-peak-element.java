class Solution {

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int l = 1, h = nums.length - 2;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int mv = nums[mid], prev = nums[mid - 1], next = nums[mid + 1];

            if (mv > next && mv > prev) return mid; else if (mv < next) l = mid + 1; else h = mid - 1;
        }

        return -1;
    }
}
