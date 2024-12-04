class MinStack {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(val);
        } else if (val < min) {
            stack.push(2 * val - min);
            min = val;
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek() < min) {
            int curr = stack.pop();
            min = 2 * min - curr;
        } else stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        if (stack.peek() < min) return min; else return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
