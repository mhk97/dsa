class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, target, new ArrayList(), 0);
        return res;
    }

    public void solve(int[] candidates, int target, List<Integer> temp, int i) {
        if (i >= candidates.length) {
            if (target == 0) {
                res.add(new ArrayList(temp));
            }
            return;
        }

        //take
        if (candidates[i] <= target) {
            temp.add(candidates[i]);
            solve(candidates, target - candidates[i], temp, i);
            //backtrack
            temp.remove(temp.size() - 1);
        }

        //not take
        solve(candidates, target, temp, i + 1);
    }
}
