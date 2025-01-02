class Solution {

    public int earliestAcq(int[][] logs, int n) {
        //prims

        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap();

        for (int[] i : logs) {
            int u = i[1], v = i[2], cost = i[0];
            map.computeIfAbsent(u, k -> new ArrayList()).add(new Pair(cost, v));
            map.computeIfAbsent(v, k -> new ArrayList()).add(new Pair(cost, u));
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));

        pq.offer(new Pair(-1, 0));

        int res = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            int cost = p.getKey(), u = p.getValue();
            if (visited[u] == false) {
                visited[u] = true;
                res = Math.max(res, cost);
                for (Pair<Integer, Integer> temp : map.getOrDefault(u, new ArrayList<Pair<Integer, Integer>>())) {
                    int vcost = temp.getKey(), v = temp.getValue();
                    if (visited[v] == false) pq.offer(temp);
                }
            }
        }

        for (boolean f : visited) if (f == false) return -1;
        return res;
    }
}
