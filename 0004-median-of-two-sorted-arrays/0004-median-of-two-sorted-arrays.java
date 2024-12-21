class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];

        int i = 0, j = 0, m = nums1.length, n = nums2.length, p = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[p++] = nums1[i++];
            } else res[p++] = nums2[j++];
        }

        while (i < m) res[p++] = nums1[i++];
        while (j < n) res[p++] = nums2[j++];

        if ((m + n) % 2 == 1) {
            return (double) res[(m + n) / 2];
        } else {
            int id = (m + n) / 2;
            return (double) (res[id] + res[id - 1]) / 2.0;
        }
    }
}
