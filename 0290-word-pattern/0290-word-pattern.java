class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        HashMap map = new HashMap();
        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map.containsKey(c)) map.put(c, i);
            if (!map.containsKey(w)) map.put(w, i);

            if (map.get(c) != map.get(w)) return false;
        }

        return true;
    }
}
