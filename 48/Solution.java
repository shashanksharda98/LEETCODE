class Solution {
    public void rotate(int[][] matrix) {
        //transpose of a matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j <= i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int a = 0, b = matrix[i].length - 1; a < b; a++, b--){
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
            }
        }
    }
}