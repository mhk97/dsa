class Solution {

    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack();
        for (int i : a) {
            if (i > 0) stack.push(i); else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(i)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                }
            }
        }

        int res[] = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}
