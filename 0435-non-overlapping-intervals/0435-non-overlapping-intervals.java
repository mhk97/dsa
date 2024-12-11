class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int res = 0, k = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= k) {
                res++;
                k = curr[1];
            }
        }

        return intervals.length - res;
    }
}
