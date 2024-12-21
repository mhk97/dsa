class Solution {

    public int maxFrequency(int[] nums, int k, int no) {
        Map<Integer, Integer> map = new HashMap();

        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        Map<Integer, Integer> sweep = new TreeMap();

        for (int i : nums) {
            int l = i - k, h = i + k + 1;

            sweep.put(l, sweep.getOrDefault(l, 0) + 1);
            sweep.put(i, sweep.getOrDefault(i, 0));
            sweep.put(h, sweep.getOrDefault(h, 0) - 1);
        }

        int res = Integer.MIN_VALUE, prev = 0;

        for (Map.Entry<Integer, Integer> entry : sweep.entrySet()) {
            int key = entry.getKey(), value = entry.getValue(), prefix = prev + value;

            int existing = map.getOrDefault(key, 0);
            int ops = Math.min(prefix - existing, no);
            res = Math.max(res, ops + existing);

            prev = prefix;
        }

        return res;
    }
}
