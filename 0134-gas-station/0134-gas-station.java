class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGain = 0, totalGain = 0, answer = 0;

        for (int i = 0; i < cost.length; i++) {
            totalGain += gas[i] - cost[i];
            currentGain += gas[i] - cost[i];

            if (currentGain < 0) {
                currentGain = 0;
                answer = i + 1;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }
}
