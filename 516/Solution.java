class Solution {
    public int longestPalindromeSubseq(String s) {
        // int[][] dp = new int[s.length()][s.length()];
        // for(int i = 0; i < s.length(); i++){
        //     int col = i;
        //     for(int j = 0; j < s.length() - i; j++){
        //         if(i == 0){
        //             dp[j][col] = 1;
        //         }else{
        //            if(s.charAt(j) == s.charAt(col)){
        //                if(i == 1) dp[j][col] = 2;
        //                else{
        //                    dp[j][col] = 2 + dp[j+1][col-1];
        //                }
        //            }else{
        //                dp[j][col] = Math.max(dp[j][col-1], dp[j+1][col]);
        //            } 
        //         }
        //         col++;
        //     }
        // }
        // return dp[0][s.length() - 1];
        return rec_mem(s, new int[s.length()][s.length()], 0, s.length() - 1);
    }
    public int rec_mem(String s, int[][] dp, int i, int j){
        if(i > j) return 0;
        if(i == j) return dp[i][j] = 1;
        if(dp[i][j] != 0) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = (2 + rec_mem(s, dp, i+1, j-1));
        }
        else return dp[i][j] = Math.max(rec_mem(s,dp, i+1, j), rec_mem(s,dp, i,j-1));
    }
}