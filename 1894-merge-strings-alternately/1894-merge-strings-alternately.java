class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int m = word1.length(), n = word2.length(), i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (k % 2 == 0) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
            k++;
        }

        while (i < m) {
            sb.append(word1.charAt(i++));
        }

        while (j < n) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}
