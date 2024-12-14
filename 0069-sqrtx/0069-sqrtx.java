class Solution {

    public int mySqrt(int x) {
        if (x < 2) return x;

        int l = 2, h = x / 2;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            long k = (long) mid * mid;
            if (k > x) {
                h = mid - 1;
            } else if (k < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return h;
    }
}
