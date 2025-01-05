class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack();
    }

    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new int[] { price, 1 });
            return stack.peek()[1];
        }

        int pop = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            pop += stack.pop()[1];
        }

        stack.push(new int[] { price, pop });

        return stack.peek()[1];
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
