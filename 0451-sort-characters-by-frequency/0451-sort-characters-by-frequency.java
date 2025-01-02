class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        int max = 0;

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(map.get(c), max);
        }

        List<Character>[] temp = new ArrayList[max + 1];

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            char key = entry.getKey();

            List<Character> curr = (temp[value] != null) ? temp[value] : new ArrayList();
            curr.add(key);
            temp[value] = curr;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            List<Character> curr = temp[i];
            if (curr == null) continue;
            for (char c : curr) {
                String t = c + "";
                String str = t.repeat(i);
                sb.append(str);
            }
        }

        return sb.toString();
    }
}
