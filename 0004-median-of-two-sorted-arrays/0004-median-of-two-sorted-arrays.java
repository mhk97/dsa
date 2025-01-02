class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, total = n1 + n2;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int partition = (total + 1) / 2;

        int l = 0, h = n1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int h1 = (mid - 1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
            int h2 = (partition - mid - 1 >= 0 && partition - mid - 1 < n2) ? nums2[partition - mid - 1] : Integer.MIN_VALUE;
            int l1 = (mid >= 0 && mid < n1) ? nums1[mid] : Integer.MAX_VALUE;
            int l2 = (partition - mid < n2) ? nums2[partition - mid] : Integer.MAX_VALUE;

            if (h1 <= l2 && h2 <= l1) {
                if (total % 2 == 1) return Math.max(h1, h2); else {
                    int min = Math.max(h1, h2);
                    int max = Math.min(l1, l2);
                    return (double) (min + max) / 2;
                }
            } else if (h2 > l1) l = mid + 1; else h = mid - 1;
        }

        return 0d;
    }
}
