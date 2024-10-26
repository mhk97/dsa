class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        solve(nums, new ArrayList(), 0, new HashSet());
        return res;
    }

    public void solve(int nums[], List<Integer> temp, int index, Set<Integer> set) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;

            temp.add(nums[i]);
            set.add(nums[i]);

            solve(nums, temp, i + 1, set);

            temp.remove(temp.size() - 1);
            set.remove(nums[i]);
        }
    }
}
