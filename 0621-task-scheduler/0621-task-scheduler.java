class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i : arr) if (i > 0) pq.offer(i);

        int res = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1, count = 0;

            List<Integer> list = new ArrayList();
            while (!pq.isEmpty() && cycle-- > 0) {
                int i = pq.poll();
                if (i - 1 > 0) list.add(i - 1);
                count++;
            }
            for (int i : list) pq.offer(i);
            if (pq.isEmpty()) res += count; else res += n + 1;
        }

        return res;
    }
}
