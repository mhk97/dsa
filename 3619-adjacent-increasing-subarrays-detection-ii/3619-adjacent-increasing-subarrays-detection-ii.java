class Solution {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), res = Integer.MIN_VALUE;

        int[] prefix = new int[n];
        prefix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) >= nums.get(i + 1)) {
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i + 1] + 1;
            }
        }

        int l = 1, h = n / 2;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (checkIfIncreasing(mid, nums, prefix) == true) {
                res = Math.max(res, mid);
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return res;
    }

    public boolean checkIfIncreasing(int k, List<Integer> nums, int[] prefix) {
        int n = nums.size();

        for (int i = 0; i <= n - (2 * k); i++) {
            if (prefix[i] >= k && prefix[i + k] >= k) return true;
        }

        return false;
    }
}
