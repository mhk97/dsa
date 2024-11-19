class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            int temp[] = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            String key = Arrays.toString(temp);
            map.computeIfAbsent(key, k -> new ArrayList()).add(s);
        }

        return new ArrayList(map.values());
    }
}
