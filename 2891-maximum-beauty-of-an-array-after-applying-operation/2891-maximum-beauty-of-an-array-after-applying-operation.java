class Solution {

    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int[][] ranges = new int[n][2];

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            ranges[i] = new int[] { curr - k, curr + k };
        }

        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue();
        int res = Integer.MIN_VALUE;

        for (int i[] : ranges) {
            while (!pq.isEmpty() && pq.peek() < i[0]) pq.poll();
            pq.add(i[1]);
            res = Math.max(res, pq.size());
        }

        return res;
    }
}
