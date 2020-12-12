class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        for(int i = 0, j = mat.length - 1, k = 0; i < mat.length; i++, j--, k++){
            ans+= mat[i][i];
            if(j != k) ans += mat[j][k];
        }
        return ans;
    }
}