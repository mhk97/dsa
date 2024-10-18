class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int glen=g.length, slen= s.length, count = 0, i=0, j=0;

        while(i<glen && j<slen){
            if(s[j] >= g[i]){
                i++;
                j++;
                count++;
            }else{
                j++;
            }
        }

        return count;
    }
}