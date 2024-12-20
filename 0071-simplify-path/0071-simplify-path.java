class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (s.equals(".") || s.equals("")) continue; else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(s);
        }

        Stack<String> revStack = new Stack();
        while (!stack.isEmpty()) revStack.push(stack.pop());

        StringBuilder sb = new StringBuilder("/");
        while (!revStack.isEmpty()) {
            sb.append(revStack.pop());
            if (!revStack.isEmpty()) sb.append("/");
        }

        return sb.toString();
    }
}
