class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[i].length - 1; j >= 0; j--){
                if((j == matrix[i].length - 1 || i == matrix.length - 1) && matrix[i][j] == 1){
                    dp[i][j] = 1;
                    count++;
                }else{
                    if(matrix[i][j] == 1){
                        dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1])) + 1;
                        count += dp[i][j];
                    }
                }
            }
        }
        return count;
    }
}