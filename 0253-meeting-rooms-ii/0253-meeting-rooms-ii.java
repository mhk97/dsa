class Solution {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0], currEnd = intervals[i][1];
            if (!pq.isEmpty() && pq.peek() <= currStart) pq.poll();
            pq.offer(currEnd);
        }

        return pq.size();
    }
}
