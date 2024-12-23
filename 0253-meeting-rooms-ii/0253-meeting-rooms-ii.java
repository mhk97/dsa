class Solution {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];

            if (!pq.isEmpty() && pq.peek() <= start) pq.poll();

            pq.offer(end);
        }

        return pq.size();
    }
}
