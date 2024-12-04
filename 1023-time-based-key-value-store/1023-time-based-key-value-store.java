class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = map.getOrDefault(key, new ArrayList());
        if (list.isEmpty()) return "";

        return bs(list, timestamp);
    }

    public String bs(List<Pair<String, Integer>> list, int t) {
        int l = 0, h = list.size() - 1, max = Integer.MIN_VALUE;
        String res = "";
        while (l <= h) {
            int mid = l + (h - l) / 2;
            Pair<String, Integer> pair = list.get(mid);
            if (pair.getValue() == t) return pair.getKey(); else if (pair.getValue() > t) {
                h = mid - 1;
            } else {
                res = pair.getKey();
                max = Math.max(max, pair.getValue());
                l = mid + 1;
            }
        }

        return res;
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
