class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                return bs(matrix[i], target);
            }
        }
        return false;
    }

    public boolean bs(int[] arr, int key) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == key) return true; else if (arr[mid] < key) l = mid + 1; else h = mid - 1;
        }

        return false;
    }
}
