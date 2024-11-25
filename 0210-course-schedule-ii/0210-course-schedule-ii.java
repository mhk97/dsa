class Solution {

    public int[] findOrder(int V, int[][] edges) {
        //create adj
        int[] indegree = new int[V];
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge : edges) {
            int u = edge[1], v = edge[0];
            indegree[v]++;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        // dfs based cycle find
        boolean visited[] = new boolean[V];
        boolean pv[] = new boolean[V];
        Stack<Integer> stack = new Stack();

        for(int i=0; i<V; i++){
            if(visited[i] == false){
                if(dfs(i, visited, pv, map, stack) == true) return new int[]{};
            }
        }

        int res[] = new int[V];
        int ind = 0;

        while(!stack.isEmpty()){
            res[ind++] = stack.pop();
        }

        return res;

        //Q based topo using kahnes bfs
        // Queue<Integer> q = new LinkedList();
        // for (int i = 0; i < V; i++) if (indegree[i] == 0) {
        //     q.add(i);
        // }

        // List<Integer> list = new ArrayList();
        // while (!q.isEmpty()) {
        //     int u = q.poll();
        //     list.add(u);
        //     for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
        //         indegree[v]--;
        //         if (indegree[v] == 0) {
        //             q.add(v);
        //         }
        //     }
        // }

        // if(V != list.size()) return new int[]{};

        // int res[] = new int[V];
        // int ind = 0;
        // for(int i: list){
        //     res[ind++] = i;
        // }

        // return res;
    }

    private boolean dfs(int u, boolean[] visited, boolean[] pv, Map<Integer, List<Integer>> map, Stack<Integer> stack) {
        visited[u] = true;
        pv[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) {
                if (dfs(v, visited, pv, map, stack) == true) return true;
            } else if (pv[v] == true) return true;
        }

        pv[u] = false;
        stack.push(u);
        return false;
    }
}
