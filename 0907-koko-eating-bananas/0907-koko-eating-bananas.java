class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int i : piles) max = Math.max(i, max);

        int l = 1, r = max, res = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(piles, mid, h) == true) {
                res = Math.min(mid, res);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    public boolean check(int[] piles, int k, int h) {
        for (int i : piles) {
            if (i < k) h--; else {
                if (i % k == 0) {
                    h = h - (i / k);
                } else {
                    h = h - ((i / k) + 1);
                }
            }
            if (h < 0) return false;
        }

        return true;
    }
}
