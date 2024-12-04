class HitCounter {
    Deque<Pair<Integer, Integer>> q;
    int total = 0;

    public HitCounter() {
        q = new LinkedList();
    }

    public void hit(int timestamp) {
        if (q.isEmpty() || q.getLast().getKey() != timestamp) {
            q.add(new Pair(timestamp, 1));
        } else {
            int prev = q.getLast().getValue();
            q.removeLast();
            q.add(new Pair(timestamp, prev + 1));
        }
        total++;
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty()) {
            int diff = timestamp - q.getFirst().getKey();
            if (diff >= 300) {
                total -= q.getFirst().getValue();
                q.removeFirst();
            } else break;
        }

        return total;
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
