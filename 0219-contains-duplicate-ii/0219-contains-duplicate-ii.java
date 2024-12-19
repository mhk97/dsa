class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i];
            if (set.contains(m)) return true;
            set.add(m);
            if (set.size() > k) set.remove(nums[i - k]);
        }

        return false;
    }
}
