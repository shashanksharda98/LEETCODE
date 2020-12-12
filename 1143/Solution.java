class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = text1.length(); i >= 0; i--){
            for(int j = text2.length(); j >= 0; j--){
                if(i == text1.length() || j == text2.length()) dp[i][j] = 0;
                else{
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}