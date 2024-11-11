class Solution {

    public int leastInterval(char[] tasks, int n) {
        //try to use task with most occurance

        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i : arr) if (i > 0) pq.offer(i);

        int res = 0;

        while (!pq.isEmpty()) {
            int cycle = n+1;
        
            List<Integer> list = new ArrayList();
            int count = 0;
            while (!pq.isEmpty() && cycle-- > 0) {
                int currVal = pq.poll();
                if (currVal > 1) list.add(currVal-1);
                count++;
            }

            for (int i : list) pq.offer(i);
            res += (pq.isEmpty()) ? count : n+1;
        }

        return res;
    }
}
