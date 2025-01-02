class Solution {
    Integer cache[][];

    public int change(int amount, int[] coins) {
        cache = new Integer[amount + 1][coins.length + 1];
        return solve(coins, amount, coins.length - 1);
    }

    public int solve(int[] coins, int amt, int i) {
        if (amt == 0) return 1;
        if (amt < 0) return 0;
        if (i == 0) return (amt % coins[i] == 0) ? 1 : 0;

        if (cache[amt][i] != null) return cache[amt][i];
        int take = (amt >= coins[i]) ? solve(coins, amt - coins[i], i) : 0;
        int skip = solve(coins, amt, i - 1);

        return cache[amt][i] = take + skip;
    }
}
