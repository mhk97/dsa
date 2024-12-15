class Solution {

    public String decodeString(String s) {
        Stack<String> stack = new Stack();
        Stack<Integer> nums = new Stack();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = k * 10 + (c - '0');
            } else if (c != ']') {
                if (k != 0) nums.push(k);
                stack.push(String.valueOf(c));
                k = 0;
            } else {
                StringBuilder curr = new StringBuilder();
                int num = (!nums.isEmpty()) ? nums.pop() : 1;
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    curr.insert(0, stack.pop());
                }

                if (!stack.isEmpty()) stack.pop();
                stack.push(curr.toString().repeat(num));
            }
        }

        StringBuilder curr = new StringBuilder();
        while (!stack.isEmpty()) {
            curr.insert(0, stack.pop());
        }

        return curr.toString();
    }
}
