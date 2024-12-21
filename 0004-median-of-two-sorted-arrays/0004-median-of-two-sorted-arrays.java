class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int l = 0, h = n1, partition = (n1 + n2 + 1) / 2;

        while (l <= h) {
            int mid1 = l + (h - l) / 2;
            int mid2 = partition - mid1;
            int l1 = (mid1 - 1 >= 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 - 1 >= 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 > r2) h = mid1 - 1; else if (l2 > r1) l = mid1 + 1; else {
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(l1, l2);
                } else return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }

        return -1;
    }
}
