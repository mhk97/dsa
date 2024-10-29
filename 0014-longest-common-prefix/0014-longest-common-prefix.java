class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        String temp = strs[0];
        for (int i = 0; i < temp.length(); i++) {
            char t = temp.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String t2 = strs[j];
                if (i>= t2.length()||t2.charAt(i) != t) return sb.toString();
            }
            sb.append(t);
        }

        return sb.toString();
    }
}
