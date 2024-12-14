class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int indegree[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap();
        for (int edge[] : relations) {
            int u = edge[0] - 1, v = edge[1] - 1;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList();
        int max[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                max[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
                    int cost = max[u] + time[v];
                    max[v] = Math.max(cost, max[v]);
                    indegree[v]--;
                    if (indegree[v] == 0) q.add(v);
                }
            }
        }

        int res = 0;
        for (int i : max) res = Math.max(i, res);
        return res;
    }
}
