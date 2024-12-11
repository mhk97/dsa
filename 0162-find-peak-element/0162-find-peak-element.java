class Solution {

    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, h = n - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[mid + 1]) l = mid + 1; else h = mid;
        }

        return l;
    }
}
