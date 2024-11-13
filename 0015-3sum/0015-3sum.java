class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp = new HashSet();

            for (int j = i + 1; j < nums.length; j++) {
                int needed = 0 - (nums[i] + nums[j]);
                if (temp.contains(needed)) {
                    List<Integer> resTemp = Arrays.asList(nums[i], nums[j], needed);
                    Collections.sort(resTemp);
                    set.add(resTemp);
                }

                temp.add(nums[j]);
            }
        }

        return new ArrayList(set);
    }
}
