class Solution {

    public void nextPermutation(int[] nums) {
        int breakPt = Integer.MAX_VALUE;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPt = i;
                break;
            }
        }

        if(breakPt == Integer.MAX_VALUE) {
            reverse(nums, -1);
            return;
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i > breakPt; i--) {
            if (nums[i] > nums[breakPt]) {
                minIndex = i;
                break;
            }
        }
        

        swap(nums, breakPt, minIndex);

        reverse(nums, breakPt);
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int bp) {
        int i = bp + 1, j = nums.length - 1;
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
