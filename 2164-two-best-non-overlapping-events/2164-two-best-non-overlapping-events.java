class Solution {
    Integer cache[][];

    public int maxTwoEvents(int[][] events) {
        cache = new Integer[events.length + 1][2];
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(events, 0, 0);
    }

    public int solve(int[][] events, int i, int count) {
        if (i >= events.length) return 0;
        if (count == 2) return 0;   
        if(cache[i][count]!=null) return cache[i][count];

        int nextIndex = bs(events, i);
        int take = solve(events, nextIndex, count + 1) + events[i][2];
        int skip = solve(events, i + 1, count);

        return cache[i][count] = Math.max(take, skip);
    }

    public int bs(int events[][], int i) {
        int lastEnd = events[i][1];
        int l = 0, h = events.length - 1, res = events.length;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (events[mid][0] > lastEnd) {
                res = mid;
                h = mid - 1;
            } else l = mid + 1;
        }

        return res;
    }
}
