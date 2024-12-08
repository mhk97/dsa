class Solution {
    int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length, fresh = 0, res = -1;

        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int d[] : dirs) {
                    int nr = temp[0] + d[0], nc = temp[1] + d[1];
                    if (nr < r && nr >= 0 && nc < c && nc >= 0 && grid[nr][nc] == 1) {
                        q.add(new int[] { nr, nc });
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
        }

        return (fresh > 0) ? -1 : res;
    }
}
