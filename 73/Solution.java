class Solution {
    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i < rows.length; i++){
            if(rows[i] != 0) for(int a = 0; a < matrix[i].length; a++) matrix[i][a] = 0;
        }
        for(int i = 0; i < col.length; i++){
            if(col[i]!= 0) for(int a = 0; a < matrix.length; a++) matrix[a][i] = 0;
        }
    }
}