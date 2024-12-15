class Solution {

    public double myPow(double x, int n) {
        if (x == 0) return 0;

        double res = solve(x, Math.abs(n));
        return (n >= 0) ? res : (double) 1 / res;
    }

    public double solve(double x, int n) {
        if (n == 0) return 1;

        double val = solve(x, n / 2);
        double res = val*val;

        return (n % 2 == 0) ? res : res * x;
    }
}
