class Solution {

    public int maxArea(int[] h) {
        int i = 0, j = h.length - 1, res = 0;

        while (i < j) {
            int area = (j - i) * Math.min(h[j], h[i]);
            res = Math.max(area, res);

            if (h[i] <= h[j]) i++; else j--;
        }

        return res;
    }
}
