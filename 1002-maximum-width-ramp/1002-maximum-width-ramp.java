class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        int prefix[] = new int[n];

        prefix[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = Math.max(prefix[i + 1], nums[i]);
        }

        System.out.println(Arrays.toString(prefix));

        int i = 0, j = 0, res = 0;

        while (j < n) {
            while (i < j && nums[i] > prefix[j]) {
                i++;
            }

            res = Math.max(res, j - i);
            j++;
        }

        return res;
    }
}
