class Solution {

    public int numberOfPoints(List<List<Integer>> nums) {
        LinkedList<int[]> ll = new LinkedList();

        Collections.sort(nums, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        ll.add(new int[] { nums.get(0).get(0), nums.get(0).get(1) });

        for (int i = 1; i < nums.size(); i++) {
            int currStart = nums.get(i).get(0), currEnd = nums.get(i).get(1);
            if (ll.getLast()[1] >= currStart) {
                ll.getLast()[1] = Math.max(ll.getLast()[1], currEnd);
            } else {
                ll.add(new int[] { nums.get(i).get(0), nums.get(i).get(1) });
            }
        }

        int res = 0;

        for (int[] i : ll) {
            res += i[1] - i[0] + 1;
        }

        return res;
    }
}
