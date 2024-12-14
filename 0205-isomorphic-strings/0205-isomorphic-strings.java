class Solution {

    public String create(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (!map.containsKey(temp)) map.put(temp, i);

            sb.append(Integer.toString(map.get(temp)));
            sb.append("#");
        }
        // System.out.println(sb.toS);
        return sb.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        return create(s).equals(create(t));
    }
}
