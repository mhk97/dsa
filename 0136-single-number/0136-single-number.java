class Solution {

    public int singleNumber(int[] ints) {
        Arrays.sort(ints);

        int l = 0, r = ints.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (l == r) {
                res = ints[l];
                break;
            }
            if (mid % 2 != 0) mid--;

            if (ints[mid] == ints[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return res;
    }
}
