class Solution {

    public void merge(int[] n1, int m, int[] n2, int n) {
        int k = n1.length - 1, i = m - 1, j = n - 1;

        while (k >= 0) {
            if (j < 0) break;
            if (i >= 0 && n1[i] > n2[j]) {
                n1[k--] = n1[i--];
            } else {
                n1[k--] = n2[j--];
            }
        }
    }
}
