class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> list = new LinkedList();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (list.getLast()[1] >= intervals[i][0]) {
                list.getLast()[1] = Math.max(intervals[i][1], list.getLast()[1]);
            }else{
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
