class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList());
        return res;
    }

    public void solve(int nums[], int i, List<Integer> list) {
        if (i >= nums.length) {
            res.add(new ArrayList(list));
            return;
        }

        list.add(nums[i]);
        solve(nums, i + 1, list);
        list.remove(list.size() - 1);

        solve(nums, i + 1, list);
    }
}
