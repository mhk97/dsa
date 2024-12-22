class CustomStack {
    int top = -1;
    int[] arr, incr;

    public CustomStack(int ms) {
        arr = new int[ms];
        incr = new int[ms];
    }

    public void push(int x) {
        if (top < arr.length - 1) {
            arr[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) return top;
        int k = incr[top];
        if (top != 0) incr[top - 1] += k;
        int val = k + arr[top];
        incr[top] = 0;
        top--;
        return val;
    }

    public void increment(int k, int val) {
        if (top >= 0) {
            k = Math.min(k - 1, top);
            incr[k] += val;
        }
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
