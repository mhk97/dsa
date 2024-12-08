class Solution {

    public int minimumSize(int[] nums, int k) {
        int max = 0;
        for (int i : nums) max = Math.max(max, i);

        int l = 1, h = max, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (isSplitPossible(nums, k, mid) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public boolean isSplitPossible(int[] nums, int k, int no) {
        for (int i : nums) {
            if (i > no) {
                int x = i / no;
                int needed = (i % no == 0) ? x - 1 : x;
                k -= needed;
                if (k < 0) return false;
            }
        }

        return true;
    }
}
