class Solution {

    public int minNumberOperations(int[] t) {
        int prev = 0, res = 0;
        for (int i = 0; i < t.length; i++) {
            if (prev < t[i]) {
                res += (t[i] - prev);
            }
            prev = t[i];
        }
        return res;
    }
}
