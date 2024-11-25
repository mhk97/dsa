class Solution {

    public int trap(int[] input) {
        int n = input.length;
        int lMax[] = new int[n];
        int[] rMax = new int[n];

        lMax[0] = 0;
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(input[i - 1], lMax[i - 1]);
        }

        rMax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(input[i + 1], rMax[i + 1]);
        }

        int res = 0;

        for(int i=0; i< n; i++){
            int currMin = Math.min(lMax[i], rMax[i]);
            int curr = currMin - input[i];
            if(curr>0) res+=curr;
        }



        return res;
    }
}
