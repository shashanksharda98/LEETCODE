class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                shift(arr, i);
                i++;
            }
        }
    }
    public void shift(int[] arr, int k){
        int temp = arr[k];
        for(int j = k+1; j < arr.length; j++){
            int t = arr[j];
            arr[j] = temp;
            temp = t;
        }
    }
}