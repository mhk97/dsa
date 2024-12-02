class Solution {
    Integer[][] cache;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        cache = new Integer[coins.length+1][amount+1];
        int res = solve(coins, amount, coins.length - 1);
        return res == (int) 1e9 ? -1 : res;
    }

    public int solve(int[] coins, int amount, int i) {
        if (amount == 0) return 0;
        if (amount < 0 || i < 0) return (int) 1e9;
        if(cache[i][amount]!=null) return cache[i][amount];

        int take = (coins[i] <= amount) ? 1 + solve(coins, amount - coins[i], i) : (int)1e9;

        int skip = solve(coins, amount, i - 1);

        return cache[i][amount] = Math.min(take, skip);
    }
}
