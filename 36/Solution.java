class Solution {
    public boolean isValidSudoku(char[][] board) {
        return valid(0, 0, new int[9], new int[9], new int[3][3], board);
    }
    public boolean valid(int r, int c, int[] rows, int[] cols, int[][] grid, char[][] board){
        if(r >= board.length) return true;
        int nr = (c >= 8)? r+1: r;
        int nc = (c >= 8)? 0: c+1;
        if(board[r][c] == '.'){
            return valid(nr, nc, rows, cols, grid, board);
        }else{
            int mask = (1 << (board[r][c] - '1'));
            if((rows[r] & mask) != mask && (cols[c] & mask) != mask && (grid[r/3][c/3] & mask) != mask){
                rows[r] ^= mask;
                cols[c] ^= mask;
                grid[r/3][c/3] ^= mask;
                return valid(nr, nc, rows, cols, grid, board);
            }else return false;
        }
        
    }
}