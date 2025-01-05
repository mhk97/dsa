class Solution {

    public int[][] insert(int[][] intervals, int[] ni) {
        List<int[]> res = new ArrayList();

        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            int curr[] = intervals[i];

            if (curr[1] < ni[0]) { //curr end < new interval start
                res.add(curr);
            } else if (curr[0] > ni[1]) {
                // curr start > new interval end
                break;
            } else {
                //merge
                ni[0] = Math.min(ni[0], curr[0]);
                ni[1] = Math.max(ni[1], curr[1]);
            }
        }

        res.add(ni);

        while (i < intervals.length) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
