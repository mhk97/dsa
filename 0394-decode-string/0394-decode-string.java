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
                int num = (!nums.isEmpty()) ? nums.pop() : 1;
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }

                if (!stack.isEmpty()) stack.pop();

                stack.push(sb.toString().repeat(num));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}
