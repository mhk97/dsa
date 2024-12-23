class Solution {

    public int totalFruit(int[] nums) {
        int i = 0, n = nums.length, j = 0, res = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap();

        while (j < n) {
            int curr = nums[j];

            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.size() > 2) {
                int icurr = nums[i++];
                int updated = map.get(icurr) - 1;
                if (updated == 0) map.remove(icurr); else map.put(icurr, updated);
            }

            res = Math.max(res, j - i + 1);

            j++;
        }

        return res;
    }
}
