class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList());
        return res;
    }

    public void solve(int nums[], int ind, List<Integer> temp) {
        res.add(new ArrayList(temp));

        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            solve(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
