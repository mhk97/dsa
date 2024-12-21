class Solution {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap();

        for (int i[] : points) {
            int x = i[0], y = i[1];

            map.computeIfAbsent(x, k -> new HashSet()).add(y);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    if (map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                        int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                        res = Math.min(area, res);
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
