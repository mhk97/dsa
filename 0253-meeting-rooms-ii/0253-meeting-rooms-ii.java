class Solution {

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];

        int k = 0;
        for (int m[] : intervals) {
            start[k] = m[0];
            end[k] = m[1];
            k++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0, res = 0, max = Integer.MIN_VALUE;

        while (i < n && j < n) {
            if (start[i] < end[j]) {
                res++;
                i++;
            } else {
                j++;
                res--;
            }
            max = Math.max(res, max);
        }

        return max;
    }
}
