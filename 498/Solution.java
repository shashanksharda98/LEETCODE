class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int[] ans = new int[matrix.length * matrix[0].length];
        int idx = 0;
        // for(int diag = 0; diag <= (matrix.length - 1 + matrix[0].length - 1); diag++){
        //     if(diag % 2 == 0){
        //         for(int i = diag, j = 0; i >= 0; i--, j++){
        //             if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)ans[idx++] = matrix[i][j];
        //         }
        //     }else{
        //         for(int i = 0, j = diag; i <= diag; i++, j--){
        //             if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)ans[idx++] = matrix[i][j];
        //         }
        //     }
        // }
        // return ans;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(!map.containsKey(i+j)){
                    map.put(i+j, new ArrayList<>());
                    map.get(i+j).add(matrix[i][j]);
                }else{
                    map.get(i+j).add(matrix[i][j]);
                }
            }
        }
        for(int diag = 0; diag <= (matrix.length - 1 + matrix[0].length - 1); diag++){
            if(diag % 2 == 0){
                ArrayList<Integer> t = map.get(diag);
                for(int j = t.size() - 1; j >= 0; j--) ans[idx++] = t.get(j);
            }else{
                for(Integer n: map.get(diag)) ans[idx++] = n;
            }
        }
        return ans;
    }
}