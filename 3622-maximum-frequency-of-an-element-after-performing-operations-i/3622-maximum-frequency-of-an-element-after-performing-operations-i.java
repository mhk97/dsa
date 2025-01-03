class Solution {

    public int maxFrequency(int[] nums, int k, int no) {
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> range = new TreeMap();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            int l = i - k, h = i + k + 1;
            range.put(l, range.getOrDefault(l, 0) + 1);
            range.put(i, range.getOrDefault(i, 0));
            range.put(h, range.getOrDefault(h, 0) - 1);
        }

        int res = 0, prev = 0, prefix = 0;

        for (Map.Entry<Integer, Integer> entry : range.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            prefix = prev + freq;
            int ogfre = map.getOrDefault(num, 0);

            int ops = Math.min(no, (prefix - ogfre));
            res = Math.max(res, ops + ogfre);
            prev = prefix;
        }

        return res;
    }
}
