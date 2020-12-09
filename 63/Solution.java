class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dir = {{0,1}, {1,0}};
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // return sol_rec(0, 0, obstacleGrid.length - 1, obstacleGrid[0].length -1, obstacleGrid, dir, dp);
        return sol_dp(0, 0, obstacleGrid.length - 1, obstacleGrid[0].length -1, obstacleGrid, dir, dp);
    }
    public int sol_rec(int sr, int sc, int er, int ec, int[][] obst, int[][] dir, int[][] dp){
        if(obst[sr][sc] == 1) return dp[sr][sc] = 0;
        if(sr == er && sc == ec) return dp[sr][sc] = 1;
        if(dp[sr][sc] != 0) return dp[sr][sc];
        int ans = 0;
        for(int[] ar: dir){
            int r = sr + ar[0];
            int c = sc + ar[1];
            if(r <= er && c <= ec && obst[r][c] != 1){
                ans += sol_rec(r, c, er, ec, obst, dir, dp);
            }
        }
        return dp[sr][sc] = ans;
    }
    public int sol_dp(int sr, int sc, int er, int ec, int[][] obst, int[][] dir, int[][] dp){
        for(sr = er; sr >= 0; sr--){
            for(sc = ec; sc >= 0; sc--){
                if(obst[sr][sc] == 1) dp[sr][sc] = 0;
                else if(sr == er && sc == ec) dp[sr][sc] = 1;
                //if(dp[sr][sc] != 0) return dp[sr][sc];
                else{
                     int ans = 0;
                     for(int[] ar: dir){
                        int r = sr + ar[0];
                        int c = sc + ar[1];
                        if(r <= er && c <= ec && obst[r][c] != 1){
                            ans +=  dp[r][c];
                        }
                    }
                    dp[sr][sc] = ans;
                }
            }
        }
        return dp[0][0];
    }
}