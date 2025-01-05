class Solution {

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];

        nge[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            nge[i] = Math.max(nge[i + 1], nums[i]);
        }

        // System.out.println(Arrays.toString(nge));

        int res = 0, j = 0, i = 0;

        while (j < n) {
            while (j < n && nge[j] >= nums[i]) j++;

            res = Math.max(res, j - i - 1);

            i++;
        }

        return res;
    }
}
