class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(b[0], a[0]));

        for(int i=0; i< points.length; i++){
            int[] p = points[i];
            long x = p[0]*p[0] + p[1]*p[1];
            pq.offer(new long[]{x, i});
            if(pq.size()>k) pq.poll();
        }

        int[][] res = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = points[(int)pq.poll()[1]];
        }

        return res;
    }
}