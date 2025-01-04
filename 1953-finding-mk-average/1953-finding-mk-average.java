class MKAverage {
    TreeMap<Integer, Integer> map;
    Deque<Integer> stream;
    int m, k;
    int totalSum = 0, totalSize = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        map = new TreeMap();
        stream = new LinkedList();
    }

    public void addElement(int num) {
        totalSum += num;
        totalSize++;

        stream.add(num);

        if (stream.size() > m) {
            int key = stream.removeFirst();
            map.put(key, map.getOrDefault(key, 0) - 1);
            if (map.get(key) <= 0) map.remove(key);
            totalSum -= key;
        }

        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public int calculateMKAverage() {
        if (totalSize < m) return -1;

        int firstKey = map.firstKey(), lastKey = map.lastKey();
        int kSmall = k, kLarge = k;

        int sum = 0;

        while (kSmall > 0) {
            int toSubtract = Math.min(kSmall, map.get(firstKey));
            kSmall -= toSubtract;
            sum += (toSubtract * firstKey);
            if (toSubtract == map.get(firstKey)) firstKey = map.higherKey(firstKey);
        }

        while (kLarge > 0) {
            int toSubtract = Math.min(kLarge, map.get(lastKey));
            kLarge -= toSubtract;
            sum += (toSubtract * lastKey);
            if (toSubtract == map.get(lastKey)) lastKey = map.lowerKey(lastKey);
        }

        return (totalSum - sum) / (m - 2 * k);
    }
}
/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
