class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int running_sum = 0, i = 0, j = 0, ans = Integer.MAX_VALUE;
        while(j < nums.length){
            running_sum += nums[j];
            
            if(running_sum >= s){
                while(running_sum >= s){
                    ans = Math.min(ans, j-i+1);
                    running_sum -= nums[i++];
                }
            }
            j++;
        }
        
        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}