class Solution {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i <= n - (k * 2); i++) {
            if (checkIfIncreasing(i, k, nums) && checkIfIncreasing(i + k, k, nums)) return true;
        }

        return false;
    }

    public boolean checkIfIncreasing(int start, int k, List<Integer> nums) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) return false;
        }

        return true;
    }
}
