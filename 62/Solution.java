class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dir = {{0,1}, {1,0}};
        // return solve_rec(0, 0, n-1, m-1, dir, new int[n][m]);
        return solve_dp(0, 0, n-1, m-1, dir, new int[n][m]);
    }
    public int solve_rec(int sr, int sc, int er, int ec, int[][] dir, int[][] dp){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != 0) return dp[sr][sc];
        int ans = 0;
        for(int[] ar : dir){
            int r = sr + ar[0];
            int c = sc + ar[1];
            
            if(r <= er && c <= ec){
                ans += solve_rec(r, c, er, ec, dir, dp);
            }
        }
        return dp[sr][sc] = ans;
        
    }
    public int solve_dp(int sr, int sc, int er, int ec, int[][] dir, int[][] dp){
        for(sr = er; sr >= 0; sr--){
            for(sc = ec; sc >= 0; sc--){
                    if(sr == er && sc == ec){
                        dp[sr][sc] = 1;
                    }
                    //if(dp[sr][sc] != 0) return dp[sr][sc];
                    else{
                        int ans = 0;
                        for(int[] ar : dir){
                            int r = sr + ar[0];
                            int c = sc + ar[1];

                            if(r <= er && c <= ec){
                                ans += dp[r][c];
                            }
                        }
                        dp[sr][sc] = ans;
                    }
            }
        }
        return dp[0][0];
    }
}