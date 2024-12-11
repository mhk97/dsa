class Solution {

    public int trap(int[] h) {
        int leftMax[] = new int[h.length];

        leftMax[0] = 0;
        for (int i = 1; i < h.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], h[i - 1]);
        }

        int curr = 0, res = 0;
        for (int i = h.length - 2; i >= 0; i--) {
            curr = Math.max(h[i + 1], curr);
            int x = Math.min(curr, leftMax[i]);
            if (x > h[i]) res += x - h[i];
        }

        return res;
    }
}
