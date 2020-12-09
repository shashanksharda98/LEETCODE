class Solution {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    rows[i] |= (1 << (board[i][j] - '1'));
                    cols[j] |= (1 << (board[i][j] - '1'));
                    grid[i/3][j/3] |= (1 << (board[i][j] - '1'));
                }
            }
        }
        boolean ans = solve(0, 0, rows, cols, grid, board);
        return;
    }
    public boolean solve(int r, int c, int[] rows, int[] cols, int[][] grid, char[][] board){
        if(r >= board.length) return true;
        int nr = (c == 8)? r+1 : r;
        int nc = (c == 8)? 0 : c+1;
        if(board[r][c] == '.'){
          for(int i = 0; i < 9; i++){
              int mask = (1 << i);
              if((rows[r] & mask) != mask && (cols[c] & mask) != mask && (grid[r/3][c/3] & mask) != mask){
                  board[r][c] = (char)('1' + i);
                  rows[r] ^= mask;
                  cols[c] ^= mask;
                  grid[r/3][c/3] ^= mask;
                  if(solve(nr, nc, rows, cols, grid, board)) return true;
                  board[r][c] = '.';
                  rows[r] ^= mask;
                  cols[c] ^= mask;
                  grid[r/3][c/3] ^= mask;
              }
          }  
        }else{
            if(solve(nr, nc, rows, cols, grid, board)) return true;
        }
        return false;
    }
}