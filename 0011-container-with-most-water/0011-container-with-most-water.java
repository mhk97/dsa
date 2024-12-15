class Solution {

    public int maxArea(int[] h) {
        int i = 0, res = 0, n = h.length, j = n - 1;

        while (i <= j) {
            res = Math.max((j - i) * Math.min(h[i], h[j]), res);
            if (h[i] < h[j]) i++; else j--;
        }

        return res;
    }
}
