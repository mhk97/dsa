class Solution {
    public boolean isPalindrome(int temp) {
        int res = 0;

        if((temp %10 == 0 && temp != 0) || temp < 0) return false;

        while(temp>res){
            res = res*10 + temp%10;
            temp = temp/10;
        }

        return res == temp || temp == res/10;

    }
}