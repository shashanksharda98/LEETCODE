class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        if(num == 0) return dp;
        dp[1] = 1;
        if(num == 1) return dp;
        int mul = 2, cr_mul = 0;
        for(int i = 2; i <= num; i++){
            if(i == mul){
                dp[i] = 1;
                cr_mul = mul;
                mul *= 2;
            }else{
                dp[i] = dp[cr_mul] + dp[i-cr_mul];
            }
        }
        return dp;
    }
}