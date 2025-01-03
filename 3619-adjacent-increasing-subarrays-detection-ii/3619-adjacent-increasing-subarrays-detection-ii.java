class Solution {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int prefix[] = new int[n];
        prefix[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) prefix[i] = prefix[i + 1] + 1; else prefix[i] = 1;
        }

        int l = 0, h = n / 2, res = Integer.MIN_VALUE;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (check(prefix, mid) == true) {
                res = Math.max(res, mid);
                l = mid + 1;
            } else h = mid - 1;
        }

        return res;
    }

    public boolean check(int[] prefix, int mid) {
        for (int i = 0; i < prefix.length - mid; i++) {
            if (prefix[i] >= mid && prefix[i + mid] >= mid) return true;
        }
        return false;
    }
}
