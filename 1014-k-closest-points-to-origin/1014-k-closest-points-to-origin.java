class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            long res = x * x + y * y;
            pq.offer(new Pair(res, i));

            if (pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair<Long, Integer> pair = pq.poll();
            res[i++] = points[pair.getValue()];
        }

        return res;
    }
}
