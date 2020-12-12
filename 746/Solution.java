class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp = new int[cost.length];
        // dp[0] = 0;
        // dp[1] = 0;
        // for(int i = 2; i < cost.length; i++){
        //     dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        // }
        // return Math.min(dp[dp.length-1] + cost[cost.length-1], dp[dp.length-2] + cost[cost.length-2]);
        int a = 0, b = 0;
        for(int i = 2; i < cost.length; i++){
            int c = Math.min(a + cost[i-2], b + cost[i-1]);
            a = b;
            b = c;
        }
        return Math.min(a + cost[cost.length-2], b + cost[cost.length-1]);
    }
}