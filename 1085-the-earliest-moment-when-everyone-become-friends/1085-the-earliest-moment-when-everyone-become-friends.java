class Solution {

    public int earliestAcq(int[][] logs, int n) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap();

        for (int edge[] : logs) {
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            map.computeIfAbsent(u, k -> new ArrayList()).add(new Pair(v, cost));
            map.computeIfAbsent(v, k -> new ArrayList()).add(new Pair(u, cost));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        boolean visited[] = new boolean[n];

        int res = Integer.MIN_VALUE;

        pq.offer(new int[] { 0, 0, -1 });

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            int cost = curr[0], v = curr[1], u = curr[0];

            if (visited[v] == false) {
                visited[v] = true;
                res = Math.max(cost, res);

                for (Pair<Integer, Integer> pair : map.getOrDefault(v, new ArrayList<>())) {
                    int next = pair.getKey();
                    if (visited[next] == false) {
                        pq.offer(new int[] { pair.getValue(), next, v });
                    }
                }
            }
        }

        boolean flag = true;

        for (boolean i : visited) if (i == false) flag = false;

        return (flag) ? res : -1;
    }
}
