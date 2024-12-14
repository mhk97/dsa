class Solution {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : gifts) pq.offer((long) i);
        while (k > 0) {
            if (!pq.isEmpty()) {
                long temp = pq.poll();
                pq.add((long) Math.sqrt(temp));
                k--;
            }
        }

        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        return res;
    }
}
