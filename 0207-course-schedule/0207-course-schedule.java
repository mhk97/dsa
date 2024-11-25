class Solution {
    public boolean canFinish(int V, int[][] edges) {
        //create adj
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges){
            int u = edge[1], v = edge[0];
            map.computeIfAbsent(u, k-> new ArrayList()).add(v);
        }

        //dfs based cycle find
        boolean visited[] = new boolean[V];
        boolean pv[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(visited[i] == false){
                if(dfs(i, visited, pv, map) == true) return false;
            }
        }

        return true;
    }

    private boolean dfs(int u, boolean[] visited, boolean[] pv, Map<Integer, List<Integer>> map){
        visited[u] = true;
        pv[u] = true;

        for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
            if(visited[v] == false){
                if(dfs(v, visited, pv, map) == true) return true;
            }else if(pv[v] == true) return true;
        }

        pv[u] = false;
        return false;
    }
}