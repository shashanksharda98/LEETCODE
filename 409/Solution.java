class Solution {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch < 97) upper[ch -'A']++;
            else lower[ch - 'a']++;
        }
        int ans = 0;
        boolean f = false;
        for(int i = 0; i < 26; i++){
            if(upper[i] % 2 == 0) ans += upper[i];
            else{
                if(upper[i] >= 3) ans += (upper[i]-1);
                f = true;
            }
            
            if(lower[i] % 2 == 0) ans += lower[i];
            else{
                if(lower[i] >= 3) ans += (lower[i] - 1);
                f = true;
            }
        }
        ans = f ? ans+1 : ans;
        return ans;
    }
}