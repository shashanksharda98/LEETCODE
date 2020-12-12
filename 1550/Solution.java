class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) return false;
        int a = 0, b = 0;
        while(b < arr.length){
            if(arr[b] % 2 != 0){
                b++;
                if(b - a == 3) return true;
            }else{
                a = b+1;
                b++;
            }
        }
        return false;
    }
}