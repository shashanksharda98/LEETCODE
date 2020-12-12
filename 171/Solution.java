class Solution {
    public int titleToNumber(String s) {
        int mul = 1, ans = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            ans += ((ch - 'A' + 1) * mul);
            mul *= 26;
        }
        return ans;
    }
}