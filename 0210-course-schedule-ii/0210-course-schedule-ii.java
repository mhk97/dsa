class Solution {

    public int[] findOrder(int V, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();

        int[] indegree = new int[V];

        for (int edge[] : edges) {
            int u = edge[1], v = edge[0];
            map.computeIfAbsent(u, j -> new ArrayList()).add(v);
            indegree[v]++;
        }

        List<Integer> res = new ArrayList();
        int m = 0;
        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);

            for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        return res.size() != V ? new int[]{} : res.stream().mapToInt(Integer::intValue).toArray();
    }
}
