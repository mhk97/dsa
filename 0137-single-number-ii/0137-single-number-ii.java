class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;

        for(int i=0; i<32; i++){
            int sum =0;
            for(int k: nums){
                sum+= (k>>i) &1;
            }

            int y = sum %3;
            x = x| (y<<i);
        }

        return x;
    }
}