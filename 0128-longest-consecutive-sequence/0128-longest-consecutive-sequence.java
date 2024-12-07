class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i : nums) set.add(i);

        int res = 0;
        for (int i : nums) {
            int temp = i;
            if (set.contains(temp - 1)) continue;
            int cnt = 1;
            while (set.contains(temp)) {
                temp = i + cnt;
                cnt++;
            }
            res = Math.max(res, cnt - 1);
        }

        return res;
    }
}
