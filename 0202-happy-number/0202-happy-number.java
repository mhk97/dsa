class Solution {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = generateNumber(n);

        while (fast != 1 && slow != fast) {
            fast = generateNumber(generateNumber(fast));
            slow = generateNumber(slow);
        }

        return fast == 1;
    }

    public int generateNumber(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            res = res + pop * pop;
            x = x / 10;
        }
        return res;
    }
}
