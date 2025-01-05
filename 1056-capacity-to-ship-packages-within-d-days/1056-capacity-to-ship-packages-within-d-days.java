class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE, h = 0, res = Integer.MAX_VALUE;

        for (int i : weights) {
            l = Math.max(i, l);
            h += i;
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (canShip(weights, days, mid) == true) {
                res = Math.min(res, mid);
                h = mid - 1;
            } else l = mid + 1;
        }

        return res;
    }

    public boolean canShip(int[] nums, int days, int k) {
        int temp = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            temp += nums[i];
            if (temp <= k) continue; else {
                cnt++;
                temp = nums[i];
            }
            if (cnt > days) return false;
        }

        return cnt <= days;
    }
}
