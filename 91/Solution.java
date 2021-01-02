class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < s.length(); i++){
            int oneDigit = Integer.parseInt(""+s.charAt(i));
            if(oneDigit != 0){
                dp[i+1] += dp[i];
            }
            int twoDigits = Integer.parseInt(s.substring(i-1,i+1));
            if(twoDigits == 0) return 0;
            if(twoDigits > 9 && twoDigits <= 26){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
