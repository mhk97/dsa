class Solution {

    public int minAreaRect(int[][] p) {
        HashMap<Integer, Set<Integer>> map = new HashMap();

        for (int i[] : p) {
            map.computeIfAbsent(i[0], k -> new HashSet()).add(i[1]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                int x1 = p[i][0], y1 = p[i][1];
                int x2 = p[j][0], y2 = p[j][1];
                if (x1 != x2 && y1 != y2) {
                    if (map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                        int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                        res = Math.min(res, area);
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
