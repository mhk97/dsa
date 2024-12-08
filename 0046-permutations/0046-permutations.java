class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        solve(new ArrayList(), nums, new HashSet());
        return res;
    }

    public void solve(List<Integer> temp, int nums[], HashSet<Integer> seen) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int k = 0; k < nums.length; k++) {
            if (seen.contains(nums[k])) continue;

            temp.add(nums[k]);
            seen.add(nums[k]);

            solve(temp, nums, seen);

            temp.remove(temp.size() - 1);
            seen.remove(nums[k]);
        }
    }
}
