class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet();
        for (String w : wordList) set.add(w);

        Queue<Pair<String, Integer>> q = new LinkedList();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            String word = curr.getKey();
            int cnt = curr.getValue();

            if (word.equals(endWord)) return cnt;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, (char) c);
                    if (set.contains(sb.toString())) {
                        set.remove(sb.toString());
                        q.add(new Pair(sb.toString(), cnt + 1));
                    }
                }
            }
        }

        return 0;
    }
}
