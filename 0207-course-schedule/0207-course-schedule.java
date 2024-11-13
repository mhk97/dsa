class Solution {

    public boolean canFinish(int n, int[][] p) {
        //finding cycle in directed graph --  if you want to use topo sort- go for kahnes implemntation
        //other wise normal cycle detection using dfs and path visited array

        Map<Integer, List<Integer>> adj = new HashMap();

        for (int i[] : p) {
            adj.computeIfAbsent(i[1], k -> new ArrayList()).add(i[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, pathVisited, visited)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int u, Map<Integer, List<Integer>> adj, boolean[] pathVisited, boolean[] visited) {
        visited[u] = true;
        pathVisited[u] = true;

        for (int v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                if (dfs(v, adj, pathVisited, visited)) return true;
            } else if (pathVisited[v]) {
                return true;
            }
        }

        pathVisited[u] = false;

        return false;
    }
}
