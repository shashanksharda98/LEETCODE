class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int i = 0, j = A.length-1, k = A.length-1;
        while(i <= j){
            if(A[i]*A[i] > A[j]*A[j]){
                ans[k--] = A[i]*A[i];
                i++;
            }else{
                ans[k--] = A[j]*A[j];
                j--;
            }
        }
        return ans;
    }
}