class Solution {

    public int minNumberOperations(int[] target) {
        int operations = target[0], prev = 0, curr = 0;

        for (int i = 1; i < target.length; i++) {
            curr = target[i];
            prev = target[i - 1];

            if (curr > prev) {
                operations += (curr - prev);
            }
        }

        return operations;
    }
}
