class Solution {
    int prefix[];
    Random r;

    public Solution(int[] w) {
        r = new Random();
        prefix = new int[w.length];
        prefix[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        double random = prefix[prefix.length - 1] * Math.random();
        int l = 0, h = prefix.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (prefix[mid] == random) return mid; else if (prefix[mid] > random) h = mid - 1; else l = mid + 1;
        }
        return l;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
