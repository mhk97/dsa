class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int targetSum = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[j] + nums[k];

                if (sum < targetSum) {
                    j++;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return res;
    }
}