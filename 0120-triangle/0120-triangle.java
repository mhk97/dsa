class Solution {

    public int minimumTotal(List<List<Integer>> t) {
        int row = t.size();

        List<Integer> last = t.get(row - 1);

        for (int i = row - 2; i >= 0; i--) {
            List<Integer> curr = t.get(i);
            List<Integer> temp = new ArrayList();
            for (int j = 0; j < curr.size(); j++) {
                int min = Math.min(last.get(j), last.get(j + 1));
                temp.add(min + curr.get(j));
            }
            last = temp;
        }

        return last.get(0);
    }
}
