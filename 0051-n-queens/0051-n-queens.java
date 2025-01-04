class Solution {
    int n;
    int[] row, ld, ud;

    List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        row = new int[n];
        ld = new int[2 * n - 1];
        ud = new int[2 * n - 1];

        List<StringBuilder> temp = new ArrayList();
        String t = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            temp.add(new StringBuilder(t));
        }

        solve(temp, 0);

        return res;
    }

    public void addRes(List<StringBuilder> temp) {
        List<String> pep = new ArrayList();
        for (StringBuilder sb : temp) {
            pep.add(sb.toString());
        }

        res.add(pep);
    }

    public void solve(List<StringBuilder> list, int c) {
        if (c >= n) {
            addRes(list);
            return;
        }

        for (int r = 0; r < n; r++) {
            if (row[r] == 0 && ld[r + c] == 0 && ud[n - 1 + (c - r)] == 0) {
                StringBuilder temp = list.get(r);

                row[r] = 1;
                ld[r + c] = 1;
                ud[n - 1 + (c - r)] = 1;
                temp.setCharAt(c, 'Q');

                solve(list, c + 1);

                row[r] = 0;
                ld[r + c] = 0;
                ud[n - 1 + (c - r)] = 0;
                temp.setCharAt(c, '.');
            }
        }
    }
}
