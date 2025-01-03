class Solution {

    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE, total = 0;

        for (int i : nums) {
            max = Math.max(i, max);
            total += i;
        }

        int l = max, h = total, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (possibleSplit(mid, nums, k) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else l = mid + 1;
        }

        return res;
    }

    public boolean possibleSplit(int mid, int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (curr <= mid) continue; else {
                curr = nums[i];
                k--;
                if (k <= 0) return false;
            }
        }

        return true;
    }
}
