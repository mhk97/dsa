class Solution {

    public int findCircleNum(int[][] arr) {
        int V = arr.length, res = 0;
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                res++;
                dfs(arr, visited, i);
            }
        }

        return res;
    }

    public void dfs(int[][] arr, boolean[] visited, int u) {
        visited[u] = true;

        for (int v = 0; v < arr[u].length; v++) {
            if (arr[u][v] == 1 && visited[v] == false) {
                dfs(arr, visited, v);
            }
        }
    }
}
