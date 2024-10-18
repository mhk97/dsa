class Solution {
    Boolean cache[][] = new Boolean[101][101];
    public boolean checkValidString(String s) {
        return solve(s, 0, 0);
    }

    public boolean solve(String s, int i, int open){
        if(open < 0) return false;
        if(i>= s.length()) return open == 0; 
        if(cache[i][open] != null) return cache[i][open];
        char c = s.charAt(i);
        if(c == '(') return cache[i][open] = solve(s, i+1, open+1);
        else if(c == ')') return cache[i][open] = solve(s, i+1, open -1);
        else{
            return cache[i][open] = solve(s, i+1, open+1) || 
            solve(s, i+1, open-1) ||
            solve(s, i+1, open);
        }
    }
}