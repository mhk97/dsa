class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, h = arr.length - 2;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            int mv = arr[mid], pre = arr[mid - 1], next = arr[mid + 1];

            if (mv > pre && mv > next) return mid; else if (mv < next) l = mid + 1; else h = mid - 1;
        }

        return -1;
    }
}
