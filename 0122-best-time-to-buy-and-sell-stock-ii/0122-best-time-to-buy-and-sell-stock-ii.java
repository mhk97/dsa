class Solution {

    public int maxProfit(int[] p) {
        int res = 0;

        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[i - 1]) res += (p[i] - p[i - 1]);
        }

        return res;
    }
}
