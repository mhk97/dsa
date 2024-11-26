class Solution {

    public int kthFactor(int n, int k) {
        int kth = 1;
        int res = 1;
        if (k == 1) return kth;

        for (int i = 2; i <= n / 2; i++) {
            if ((n % i) == 0) {
                kth++;
                if (kth == k) return i;
            }
        }

        if (k == kth + 1) return n;

        return -1;
    }
}
