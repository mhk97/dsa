class Solution {

    public boolean searchMatrix(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        int l = 0, h = m * n - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int mv = mat[mid / n][mid % n];

            if (mv == k) return true; else if (mv > k) h = mid - 1; else l = mid + 1;
        }

        return false;
    }
}
