class Solution {
    Integer cache[][];

    public int minDistance(String word1, String word2) {
        cache = new Integer[word1.length()][word2.length()];
        return solve(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    public int solve(String s1, String s2, int i, int j) {
        if (i < 0 && j < 0) return 0;

        if (i < 0) return j + 1;

        if (j < 0) return i + 1;

        if (cache[i][j] != null) return cache[i][j];

        if (s1.charAt(i) == s2.charAt(j)) return cache[i][j] = 0 + solve(s1, s2, i - 1, j - 1);

        return (
            cache[i][j] =
                Math.min(
                    1 + solve(s1, s2, i - 1, j - 1), //replace
                    Math.min(
                        1 + solve(s1, s2, i, j - 1), //add
                        1 + solve(s1, s2, i - 1, j) //delete
                    )
                )
        );
    }
}
