class Solution {

    public boolean isBipartite(int[][] graph) {
        Integer[] color = new Integer[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == null) {
                if (unableToColor(graph, color, i, 0) == true) return false;
            }
        }

        return true;
    }

    public boolean unableToColor(int[][] graph, Integer color[], int u, int currColor) {
        color[u] = currColor;

        for (int v : graph[u]) {
            if (color[v] == null) {
                if (unableToColor(graph, color, v, 1 - currColor)) {
                    return true;
                }
            }else if (color[v] == currColor) return true;
        }

        return false;
    }
}
