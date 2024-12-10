class Solution {
    Integer[][] cache;

    public int maxTwoEvents(int[][] events) {
        cache = new Integer[events.length + 1][2];
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(events, 0, 0);
    }

    public int solve(int[][] events, int i, int count) {
        if (i >= events.length || count == 2) return 0;
        if(cache[i][count]!=null) return cache[i][count];
        int p = findNextPossibleIndex(events, i);

        int take = events[i][2] + solve(events, p, count + 1);

        int skip = solve(events, i + 1, count);

        return cache[i][count]= Math.max(take, skip);
    }

    public int findNextPossibleIndex(int[][] events, int i) {
        int l = 0, h = events.length - 1, res = Integer.MAX_VALUE;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (events[mid][0] <= events[i][1]) {
                l = mid + 1;
            } else {
                res = mid;
                h = mid - 1;
            }
        }

        return res == Integer.MAX_VALUE ? events.length : res;
    }
}
