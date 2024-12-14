class Solution {
    Integer cache[] = new Integer[46];

    public int climbStairs(int n) {
        if (n <= 0) return n == 0 ? 1 : 0;
        if (cache[n] != null) return cache[n];
        return cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}
