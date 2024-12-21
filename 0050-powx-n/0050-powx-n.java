class Solution {

    public double myPow(double x, int n) {
        if (x == 0) return 0;

        double res = solve(x, Math.abs(n));

        return (n < 0) ? (double) 1 / res : res;
    }

    public double solve(double x, int n) {
        if (n == 0) return 1;

        double val = solve(x, n / 2);
        val = (n % 2 == 0) ? val * val : val * val * x;

        return val;
    }
}
