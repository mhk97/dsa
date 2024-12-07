class Solution {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int prefix[] = new int[n];

        prefix[n- 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) >= nums.get(i + 1)) {
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i + 1] + 1;
            }
        }

        for (int i = 0; i <= n - (k * 2); i++) {
            if (prefix[i] >= k && prefix[i + k] >= k) return true;
        }

        return false;
    }
}
