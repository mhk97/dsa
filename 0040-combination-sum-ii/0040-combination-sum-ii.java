class Solution {
    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList());
        return res;
    }

    public void solve(int[] arr, int target, int index, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            temp.add(arr[i]);
            solve(arr, target - arr[i], i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
