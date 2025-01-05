class Solution {

    public String reorganizeString(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getKey(), a.getKey()));

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new Pair(arr[i], (char) ('a' + i)));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair<Integer, Character> p = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != p.getValue()) {
                sb.append(p.getValue());
                int val = p.getKey() - 1;
                if (val > 0) pq.add(new Pair(val, p.getValue()));
            } else {
                if (pq.isEmpty()) return "";

                Pair<Integer, Character> p2 = pq.poll();
                sb.append(p2.getValue());
                int val = p2.getKey() - 1;
                if (val > 0) pq.add(new Pair(val, p2.getValue()));

                pq.add(p);
            }
        }

        return sb.toString();
    }
}
