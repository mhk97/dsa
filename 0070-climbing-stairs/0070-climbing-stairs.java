class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }

    public int solve(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (dp[n] != 0) return dp[n];

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }
}
