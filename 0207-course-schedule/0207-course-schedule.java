class Solution {

    public boolean canFinish(int V, int[][] edges) {
        //creating a graph adj
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge : edges) {
            int v = edge[0], u = edge[1];
            map.computeIfAbsent(u, key -> new ArrayList()).add(v);
        }

        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (dfs(map, i, visited, pathVisited) == true) return false; //found cycle
            }
        }

        return true; //no cycle
    }

    public boolean dfs(Map<Integer, List<Integer>> map, int u, boolean visited[], boolean pathVisited[]) {
        visited[u] = true;
        pathVisited[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) {
                if (dfs(map, v, visited, pathVisited) == true) return true;
            } else if (pathVisited[v] == true) return true;
        }

        pathVisited[u] = false;

        return false; //no cycle
    }
}
