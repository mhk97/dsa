class Solution {

    public int[] searchRange(int[] nums, int target) {
        int lb = findlowerbound(nums, target);
        int ub = findupperbound(nums, target);

        return new int[] { lb, ub };
    }

    public int findlowerbound(int[] nums, int target) {
        int l = 0, h = nums.length - 1, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else if (nums[mid] < target) l = mid + 1; else h = mid - 1;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int findupperbound(int[] nums, int target) {
        int l = 0, h = nums.length - 1, res = Integer.MIN_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                res = Math.max(res, mid);
                l = mid + 1;
            } else if (nums[mid] < target) l = mid + 1; else h = mid - 1;
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
