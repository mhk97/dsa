class Solution {

    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < arr.length; i++) if (arr[i] > 0) pq.offer(new int[] { arr[i], i + 'a' });

        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ((char) first[1])) {
                sb.append((char) first[1]); //append
                if (--first[0] > 0) pq.offer(first);
            } else {
                if (pq.isEmpty()) return "";
                int[] second = pq.poll();
                sb.append((char) second[1]); //append

                if (--second[0] > 0) pq.offer(second);

                pq.offer(first);
            }
        }

        return sb.toString();
    }
}
