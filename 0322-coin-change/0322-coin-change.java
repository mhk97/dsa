class Solution {
    Integer cache[][];

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        cache = new Integer[coins.length + 1][10001];
        int res = solve(coins, amount, coins.length - 1);
        return (res == (int) 1e8) ? -1 : res;
    }

    public int solve(int[] coins, int amount, int i) {
        if (amount < 0) return (int) 1e8;

        if (amount == 0) return 0;

        if (cache[i][amount] != null) return cache[i][amount];

        if (i == 0) {
            return (coins[i] <= amount && amount % coins[i] == 0) ? amount / coins[i] : (int) 1e8;
        }

        int take = (coins[i] <= amount) ? 1 + solve(coins, amount - coins[i], i) : (int) 1e8;
        int skip = solve(coins, amount, i - 1);

        return cache[i][amount] = Math.min(take, skip);
    }
}
