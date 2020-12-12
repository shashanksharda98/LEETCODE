class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==  0) return 0;
        int[] dp = new int[amount +1];
        //Arrays.sort(coins);
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j+coins[i] <= amount; j++){
                if(j == 0){
                    if(dp[j+coins[i]] == 0) dp[j+coins[i]] = 1;
                    else dp[j+coins[i]] = Math.min(dp[j+coins[i]], 1);
                }else{
                     if(dp[j] != 0){
                         if(dp[j+coins[i]] == 0) dp[j+coins[i]] = dp[j]+1;
                         else dp[j+coins[i]] = Math.min(dp[j+coins[i]], dp[j]+1);
                     }
                }
            }
        }
        if(dp[amount] == 0)return -1;
        return dp[amount];
    }
}