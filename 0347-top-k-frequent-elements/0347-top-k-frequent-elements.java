class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] { entry.getValue(), entry.getKey() });
            if (pq.size() > k) pq.poll();
        }

        int res[] = new int[k];
        int ind = 0;
        while (!pq.isEmpty()) {
            res[ind++] = pq.poll()[1];
        }

        return res;
    }
}
