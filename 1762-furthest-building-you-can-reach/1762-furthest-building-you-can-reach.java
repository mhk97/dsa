class Solution {

    public int furthestBuilding(int[] h, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for (i = 0; i < h.length - 1; i++) {
            int bricksNeeded = h[i + 1] - h[i];

            if (bricksNeeded <= 0) continue;

            pq.add(bricksNeeded);
            bricks -= bricksNeeded;

            if (bricks < 0 && ladders == 0) return i;

            if (bricks < 0) {
                bricks += pq.poll();
                ladders--;
            }
        }

        return h.length - 1;
    }
}
