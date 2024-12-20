class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();

        if (nums.length == 0) return res;

        int lb = nums[0], ub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) ub = nums[i]; else {
                if (lb == ub) res.add(lb + ""); else res.add(lb + "->" + ub);
                lb = ub = nums[i];
            }
        }

        if (lb == ub) res.add(lb + ""); else res.add(lb + "->" + ub);

        return res;
    }
}
