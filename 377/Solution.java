class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int v: nums){
                if(i - v >= 0) dp[i] += dp[i-v];
            }
        }
        
        
        return dp[target];
    }
}