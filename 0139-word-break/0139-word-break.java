class Solution {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        for (String w : wordDict) set.add(w);
        Boolean[] cache = new Boolean[s.length() + 1];
        return solve(s, set, 0, cache);
    }

    public static boolean solve(String s, Set<String> set, int i, Boolean cache[]) {
        if (i >= s.length()) return true;
        if (set.contains(s)) return true;

        if (cache[i] != null) return cache[i];

        for (int l = i + 1; l <= s.length(); l++) {
            String temp = s.substring(i, l);
            if (!set.contains(temp)) continue;
            if (solve(s, set, l, cache) == true) return cache[i] = true;
        }

        return cache[i] = false;
    }
}
