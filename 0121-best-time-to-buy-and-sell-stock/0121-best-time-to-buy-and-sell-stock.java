class Solution {

    public int maxProfit(int[] prices) {
        int minSoFar = prices[0], n = prices.length, max = 0;

        for (int i = 1; i < n; i++) {
            int curr = prices[i];
            if (curr > minSoFar) max = Math.max(max, curr - minSoFar);
            if (curr < minSoFar) minSoFar = curr;
        }

        return max;
    }
}
