class Solution {

    public int[] dailyTemperatures(int[] t) {
        Stack<int[]> stack = new Stack();
        int res[] = new int[t.length];

        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= t[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek()[1] - i;
            stack.push(new int[] { t[i], i });
        }

        return res;
    }
}
