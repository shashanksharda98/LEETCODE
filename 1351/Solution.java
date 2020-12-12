class Solution {
    public int countNegatives(int[][] grid) {
        return helper(grid, grid.length - 1, 0);
    }
    
    public int helper(int[][] grid, int r, int c){
        if(r < 0 || c >= grid[r].length) return 0;
        for(int i = c; i < grid[r].length; i++){
            if(grid[r][i] < 0){
                return helper(grid, r-1, i) + (grid[r].length - i); 
            }
        }
        return 0;
    }
}