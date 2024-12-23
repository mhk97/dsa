class Solution {

    public int searchInsert(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] >= k) {
                h = mid - 1;
            } else l = mid + 1;
        }

        return l;
    }
}
