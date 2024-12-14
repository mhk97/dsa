class Solution {

    public int minimumSemesters(int n, int[][] relations) {
        int indegree[] = new int[n];
        Map<Integer, List<Integer>> map = new HashMap();
        for (int edge[] : relations) {
            int u = edge[0] - 1, v = edge[1] - 1;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.add(i);

        int res = 0;
        List<Integer> topo = new ArrayList();

        while (!q.isEmpty()) {
            int size = q.size();
            res += 1;

            for (int i = 0; i < size; i++) {
                int u = q.poll();
                topo.add(u);
                for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
                    indegree[v]--;
                    if (indegree[v] == 0) q.add(v);
                }
            }
        }

        return (topo.size() == n) ? res : -1;
    }
}
