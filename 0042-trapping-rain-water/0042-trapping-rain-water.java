class Solution {

    public int trap(int[] h) {
        int lmax[] = new int[h.length];

        lmax[0] = 0;

        for (int i = 1; i < h.length; i++) {
            lmax[i] = Math.max(lmax[i - 1], h[i - 1]);
        }

        int rmax = 0, res = 0;

        for (int i = h.length - 2; i >= 0; i--) {
            rmax = Math.max(rmax, h[i + 1]);
            int k = Math.min(rmax, lmax[i]) - h[i];
            if (k > 0) res += k;
        }

        return res;
    }
}
