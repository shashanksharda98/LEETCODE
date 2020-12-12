class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i = 0, j = 0;
        int ans = 0, prev_valid = 0;
        while(i < A.length){
            if(A[i] >= L && A[i] <= R){
                ans += (i-j+1);
                prev_valid = (i-j+1);
            }else if(A[i] < L){
                ans += prev_valid;
            }else if(A[i] > R){
                j = i+1;
                prev_valid = 0;
            }
            i++;
        }
        return ans; 
    }
}