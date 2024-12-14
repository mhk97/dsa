class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> generate(int n) {
        solve(n, new ArrayList(), 1);
        return res;
    }

    public void solve(int n, List<Integer> prev, int ind) {
        if (ind == n+1) return;

        List<Integer> curr = new ArrayList();
        curr.add(1);

        for (int i = 0; i < prev.size() - 1; i++) {
            curr.add(prev.get(i) + prev.get(i + 1));
        }

        if (ind != 1) curr.add(1);

        res.add(curr);
        solve(n, curr, ind + 1);
    }
}
