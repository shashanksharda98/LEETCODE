class Solution {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        for(int i = 2; i * i < arr.length; i++){
           if(arr[i] != -1){
               for(int j = i+i; j < arr.length; j+=i) arr[j] = -1;
           } 
        }
        int count  = 0;
        for(int a = 2; a < arr.length; a++) if(arr[a] != -1) count++;
        return count;
    }
}