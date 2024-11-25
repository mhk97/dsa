class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        int k=0;
        for(int i[]: intervals){
            start[k] = i[0];
            end[k] = i[1];
            k++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i=0, j=0, curr=0, max = 0, n=start.length;

        while(i<n && j<n){
            if(start[i]< end[j]){
                curr++;
                max = Math.max(max, curr);
                i++;
            }else{
                curr--;
                j++;
            }
        }

        return max;
    }
}