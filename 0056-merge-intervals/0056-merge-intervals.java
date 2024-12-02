class Solution {

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> l1 = new LinkedList();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        l1.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int lastEnd = l1.getLast()[1];
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            if (lastEnd >= currStart) {
                l1.getLast()[1] = Math.max(currEnd, lastEnd);
            } else l1.add(intervals[i]);
        }

        return l1.toArray(new int[l1.size()][]);
    }
}
