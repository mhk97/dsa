class Solution {

    public int minZeroArray(int[] nums, int[][] q) {
        int l = 0, h = q.length, min = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            boolean res = check(nums, q, mid);
            if (res == true) {
                min = Math.min(min, mid);
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public boolean check(int nums[], int[][] q, int index) {
        int[] prefix = new int[nums.length];

        for (int k = 0; k < index; k++) {
            int[] i = q[k];
            int l = i[0], r = i[1] + 1;
            prefix[l] += i[2];
            if (r < prefix.length) prefix[r] -= i[2];
        }

        if (nums[0] - prefix[0] > 0) return false;

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i] + prefix[i - 1];
            if (nums[i] - prefix[i] > 0) return false;
        }

        return true;
    }
}
