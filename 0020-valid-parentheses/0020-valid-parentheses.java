class Solution {

    public boolean isValid(String s) {
        Set<Character> set = new HashSet();
        set.add('(');
        set.add('[');
        set.add('{');

        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) stack.push(c); else {
                if (stack.isEmpty()) return false;
                if ((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[') || (c == '}' && stack.peek() != '{')) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
