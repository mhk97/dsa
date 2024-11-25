class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i : arr) if (i > 0) pq.offer(i);

        System.out.println(pq);

        int res = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1, cnt = 0;
            List<Integer> list = new ArrayList();

            while (!pq.isEmpty() && cycle-- > 0) {
                int k = pq.poll();
                cnt++;
                if (k - 1 > 0) list.add(k-1);
            }

            for (int i : list) pq.offer(i);
            res += (pq.isEmpty()) ? cnt : n + 1;
        }

        return res;
    }
}
