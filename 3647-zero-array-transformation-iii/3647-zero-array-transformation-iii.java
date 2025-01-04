class Solution {

    public int maxRemoval(int[] nums, int[][] q) {
        PriorityQueue<Integer> candidates = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> chosen = new PriorityQueue<>();

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0, j = 0;

        for (int i = 0; i < nums.length; i++) {
            //add to candidates for this index
            while (j < q.length && q[j][0] == i) {
                candidates.offer(q[j][1]);
                j++;
            }

            nums[i] -= chosen.size();

            while (nums[i] > 0 && !candidates.isEmpty() && candidates.peek() >= i) {
                chosen.add(candidates.poll());
                res++;
                nums[i]--;
            }

            if (nums[i] > 0) return -1;

            while (!chosen.isEmpty() && chosen.peek() == i) {
                chosen.poll();
            }
        }

        return q.length - res;
    }
}
