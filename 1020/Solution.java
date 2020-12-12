class Solution {
    public int numEnclaves(int[][] A) {
        for(int i = 0; i < A[0].length; i++){
            if(A[0][i] != 0){
                dfs(0, i, A);
            }
            if(A[A.length-1][i] != 0) dfs(A.length - 1, i, A);
        }
        for(int i = 0; i < A.length; i++){
            if(A[i][0] != 0) dfs(i, 0, A);
            if(A[i][A[i].length - 1] != 0) dfs(i, A[i].length - 1, A);
        }
        return count(A);
    }
    public void dfs(int i, int j, int[][] A){
        if(i < 0 || i >= A.length || j < 0 || j >= A[i].length || A[i][j] == 0) return;
        A[i][j] = 0;
        dfs(i+1, j, A);
        dfs(i-1, j, A);
        dfs(i, j+1, A);
        dfs(i, j-1, A);
    }
    public int count(int[][] A){
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] == 1) ans++;
            }
        }
        return ans;
    }
}