class Solution {

    public boolean isZeroArray(int[] nums, int[][] q) {
        int prefix[] = new int[nums.length];

        for (int k[] : q) {
            int l = k[0], h = k[1] + 1;
            if (h < nums.length) prefix[h]--;
            prefix[l]++;
        }

        if (nums[0] - prefix[0] > 0) return false;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i] + prefix[i - 1];
            if (nums[i] - prefix[i] > 0) return false;
        }

        return true;
    }
}
