class Solution {

    List<List<String>> res = new ArrayList();

    public List<List<String>> partition(String s) {
        solve(s, new ArrayList<String>(), 0);
        return res;
    }

    public void solve(String s, List<String> temp, int index){
        if(index >= s.length()){
            res.add(new ArrayList(temp));
            return;
        }

        for(int i = index; i< s.length(); i++){
            if(checkPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                solve(s, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean checkPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!= s.charAt(end--)) return false;
        }
        return true;
    }
}