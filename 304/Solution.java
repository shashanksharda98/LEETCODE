class NumMatrix {
    int[][] arr;

    public NumMatrix(int[][] matrix) {
        this.arr = matrix;
        if(matrix.length != 0 && matrix[0].length != 0){
            for(int i = 1; i < matrix[0].length; i++){
                for(int j = 0; j < matrix.length; j++){
                    arr[j][i] += arr[j][i-1];
                }
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if(col1 == 0){
            for(int a = row1; a <= row2; a++){
                sum += arr[a][col2];
            }
        }else{
            for(int a = row1; a <= row2; a++){
                sum += (arr[a][col2] - arr[a][col1-1]);
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */