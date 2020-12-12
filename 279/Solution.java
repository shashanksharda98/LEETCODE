class Solution {
    public int numSquares(int n) {
        if(n <= 3) return n;
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            
            if(i*i <= n) dp[i*i] = 1;
            if(i <= 3) dp[i] = i;
            else{
                if(dp[i] != 1){
                    int a = i-1, b = 1;
                    int min = Integer.MAX_VALUE;
                    while(a >= b){
                        min = Math.min(min, dp[a] + dp[b]);
                        a--;
                        b++;
                    }
                    dp[i] = min;
                }
            }
        }
        return dp[n];
    }
}