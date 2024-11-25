class Solution {

    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int i=0; i< 26; i++){
            if(arr[i] > 0) pq.offer(new int[]{arr[i], (i+'a')});
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length()-1) !=  (char) first[1]){
                sb.append((char)first[1]);
                first[0]--;
                if(first[0] > 0) pq.offer(first);
            }else{
                if(pq.isEmpty()) return "";
                int[] sec = pq.poll();
                sb.append((char)sec[1]);
                sec[0]--;
                if(sec[0] > 0) pq.offer(sec);

                pq.offer(first);
            }
        }

        return sb.toString();
    }
}
