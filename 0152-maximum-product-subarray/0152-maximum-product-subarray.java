class Solution {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;

        int prefix = 1, suffix = 1, n = nums.length;

        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            res = Math.max(Math.max(prefix, suffix), res);
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
        }

        return res;
    }
}
