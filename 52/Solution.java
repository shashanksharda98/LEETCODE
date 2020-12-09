class Solution {
    public int totalNQueens(int n) {
        int[][] chess = new int[n][n];
        return NQueensans(chess, 0);
    }
    public int NQueensans(int[][] chess, int row){
        if(row == chess.length) return 1;
        int ans = 0;
        for(int col = 0; col < chess[row].length; col++){
            if(isSafe(chess, row, col)){
                chess[row][col] = 1;
                ans += NQueensans(chess, row + 1);
                chess[row][col] = 0;
            }
        }
        return ans;
    }
    public boolean isSafe(int[][] chess, int row, int col){
        for(int i = col; i >= 0; i--) if(chess[row][i] == 1) return false;
        for(int i = row; i >= 0; i--) if(chess[i][col] == 1) return false;
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--) if(chess[i][j] == 1) return false;
        for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++) if(chess[i][j] == 1) return false;
        return true;
            
    }
}