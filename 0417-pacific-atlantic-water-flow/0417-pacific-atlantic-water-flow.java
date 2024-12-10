class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        Set<String> pac = new HashSet();
        Set<String> atl = new HashSet();

        int r = h.length, c = h[0].length;

        for (int i = 0; i < r; i++) {
            dfs(i, 0, pac, h, h[i][0]);
            dfs(i, c - 1, atl, h, h[i][c - 1]);
        }

        for (int i = 0; i < c; i++) {
            dfs(0, i, pac, h, h[0][i]);
            dfs(r - 1, i, atl, h, h[r - 1][i]);
        }

        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String curr = i + "#" + j;
                if (pac.contains(curr) && atl.contains(curr)) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, Set<String> set, int[][] h, int prev) {
        String curr = r + "#" + c;

        if (r >= h.length || r < 0 || c >= h[0].length || c < 0 || set.contains(curr) || prev > h[r][c]) return;

        set.add(curr);

        for (int[] d : dirs) {
            int nr = d[0] + r, nc = d[1] + c;
            dfs(nr, nc, set, h, h[r][c]);
        }
    }
}
