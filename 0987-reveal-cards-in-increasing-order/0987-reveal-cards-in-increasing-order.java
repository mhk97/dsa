class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];

        Arrays.sort(deck);

        int ri = 0, di = 0, skip = 0, n = deck.length;
        while (di < n) {
            if (res[ri % n] == 0) {
                if (skip == 0) {
                    res[ri % n] = deck[di++];
                }
                skip = 1 - skip;
            }
            ri++;
        }

        return res;
    }
}
