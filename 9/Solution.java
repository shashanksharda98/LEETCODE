class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int pallindrome = 0;
        int temp = x;
        while(temp != 0){
            pallindrome = pallindrome * 10 + (temp % 10);
            temp/= 10;
        }
        return pallindrome == x ? true : false;
    }
}