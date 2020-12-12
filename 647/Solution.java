class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int col = i;
            for(int j = 0; j < s.length() - i; j++){
                if(i == 0){
                    dp[j][col] = true;
                    ans++;
                }else{
                    if(s.charAt(j) == s.charAt(col)){
                        if(i == 1){
                            dp[j][col] = true;
                            ans++;
                        }else{
                            if(dp[j+1][col-1]){
                                dp[j][col] = true;
                                ans++;
                            }
                        }
                    }
                }
                col++;
            }
        }
        return ans;
    }
}