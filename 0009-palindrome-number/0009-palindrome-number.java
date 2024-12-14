class Solution {

    public boolean isPalindrome(int x) {
        int og = x, num = 0;

        if (x % 10 == 0 && x != 0) return false;
        if (x < 0) return false;

        while (x > num) {
            int pop = x % 10;
            x = x / 10;
            num = num * 10 + pop;
        }

        return x == num || x  == num / 10;
    }
}
