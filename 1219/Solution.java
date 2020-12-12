class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int tempans = getMax(grid, i, j);
                if(tempans > ans) ans = tempans;
            }
        }
        return ans;
    }
    public int getMax(int[][] grid, int r, int c){
        if(r == grid.length || r <0 || c < 0 || c == grid[0].length || grid[r][c] == 0) return 0;
        int temp = grid[r][c];
        grid[r][c] = 0;
        int a = getMax(grid, r -1, c);
        int b = getMax(grid, r +1, c);
        int c3 = getMax(grid, r, c+1);
        int d = getMax(grid, r, c-1);
        grid[r][c] = temp;
        return temp + Math.max(a, Math.max(b, Math.max(c3,d)));
    }
}