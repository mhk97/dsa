class Solution {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), res = 1;
        int prefix[] = new int[n];

        prefix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) >= nums.get(i + 1)) {
                prefix[i] = 1;
            } else prefix[i] = prefix[i + 1] + 1;
        }

        int l = 1, h = n / 2;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (strictlyIncreasing(prefix, mid) == true) {
                res = Math.max(res, mid);
                l = mid + 1;
            }
            else h = mid - 1;
        }

        return res;
    }

    public boolean strictlyIncreasing(int[] prefix, int k) {
        for (int i = 0; i <= prefix.length - 2 * k; i++) {
            if (prefix[i] >= k && prefix[i + k] >= k) return true;
        }

        return false;
    }
}
