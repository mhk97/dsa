class Solution {

    public int[] findOrder(int n, int[][] p) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] indegree = new int[n];
        for (int i[] : p) {
            int u = i[1], v = i[0];
            indegree[v]++;
            map.computeIfAbsent(u, k -> new ArrayList()).add(v);
        }

        Queue<Integer> q = new LinkedList();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.add(i);

        while(!q.isEmpty()){
            int u = q.poll();
            res.add(u);
            for(int v: map.getOrDefault(u, new ArrayList<Integer>())){
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }

        int op[] = new int[n];
        if(res.size() != n) return new int[]{};
        for(int i=0; i< res.size(); i++) op[i] = res.get(i);

        return op;

    }
}
