class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0, totalGas = 0, total = 0, res = 0;

        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            total = total - cost[i] + gas[i];
            if (total < 0) {
                res = i + 1;
                total = 0;
            }
        }

        if (totalCost > totalGas) return -1;
        return res;
    }
}
