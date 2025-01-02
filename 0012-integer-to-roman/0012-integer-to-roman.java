class Solution {

    public String intToRoman(int num) {
        List<Pair<Integer, String>> list = Arrays.asList(
            new Pair(1000, "M"),
            new Pair(900, "CM"),
            new Pair(500, "D"),
            new Pair(400, "CD"),
            new Pair(100, "C"),
            new Pair(90, "XC"),
            new Pair(50, "L"),
            new Pair(40, "XL"),
            new Pair(10, "X"),
            new Pair(9, "IX"),
            new Pair(5, "V"),
            new Pair(4, "IV"),
            new Pair(1, "I")
        );

        StringBuilder sb = new StringBuilder();

        for (Pair<Integer, String> p : list) {
            if (num == 0) break;

            int k = p.getKey();
            String v = p.getValue();

            int times = num / k;

            num = num % k;

            sb.append(v.repeat(times));
        }

        return sb.toString();
    }
}
