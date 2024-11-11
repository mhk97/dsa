class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String str: strs){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);

            String key = Arrays.toString(arr);
            map.computeIfAbsent(key, a -> new ArrayList()).add(str);
        }

        return new ArrayList(map.values());
    }
}