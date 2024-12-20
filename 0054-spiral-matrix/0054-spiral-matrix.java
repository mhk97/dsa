class Solution {

    public List<Integer> spiralOrder(int[][] m) {
        int row = m.length, col = m[0].length;

        int left = 0, top = 0, right = col - 1, bottom = row - 1;

        List<Integer> res = new ArrayList();

        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) {
                res.add(m[top][i]);
            }

            top++;

            //top to bottom
            for (int i = top; i <= bottom; i++) {
                res.add(m[i][right]);
            }

            right--;

            //right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(m[bottom][i]);
                }
                bottom--;
            }

            //bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(m[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
