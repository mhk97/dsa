class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, h = queries.length, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (makeZero(nums, queries, mid) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else l = mid + 1;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public boolean makeZero(int[] nums, int[][] queries, int mid) {
        int[] prefix = new int[nums.length];

        for (int i = 0; i < mid; i++) {
            int[] q = queries[i];
            int l = q[0], h = q[1] + 1, val = q[2];
            if (h < prefix.length) prefix[h] -= val;
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
