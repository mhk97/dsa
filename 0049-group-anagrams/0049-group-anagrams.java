class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String st: strs){
            int[] arr = new int[26];
            for(char c: st.toCharArray()) arr[c-'a']++;

            String key = Arrays.toString(arr);
            map.computeIfAbsent(key, k-> new ArrayList()).add(st);
        }

        return new ArrayList(map.values());
    }
}