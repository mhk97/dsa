class Solution {

    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int arr[] = new int[max - min + 1];

        for (int i : nums) arr[i - min]++;

        for (int i = arr.length - 1; i >= 0; i--) {
            k -= arr[i];
            if (k <= 0) return i + min;
        }

        return -1;
    }
}
