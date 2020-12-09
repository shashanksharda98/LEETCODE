class Solution {
    public boolean canJump(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums.length <= 1) return true;
        for(int i = 0; i < nums.length; i++){
            if(i + nums[i] > max) max = i+nums[i];
            if(max <= i && nums[i] == 0) return false;
            if(max >= nums.length -1) return true;
        }
        return false;
    }
    
}