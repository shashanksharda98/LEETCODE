class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dir = {{0, 1}, {1, 0}};
        int[][] dp = new int[grid.length][grid[0].length];
        return min_mem(0, 0, grid.length -1, grid[0].length -1, grid, dir, dp);
    }
    
    public int min_mem(int sr, int sc, int er, int ec, int[][] grid, int[][] dir, int[][] dp){
        if(sr == er && sc == ec) return dp[sr][sc] = grid[sr][sc];
        if(dp[sr][sc] != 0) return dp[sr][sc];
        
        int min_val = Integer.MAX_VALUE;
        for(int[] ar: dir){
            int r = sr + ar[0];
            int c = sc + ar[1];
            if(r >= 0 && r <= er && c >= 0 && c <= ec){
                min_val = Math.min(min_val, min_mem(r, c, er, ec, grid, dir, dp));
            }
        }
        if(min_val != Integer.MAX_VALUE) return dp[sr][sc] = min_val + grid[sr][sc];
        else return grid[sr][sc]; 
    }
}