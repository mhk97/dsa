class Solution {

    public int maxRemoval(int[] nums, int[][] q) {
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> candidate = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> chosen = new PriorityQueue();

        int res = 0, n = nums.length, j = 0;

        for (int i = 0; i < n; i++) {
            while (j < q.length && q[j][0] == i) {
                candidate.offer(q[j][1]);
                j++;
            }

            nums[i] -= chosen.size();

            while (nums[i] > 0 && !candidate.isEmpty() && candidate.peek() >= i) {
                res++;
                chosen.offer(candidate.poll());
                nums[i]--;
            }

            if (nums[i] > 0) return -1;

            while (!chosen.isEmpty() && chosen.peek() == i) chosen.poll();
        }

        return q.length - res;
    }
}
