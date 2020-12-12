class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if(dp.length == 0) return 0;
        dp[0] = 1;
        // int a = 0, b = 0;
        // for(Integer n: nums){
        //     if(b == 0){
        //         dp[b++] = n;
        //     }else{
        //         if(n > dp[b-1]) dp[b++] = n;
        //         else{
        //             int lo = a, hi = b;
        //             while(lo < hi){
        //                 int mid = lo + (hi-lo)/2;
        //                 if(n < dp[mid]) hi = mid;
        //                 else if(n > dp[mid]) lo = mid;
        //                 if(mid == lo){
        //                     dp[lo] = n;
        //                     break;
        //                 }else if(hi == mid){
        //                     dp[hi] = n;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        // }
        // return b;
        int f_max = 1;
        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            f_max = Math.max(f_max, dp[i]);
        }
        return f_max;
    }
}