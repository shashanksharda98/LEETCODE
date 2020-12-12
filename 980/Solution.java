class Solution {
    public int uniquePathsIII(int[][] grid) {
        int a = -1, b = -1, c = 0;
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    a = i;
                    b = j;
                }
                if(grid[i][j] == -1) c++;
            }
        }
        //grid[a][b] = -1;
        return solve(a, b, c, grid, dir);
    }
    public int solve(int sr, int sc, int count, int[][] grid, int[][] dir){
        if(grid[sr][sc] == 2){
            if(count == (grid.length * grid[0].length) - 1) return 1;
            return 0;
        }
        //if(dp[sr][sc] != 0) return dp[sr][sc];
        int ans = 0;
        grid[sr][sc] = -1;
        for(int[] ar: dir){
            int r = sr + ar[0];
            int c = sc + ar[1];
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1){
                ans += solve(r, c, count+1, grid, dir);
            }
        }
        grid[sr][sc] = 0;
        return ans;
    }
}