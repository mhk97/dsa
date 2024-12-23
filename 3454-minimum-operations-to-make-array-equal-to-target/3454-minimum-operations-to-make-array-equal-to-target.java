class Solution {

    public long minimumOperations(int[] nums, int[] target) {
        long res = 0, prev = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = target[i] - nums[i];

            if ((prev > 0 && diff < 0) || (prev < 0 && diff > 0)) {
                res += Math.abs(diff);
            } else if (Math.abs(diff) > Math.abs(prev)) {
                res += Math.abs(diff) - Math.abs(prev);
            }

            prev = diff;
        }

        return res;
    }
}
