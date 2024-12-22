class Solution {

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new TreeMap();

        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int max = 1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), count = 0, temp = 0;

            while (map.containsKey(key) && map.get(key) > 0) {
                if (key == 1) {
                    temp += map.get(key);
                    break;
                } else if (map.get(key) >= 2) temp += 2; else if (map.get(key) == 1) {
                    temp += 1;
                    break;
                }
                map.put(key, 0);
                key = key * key;
            }

            if (temp % 2 == 0) temp--;
            max = Math.max(temp, max);
        }

        return max;
    }
}
