class Solution {

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int dirs[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        Queue<int[]> q = new LinkedList();
        int fresh = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            res += 1;

            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int r = temp[0], c = temp[1];

                for (int d[] : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < row && nc < col && nr >= 0 && nc >= 0 && grid[nr][nc] == 1) {
                        q.add(new int[] { nr, nc });
                        fresh--;
                        grid[nr][nc] = 2;
                    }
                }
            }
        }

        return fresh <= 0 ? res - 1 : -1;
    }
}
