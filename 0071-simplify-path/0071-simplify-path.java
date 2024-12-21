class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (s.equals(".") || s.equals("")) continue; else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(s);
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
