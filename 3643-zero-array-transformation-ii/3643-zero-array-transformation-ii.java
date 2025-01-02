class Solution {

    public int minZeroArray(int[] nums, int[][] q) {
        int l = 0, h = q.length, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (canMakeZero(nums, q, mid) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else l = mid + 1;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public boolean canMakeZero(int nums[], int[][] q, int mid) {
        int prefix[] = new int[nums.length];

        for (int i = 0; i < mid; i++) {
            int[] curr = q[i];
            int l = curr[0], h = curr[1] + 1, val = curr[2];
            if (h < nums.length) prefix[h] -= val;
            prefix[l] += val;
        }

        if (nums[0] - prefix[0] > 0) return false;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i] + prefix[i - 1];
            if (nums[i] - prefix[i] > 0) return false;
        }

        return true;
    }
}
