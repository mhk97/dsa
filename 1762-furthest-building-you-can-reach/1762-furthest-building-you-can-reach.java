class Solution {

    public int furthestBuilding(int[] h, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < h.length - 1; i++) {
            int needed = h[i + 1] - h[i];

            if (needed <= 0) continue;

            pq.add(needed);
            bricks -= needed;

            if (bricks < 0 && ladders == 0) return i;

            if (bricks < 0) {
                bricks += pq.poll();
                ladders--;
            }
        }

        return h.length - 1;
    }
}
