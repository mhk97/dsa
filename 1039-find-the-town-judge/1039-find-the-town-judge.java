class Solution {

    public int findJudge(int n, int[][] trust) {
        int trusting[] = new int[n];
        int trusted[] = new int[n];

        for (int edge[] : trust) {
            int u = edge[0] - 1, v = edge[1] - 1;
            trusting[u]++;
            trusted[v]++;
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            if (trusting[i] == 0) {
                res = i;
                break;
            }
        }

        return (res != -1 && trusted[res] == n - 1) ? res + 1 : -1;
    }
}
