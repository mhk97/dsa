class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (String s : tokens) {
            if (s.equals("+")) {
                int y = stack.pop(), x = stack.pop();
                stack.push(x + y);
            } else if (s.equals("-")) {
                int y = stack.pop(), x = stack.pop();
                stack.push(x - y);
            } else if (s.equals("*")) {
                int x = stack.pop(), y = stack.pop();
                stack.push(x * y);
            } else if (s.equals("/")) {
                int y = stack.pop(), x = stack.pop();
                stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
