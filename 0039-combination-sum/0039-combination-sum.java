class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum(int[] c, int t) {
        solve(c, t, 0, new ArrayList());
        return res;
    }

    public void solve(int[] c, int t, int i, List<Integer> list) {
        if (t == 0) {
            res.add(new ArrayList(list));
            return;
        }

        if (t < 0 || i >= c.length) return;

        list.add(c[i]);
        solve(c, t - c[i], i, list); //take
        list.remove(list.size() - 1);

        solve(c, t, i + 1, list); //skip
    }
}
