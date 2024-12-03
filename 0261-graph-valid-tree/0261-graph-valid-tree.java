class Solution {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i[] : edges) {
            int u = i[0], v = i[1];
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList()).add(u);
        }

        boolean visited[] = new boolean[n];
        int res = 0;

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                res++;
                if(res>1) return false;
                if(isCycle(visited, i, map, -1)== true) return false;
            }
        }

        return true;
    }

    public boolean isCycle(boolean visited[], int u, Map<Integer, List<Integer>> map, int parent ){
        visited[u] = true;
        for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
            if(visited[v] == false){
                if(isCycle(visited, v, map, u) == true)return true;
            }else if(v != parent) return true;
        }

        return false;
    }
}
