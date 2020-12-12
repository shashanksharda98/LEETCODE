class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for(int i = 1; i < nums.length; i++) ans[i] = nums[i]*ans[i-1];
        int suffix_prod = nums[nums.length-1];
        ans[ans.length - 1] = ans[ans.length - 2];
        for(int i = ans.length - 2; i >= 0; i--){
            if(i == 0) ans[0] = suffix_prod;
            else{
                ans[i] = ans[i-1]*suffix_prod;
                suffix_prod *= nums[i];
            }
        }
        return ans;
    }
}