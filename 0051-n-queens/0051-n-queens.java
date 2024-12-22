class Solution {
    List<List<String>> res = new ArrayList();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;

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

    public void solve(List<StringBuilder> temp, int c) {
        if (c >= n) {
            addRes(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (safe(i, c, temp)) {
                StringBuilder t = temp.get(i);
                t.setCharAt(c, 'Q');
                solve(temp, c + 1);
                t.setCharAt(c, '.');
            }
        }
    }

    public boolean safe(int r, int c, List<StringBuilder> temp) {
        int tempR = r, tempC = c;

        while (r >= 0 && c >= 0) {
            StringBuilder t = temp.get(r);
            if (t.charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = tempR;
        c = tempC;

        while (c >= 0) {
            StringBuilder t = temp.get(r);
            if (t.charAt(c) == 'Q') return false;
            c--;
        }

        r = tempR;
        c = tempC;

        while (r < n && c >= 0) {
            StringBuilder t = temp.get(r);
            if (t.charAt(c) == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }
}
