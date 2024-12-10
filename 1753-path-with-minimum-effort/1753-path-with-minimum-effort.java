class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int minimumEffortPath(int[][] h) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int r = h.length, c = h[0].length;
        int[][] cost = new int[r][c];

        for (int i[] : cost) Arrays.fill(i, Integer.MAX_VALUE);

        q.offer(new int[] { 0, 0, 0 });
        cost[0][0] = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int costSoFar = temp[0], i = temp[1], j = temp[2];

            for (int d[] : dirs) {
                int nr = i + d[0], nc = j + d[1];
                if (nr < r && nr >= 0 && nc < c && nc >= 0) {
                    int newCost = Math.max(Math.abs(h[i][j] - h[nr][nc]), costSoFar);
                    if (cost[nr][nc] > newCost) {
                        cost[nr][nc] = newCost;
                        q.offer(new int[] { newCost, nr, nc });
                    }
                }
            }
        }

        return cost[r-1][c-1];
    }
}
