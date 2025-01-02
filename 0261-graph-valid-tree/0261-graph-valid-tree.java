class Solution {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int j[] : edges) {
            map.computeIfAbsent(j[0], k -> new ArrayList()).add(j[1]);
            map.computeIfAbsent(j[1], k -> new ArrayList()).add(j[0]);
        }

        boolean visited[] = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                cnt++;
                if (cnt > 1) return false;
                if (cycle(i, visited, -1, map) == true) return false;
            }
        }

        return true;
    }

    public boolean cycle(int u, boolean[] visited, int parent, Map<Integer, List<Integer>> map) {
        visited[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (parent == v) continue;
            if (visited[v] == true) return true;
            if (cycle(v, visited, u, map) == true) return true;
        }

        return false;
    }
}
