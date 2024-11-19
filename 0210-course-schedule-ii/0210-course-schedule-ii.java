class Solution {

    public int[] findOrder(int V, int[][] edges) {
        //create a map
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge : edges) {
            int u = edge[1], v = edge[0];
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        boolean v[] = new boolean[V];
        boolean pv[] = new boolean[V];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < V; i++) {
            if (v[i] == false) {
                if (dfs(i, map, v, pv, stack) == true) return new int[] {};
            }
        }

        int res[] = new int[V];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }

        return res;
    }

    public boolean dfs(int u, Map<Integer, List<Integer>> map, boolean visited[], boolean pv[], Stack<Integer> stack) {
        visited[u] = true;
        pv[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) {
                if (dfs(v, map, visited, pv, stack) == true) return true;
            } else if (pv[v] == true) {
                return true;
            }
        }

        pv[u] = false;
        stack.push(u);

        return false;
    }
}
