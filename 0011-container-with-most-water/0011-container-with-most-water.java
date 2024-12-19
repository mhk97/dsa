class Solution {

    public int maxArea(int[] h) {
        int res = 0, i = 0, j = h.length - 1;

        while (i < j) {
            int temp = (j - i) * Math.min(h[i], h[j]);
            res = Math.max(res, temp);
            if (h[i] >= h[j]) j--; else i++;
        }

        return res;
    }
}
