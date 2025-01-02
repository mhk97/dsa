class Solution {

    public String largestNumber(int[] nums) {
        String strs[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        if(strs[0].equals("0")) return "0";
        // System.out.println(Arrays.toString(strs));

        return String.join("", strs);
    }
}
