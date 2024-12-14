class Solution {

    public int maxProfit(int[] p) {
        int minSoFar = p[0], res = 0;

        for (int i = 0; i < p.length; i++) {
            if (p[i] <= minSoFar) minSoFar = p[i]; else {
                res = Math.max(p[i] - minSoFar, res);
            }
        }

        return res;
    }
}
