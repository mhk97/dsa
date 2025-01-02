class Solution {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int j[] : edges) {
            map.computeIfAbsent(j[0], k -> new ArrayList()).add(j[1]);
            map.computeIfAbsent(j[1], k -> new ArrayList()).add(j[0]);
        }

        boolean visited[] = new boolean[n];
        Queue<int[]> q = new LinkedList();

        q.add(new int[] { 0, -1 });
        int cnt = 0;

        while (!q.isEmpty()) {
            int u[] = q.poll();
            visited[u[0]] = true;
            cnt++;

            for (int v : map.getOrDefault(u[0], new ArrayList<Integer>())) {
                if (v == u[1]) continue;
                if (visited[v] == true) return false;
                q.add(new int[] { v, u[0] });
            }
        }

        return cnt == n;
    }
}
