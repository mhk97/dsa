class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int max = Integer.MIN_VALUE, k = nums.size();
        int res[] = new int[] { (int) -1e5, (int) 1e5 };

        for (int i = 0; i < k; i++) {
            List<Integer> curr = nums.get(i);
            max = Math.max(curr.get(0), max);
            pq.offer(new int[] { curr.get(0), i, 0 });
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int min = curr[0];
            if ((max - min) < (res[1] - res[0])) {
                res[0] = min;
                res[1] = max;
            }
            int listIndex = curr[1], selfIndex = curr[2] + 1;
            List<Integer> currList = nums.get(listIndex);
            if (selfIndex >= currList.size()) break;
            int nextMin = currList.get(selfIndex);
            max = Math.max(nextMin, max);
            pq.offer(new int[] { nextMin, listIndex, selfIndex });
        }

        return res;
    }
}
