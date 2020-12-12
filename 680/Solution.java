class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return check(i+1, s, j) || check(i, s, j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean check(int i, String s, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}