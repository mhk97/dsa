class Solution {

    public boolean isZeroArray(int[] nums, int[][] q) {
        int[] prefix = new int[nums.length];
        for (int i[] : q) {
            int l = i[0], r = i[1] + 1;
            prefix[l]++;
            if (r < nums.length) prefix[r]--;
        }

        if (nums[0] > prefix[0]) return false;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i] + prefix[i - 1];
            if (prefix[i] < nums[i]) return false;
        }

        return true;
    }
}
