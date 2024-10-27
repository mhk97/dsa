class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList());
        return res;
    }

    void solve(int[] nums, int i, List<Integer> temp) {
        if (i == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }

        //take
        temp.add(nums[i]);
        solve(nums, i + 1, temp);

        temp.remove(temp.size() - 1);

        //not take
        solve(nums, i + 1, temp);
    }
}
