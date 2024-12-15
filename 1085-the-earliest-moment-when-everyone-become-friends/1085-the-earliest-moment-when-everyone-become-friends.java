class Solution {

    public int earliestAcq(int[][] logs, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, List<int[]>> map = new HashMap();

        for (int[] edge : logs) {
            int cost = edge[0], u = edge[1], v = edge[2];
            map.computeIfAbsent(u, k -> new ArrayList()).add(new int[] { cost, v });
            map.computeIfAbsent(v, k -> new ArrayList()).add(new int[] { cost, u });
        }

        boolean visited[] = new boolean[n];

        pq.add(new int[] { -1, 0 });
        int res = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int cost = curr[0], u = curr[1];

            if (visited[u] == false) {
                visited[u] = true;
                res = Math.max(res, cost);
                for (int v[] : map.getOrDefault(u, new ArrayList<int[]>())) {
                    int newCost = v[0];
                    int nextNode = v[1];
                    if (visited[nextNode] == false) {
                        pq.add(v);
                    }
                }
            }
        }

        for (boolean a : visited) {
            if (a == false) return -1;
        }

        return res;
    }
}
