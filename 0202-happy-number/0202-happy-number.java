class Solution {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        set.add(n);

        while (true) {
            int x = generateNumber(n);
            if (x == 1) return true;

            if (set.contains(x)) return false; else set.add(x);
            n = x;
        }
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
