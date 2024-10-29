class Solution {

    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x % 10 == 0 || x < 0) return false;

        int temp = x, nn = 0;
        while (temp > 0) {
            nn = nn * 10 + temp % 10;
            temp /= 10;
        }
        // System.out.println(nn);
        return nn == x;
    }
}
