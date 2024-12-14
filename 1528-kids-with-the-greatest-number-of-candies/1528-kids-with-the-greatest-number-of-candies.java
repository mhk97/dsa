class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int ec) {
        List<Boolean> res = new ArrayList();
        int max = Integer.MIN_VALUE;
        for (int i : candies) max = Math.max(max, i);
        for (int i : candies) {
            if (i + ec >= max) res.add(true); else res.add(false);
        }

        return res;
    }
}
