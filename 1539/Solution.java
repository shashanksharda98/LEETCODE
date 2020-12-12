class Solution {
    public int findKthPositive(int[] arr, int k) {
        int prev = 0;
        for(int v: arr){
            int temp = v - prev - 1;
            if(k - temp <= 0) return prev+k;
            k -= temp;
            prev = v;
        }
        return prev+k;
        
        
        
        
        
        
        
        
        
        
        
        
        
        // HashSet<Integer> set = new HashSet<>();
        // for(int n: arr){
        //     set.add(n);
        // }
        // int t = 0, ans = 0;
        // for(int i = 1; t != k; i++){
        //     if(!set.contains(i)){
        //         ans = i;
        //         t++;
        //     }
        // }
        // return ans;
    }
}