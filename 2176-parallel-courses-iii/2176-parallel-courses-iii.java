class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> map = new HashMap();
        int indegree[] = new int[n];

        for (int edge[] : relations) {
            int u = edge[0] - 1, v = edge[1] - 1;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
            indegree[v]++;
        }

        int[] max = new int[n];
        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                max[i] = time[i];
            }
        }

        int res = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
                indegree[v]--;
                int vCost = time[v] + max[u];
                max[v] = Math.max(vCost, max[v]);
                if (indegree[v] == 0) q.add(v);
            }
        }

        for (int i : max) res = Math.max(res, i);

        return res;
    }
}
