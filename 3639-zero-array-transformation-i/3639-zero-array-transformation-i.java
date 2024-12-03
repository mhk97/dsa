class Solution {

    public boolean isZeroArray(int[] nums, int[][] q) {
        int prefix[] = new int[nums.length];
        for (int i[] : q) {
            int l = i[0], r = i[1] + 1;
            prefix[l] += 1;
            if (r < prefix.length) prefix[r] -= 1;
        }

        if (nums[0] - prefix[0] > 0) return false;

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i] + prefix[i - 1];
            if (nums[i] - prefix[i] > 0) return false;
        }

        return true;
    }
}
