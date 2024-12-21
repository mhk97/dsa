class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet();

            for (int j = i + 1; j < nums.length; j++) {
                if (i == j) continue;
                int needed = 0 - (nums[i] + nums[j]);
                if (set.contains(needed)) {
                    List<Integer> res1 = Arrays.asList(nums[i], nums[j], needed);
                    Collections.sort(res1);
                    res.add(res1);
                }
                set.add(nums[j]);
            }
        }

        return new ArrayList(res);
    }
}
