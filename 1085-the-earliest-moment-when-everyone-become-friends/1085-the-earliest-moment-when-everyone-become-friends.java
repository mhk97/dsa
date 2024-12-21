class Solution {

    public int earliestAcq(int[][] logs, int n) {
        Map<Integer, List<int[]>> map = new HashMap();

        for (int i[] : logs) {
            int u = i[1], v = i[2], val = i[0];
            map.computeIfAbsent(u, k -> new ArrayList()).add(new int[] { val, v });
            map.computeIfAbsent(v, k -> new ArrayList()).add(new int[] { val, u });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[] { -1, 0 });

        int res = Integer.MIN_VALUE;
        boolean visited[] = new boolean[n];

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[1], cost = temp[0];
            if (visited[node] == false) {
                res = Math.max(res, cost);
                visited[node] = true;
                for (int v[] : map.getOrDefault(node, new ArrayList<int[]>())) {
                    if (visited[v[1]] == false) {
                        pq.add(v);
                    }
                }
            }
        }

        for(boolean flag: visited) if(flag == false) return -1;

        return res;
    }
}
