class Solution {
    public String mergeAlternately(String word1, String word2) {
      int m = word1.length(), n = word2.length(),i=0, j=0, cnt = 0;
      StringBuilder sb = new StringBuilder();
      while(i<m && j<n){
            if(cnt%2 == 0){
                sb.append(word1.charAt(i++));
            }else{
                sb.append(word2.charAt(j++));
            }
            cnt++;
      }

      while(i<m){
        sb.append(word1.charAt(i++));
      }

    while(j<n){
        sb.append(word2.charAt(j++));
      }

      return sb.toString();
    }
}