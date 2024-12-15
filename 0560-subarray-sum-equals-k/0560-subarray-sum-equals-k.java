class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);

        int curr = 0, res = 0;
        for (int i : nums) {
            curr += i;
            if (map.containsKey(curr - k)) res+= map.get(curr-k);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        return res;
    }
}