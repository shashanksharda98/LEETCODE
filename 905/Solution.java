class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = 0;
        while(j < A.length){
            if(A[j] % 2 == 0){
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i++;
            }
            j++;
        }
        return A;
    }
}