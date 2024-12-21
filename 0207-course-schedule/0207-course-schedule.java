class Solution {

    public boolean canFinish(int V, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int edge[] : edges) {
            int u = edge[1], v = edge[0];
            map.computeIfAbsent(u, j -> new ArrayList()).add(v);
        }

        boolean visited[] = new boolean[V];
        boolean pv[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (cycle(visited, pv, map, i) == true) return false;
            }
        }

        return true;
    }

    public boolean cycle(boolean visited[], boolean pv[], Map<Integer, List<Integer>> map, int u) {
        visited[u] = true;
        pv[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) {
                if (cycle(visited, pv, map, v) == true) return true;
            } else if (pv[v] == true) return true;
        }

        pv[u] = false;
        return false;
    }
}
