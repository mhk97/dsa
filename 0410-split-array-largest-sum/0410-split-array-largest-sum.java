class Solution {

    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE, h = 0, res = Integer.MAX_VALUE;

        for (int i : nums) {
            l = Math.max(l, i);
            h += i;
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (canSplit(nums, mid, k) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else l = mid + 1;
        }

        return res;
    }

    public boolean canSplit(int[] nums, int max, int k) {
        int temp = nums[0], cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            temp += nums[i];
            if (temp <= max) continue; else {
                cnt++;
                temp = nums[i];
                if (cnt > k) return false;
            }
        }

        return cnt <= k;
    }
}
