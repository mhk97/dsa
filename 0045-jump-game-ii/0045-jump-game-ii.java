class Solution {

    public int jump(int[] nums) {
        int l = 0, r = 0, step = 0, n = nums.length;

        while (r < n - 1) {
            int far = Integer.MIN_VALUE;

            for (int i = l; i <= r; i++) {
                far = Math.max(far, i + nums[i]);
            }
            l = r + 1;
            r = far;
            step++;
        }

        return step;
    }
}
