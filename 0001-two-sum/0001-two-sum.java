class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int need = target - curr;
            if (map.containsKey(need) && map.get(need) != i) {
                return new int[] { i, map.get(need) };
            }
        }

        return new int[] {};
    }
}
