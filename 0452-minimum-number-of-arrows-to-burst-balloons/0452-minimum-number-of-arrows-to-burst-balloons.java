class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int ps = points[0][0], pe = points[0][1], i = 1, res = 1;

        while (i < points.length) {
            int curr[] = points[i];
            if (pe < curr[0]) {
                res += 1;
                ps = curr[0];
                pe = curr[1];
            } else {
                ps = Math.max(ps, curr[0]);
                pe = Math.min(pe, curr[1]);
            }
            i++;
        }

        return res;
    }
}
