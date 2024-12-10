public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, place = 31;
        while (n != 0) {
            res += (n & 1) << place;
            n = n >>> 1;
            place -= 1;
        }

        return res;
    }
}
