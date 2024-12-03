class Solution {

    public boolean canFinish(int n, int[][] p) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int[] i : p) {
            int u = i[1], v = i[0];
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVis = new boolean[n];

        for (int u = 0; u < n; u++) {
            if (visited[u] == false) {
                if (isCycle(visited, pathVis, map, u) == true) return false;
            }
        }

        return true;
    }

    public boolean isCycle(boolean visited[], boolean pv[], Map<Integer, List<Integer>> map, int u) {
        visited[u] = true;
        pv[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) {
                if (isCycle(visited, pv, map, v) == true) return true;
            } else if (pv[v] == true) return true;
        }

        pv[u] = false;
        return false;
    }
}
