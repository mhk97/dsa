class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 3 && arr[1] > arr[0] && arr[2] < arr[1]) return 1;

        int l = 1, h = arr.length - 2;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int p = arr[mid - 1], n = arr[mid + 1], mv = arr[mid];
            if (mv > p && mv > n) return mid; else if (mv < p && mv > n) h = mid - 1; else l = mid + 1;
        }

        return l;
    }
}
