class Solution {

    public int minEatingSpeed(int[] piles, int m) {
        int max = 0;
        for (int i : piles) max = Math.max(i, max);

        int l = 1, h = max, res = Integer.MAX_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (possible(mid, piles, m) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else l = mid + 1;
        }

        return res;
    }

    public boolean possible(int mid, int nums[], int h) {
        int cnt = 0, sum = 0;

        for (int i : nums) {
            if (i < mid) cnt++; else {
                int k = i / mid;
                if (i % mid != 0) k++;
                cnt += k;
            }

            if (cnt > h) return false;
        }

        return true;
    }
}
