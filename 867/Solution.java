class Solution {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                    ans[i][j] = A[j][i];
                
            }
        }
        return ans;
    }
}