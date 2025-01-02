class Solution {

    public int findCircleNum(int[][] m) {
        int V = m.length;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && m[i][j] == 1) {
                    map.computeIfAbsent(i, k -> new ArrayList()).add(j);
                    map.computeIfAbsent(j, k -> new ArrayList()).add(i);
                }
            }
        }

        boolean visited[] = new boolean[V];
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            if (visited[i] == false) {
                res += 1;
                dfs(visited, map, i);
            }
        }

        return res;
    }

    public void dfs(boolean visited[], Map<Integer, List<Integer>> map, int u) {
        visited[u] = true;
        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) dfs(visited, map, v);
        }
    }
}
