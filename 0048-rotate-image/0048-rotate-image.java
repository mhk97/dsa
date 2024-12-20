class Solution {

    public void rotate(int[][] m) {
        transpose(m);
        reverse(m);
    }

    public void transpose(int[][] m) {
        int r = m.length, c = m[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                swap(m, i, j);
            }
        }
    }

    public void swap(int[][] m, int i, int j) {
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
    }

    public void reverse(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int l = 0, r = m[i].length-1;
            while (l <= r) {
                int temp = m[i][l];
                m[i][l] = m[i][r];
                m[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
