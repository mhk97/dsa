class Solution {

    public int[] findOrder(int n, int[][] p) {
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int i[] : p) {
            adj.computeIfAbsent(i[1], k -> new ArrayList()).add(i[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, stack, adj)) return new int[] { };
            }
        }

        int[] res = new int[n];
        int i = 0;

        // System.out.println(stack);
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }

        return res;
    }

    private boolean dfs(int u, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack, Map<Integer, List<Integer>> adj) {
        visited[u] = true;
        pathVisited[u] = true;

        for (int v : adj.getOrDefault(u, new ArrayList<Integer>())) {
            if (!visited[v]) {
                if (dfs(v, visited, pathVisited, stack, adj)) return true;
            } else if (pathVisited[v]) return true;
        }

        pathVisited[u] = false;
        stack.push(u);

        return false;
    }
}
