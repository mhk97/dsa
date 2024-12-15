class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        solve(nums, 0, new HashSet(), new ArrayList());
        return res;
    }

    public void solve(int[] nums, int idx, Set<Integer> seen, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) continue;
            seen.add(nums[i]);
            temp.add(nums[i]);
            solve(nums, i + 1, seen, temp);
            seen.remove(nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
