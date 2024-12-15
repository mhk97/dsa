class Solution {

    public int[] searchRange(int[] nums, int target) {
        int lb = findLB(nums, target), ub = findUB(nums, target), ubb = (ub == -1) ? -1 : ub;
        return new int[] { lb, ubb };
    }

    public int findLB(int[] nums, int k) {
        int l = 0, h = nums.length - 1, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == k) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else {
                if (nums[mid] < k) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int findUB(int[] nums, int k) {
        int l = 0, h = nums.length - 1, res = Integer.MIN_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == k) {
                res = Math.max(res, mid);
                l = mid + 1;
            } else {
                if (nums[mid] < k) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }
}