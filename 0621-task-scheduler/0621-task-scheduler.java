class Solution {

    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int[26];
        for (char c : tasks) arr[c - 'A']++;

        Arrays.sort(arr);

        int gap = arr[arr.length - 1] - 1;
        int idle = gap * (n), i = arr.length - 2;

        while (i>=0 && arr[i] > 0) {
            int min = Math.min(gap, arr[i]);
            idle -= min;
            i--;
        }

        return (idle > 0) ? tasks.length + idle : tasks.length;
    }
}
