class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < nums.length - 2; i++) {
            int needed = nums[i];

            int j = i + 1, k = nums.length - 1, sum = 0;
            while (j < k) {
                sum = nums[j] + nums[k] + needed;
                if (sum > 0) k--; else if (sum < 0) j++; else {
                    res.add(List.of(needed, nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }

            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
        }

        return res;
    }
}
