class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        long res=0;

        for(int i=1; i<nums.length-1; i++){
            int max = Math.max(nums[i-1], Math.max(nums[i], nums[i+1]));

            if(max < k){
                int diff = k - max;
                nums[i-1]+= diff;
                nums[i] += diff;
                nums[i+1] += diff;
                res+=diff;
            }
        }

        return res;
    }

}