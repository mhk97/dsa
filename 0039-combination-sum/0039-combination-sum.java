class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(new ArrayList(), candidates, target, 0);
        return res;
    }

    public void solve(List<Integer> list, int[] c, int k, int idx) {
        if (k == 0) {
            res.add(new ArrayList(list));
            return;
        }

        if (idx >= c.length || k < 0) return;

        list.add(c[idx]);
        solve(list, c, k - c[idx], idx);
        list.remove(list.size() - 1);

        solve(list, c, k, idx + 1);
    }
}
