class Solution {

    public boolean canFinish(int V, int[][] edges) {
        //create adj
        int[] indegree = new int[V];
        Map<Integer, List<Integer>> map = new HashMap();
        for (int[] edge : edges) {
            int u = edge[1], v = edge[0];
            indegree[v]++;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        //dfs based cycle find
        // boolean visited[] = new boolean[V];
        // boolean pv[] = new boolean[V];

        // for(int i=0; i<V; i++){
        //     if(visited[i] == false){
        //         if(dfs(i, visited, pv, map) == true) return false;
        //     }
        // }

        //return true;

        //Q based topo using kahnes bfs
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < V; i++) if (indegree[i] == 0) {
            q.add(i);
        }
        
        List<Integer> list = new ArrayList();
        while(!q.isEmpty()){
            int u = q.poll();
            list.add(u);
            for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }

        return list.size() == V;
    }

    private boolean dfs(int u, boolean[] visited, boolean[] pv, Map<Integer, List<Integer>> map) {
        visited[u] = true;
        pv[u] = true;

        for (int v : map.getOrDefault(u, new ArrayList<Integer>())) {
            if (visited[v] == false) {
                if (dfs(v, visited, pv, map) == true) return true;
            } else if (pv[v] == true) return true;
        }

        pv[u] = false;
        return false;
    }
}
