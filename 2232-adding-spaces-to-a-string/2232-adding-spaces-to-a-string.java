class Solution {

    public String addSpaces(String s, int[] spaces) {
        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            if (j<spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
}
