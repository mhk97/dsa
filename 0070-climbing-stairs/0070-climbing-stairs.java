class Solution {
    Integer cache[];

    public int climbStairs(int n) {
        cache = new Integer[46];
        return solve(n);
    }

    public int solve(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (cache[n] != null) return cache[n];
        return cache[n] = solve(n - 1) + solve(n - 2);
    }
}
