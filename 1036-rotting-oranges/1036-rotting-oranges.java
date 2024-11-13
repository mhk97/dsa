class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList();

        int r = grid.length, c = grid[0].length, res = 0, fresh = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.add(new int[] { i, j });
            }
        }

        if(fresh == 0) return 0; 
        if(q.isEmpty()) return -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int cr = curr[0], cc = curr[1];

                for (int[] d : dirs) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[] { nr, nc });
                    }
                }
            }

            res++;
        }

        return fresh > 0 ? -1 : res-1;
    }
}
