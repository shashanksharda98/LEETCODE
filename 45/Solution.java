class Solution {
    public int jump(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = ans.length - 2; i >= 0; i--){
            if(nums[i] + i >= nums.length-1) ans[i] = 1;
            else if(nums[i] != 0){
                int min = Integer.MAX_VALUE;
                boolean f = false;
                for(int j = 1; j <= nums[i]; j++){
                    if(i+j >= ans.length -1) break;
                     if(ans[i+j] != 0){ 
                        min = Math.min(min, ans[i+j]);
                         f = true;
                     }
                }
                if(f)ans[i] = min + 1;
            }
        }
        return ans[0];
    }
}