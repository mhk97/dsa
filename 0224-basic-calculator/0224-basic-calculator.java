class Solution {

    public int calculate(String s) {
        int number = 0, sign = 1, res = 0;
        Stack<Integer> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                number = 0;
                sign = 1;
            } else if (c == ')') {
                number = number * sign;
                res += number;

                int os = stack.pop();
                int onum = stack.pop();

                res = res * os + onum;

                number = 0;
                sign = 1;
            } else if (c == '+') {
                number = number * sign;
                res += number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                number = number * sign;
                res += number;
                sign = -1;
                number = 0;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                number = number * 10 + num;
            }
        }

        number = number * sign;
        res += number;

        return res;
    }
}
