class Solution {

    public boolean canFinish(int V, int[][] edges) {
        int indegree[] = new int[V];

        //create a map
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[0];
            indegree[v]++;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < V; i++) if (indegree[i] == 0) q.add(i);

        List<Integer> res = new ArrayList();

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        return res.size() == V;
    }
}
